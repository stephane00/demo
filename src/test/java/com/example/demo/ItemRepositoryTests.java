package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.repository.ItemRepository;
import com.example.demo.entity.ItemEntity;

@SpringBootTest
public class ItemRepositoryTests {
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testSave() {
        ItemEntity item = new ItemEntity();
        item.setName("Test");
        item.setWeight(1.0);
        item.setPrice(10.0);

        ItemEntity savedItem = itemRepository.save(item);

        assertThat(savedItem).isNotNull();
        assertThat(savedItem.getName().equals("Test"));
    }
}