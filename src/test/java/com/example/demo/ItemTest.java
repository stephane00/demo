package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
public class ItemTest {
    @Autowired
    private ItemRepository itemRepository;

    private ItemEntity entity;

    entity = new ItemEntity();
    entity.setName("itemTest");
    entity.setWeight(1.0);
    entity.setPrice(10.0)

    @Test
    void saveItem(ItemEntity entity) {
        ItemEntity entitySave = itemRepository.save(entity);
        assertThat(entitySave).isNotNull();
        assertThat(entitySave.getId()).isGreaterThan(0);
        assertThat(entitySave.getName()).equals("itemTest");
    }
}