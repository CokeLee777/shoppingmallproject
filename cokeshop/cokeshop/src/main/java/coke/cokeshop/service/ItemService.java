package coke.cokeshop.service;

import coke.cokeshop.domain.Category;
import coke.cokeshop.domain.item.Item;

import java.util.List;

public interface ItemService {
    void save(Item item);
    void update(Long id, String name, int price, int stockQuantity, String madeCompany, String releaseDate, Category category);
    List<Item> findItems();
    Item findOne(Long id);
}
