package coke.cokeshop.repository;

import coke.cokeshop.domain.item.Item;

import java.util.List;

public interface ItemRepositoryImpl {
    void save(Item item);
    Item findById(Long id);
    List<Item> findAll();
}
