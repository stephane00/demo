package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.repository.ItemRepository;
import com.example.demo.entity.ItemEntity;

@SpringBootTest
class ItemEntityTest {
    @Autowired
    private ItemRepository itemRepository;

    private ItemEntity item;

    item = new ItemEntity();
    item.setName("Test");
    item.setWeight(1.0);
    item.setPrice(10.0);

    @Test
    void saveItemTest() throws Exception {
        itemRepository response = itemRepository.save(item);

        assertThat(response).isNotNull();
        assertThat(response.name.equals("Test"));
    }
}