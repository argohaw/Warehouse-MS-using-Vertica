package com.sriram.warehouse_management.dao;

import com.sriram.warehouse_management.Model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemDao {
    Optional<Item> findById(Long id);
    List<Item> findAll();
    void save(Item item);
    void update(Item item);
    void delete(Long id);
    Optional<Item> findByName(String name);
}
