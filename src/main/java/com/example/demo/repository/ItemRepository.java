package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ItemEntity;
import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<ItemEntity, Long> {
    ItemEntity save(ItemEntity entity);

    void delete(ItemEntity entity);

    ItemEntity findFirstByName(String name);

    List<ItemEntity> findAll();

    Page<ItemEntity> findAll(Pageable page);
}