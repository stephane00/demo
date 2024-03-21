package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.config.Customizer;
import org.springframework.security.core.userdetails.User;
import javax.sql.DataSource;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;
import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
public class Security {
    @Autowired
    DataSource dataSource;

    @Bean
    public SecurityFilterChain mesautorisations(HttpSecurity http) throws Exception {
        RequestMatcher h2Matcher = new AntPathRequestMatcher("/h2-console/**");
        return http.authorizeHttpRequests((authorize) -> authorize
            .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
            .requestMatchers(antMatcher("/h2-console/**")).permitAll()
            .requestMatchers("/").hasRole("ADMIN")
            .requestMatchers("/hello").hasRole("USER")
            .antMatchers(HttpMethod.GET, "/service/**").permitAll()
            .antMatchers(HttpMethod.DELETE, "/service/**").hasRole("admin")
            .antMatchers("/service/**").hasRole("user")
            .anyRequest().authenticated()
        )
        .formLogin(Customizer.withDefaults())
        .csrf(customizer -> customizer.ignoringRequestMatchers(h2Matcher))
        .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
        .build();
    }

    @Bean
    public UserDetailsService mesutilisateurs(PasswordEncoder encoder) {
        UserDetails u1 = User.withUsername("admin")
            .password(encoder.encode("admin"))
            .roles("ADMIN")
            .build();
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.createUser(u1);
        return users;
    }


    @Bean
    @Primary
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}
