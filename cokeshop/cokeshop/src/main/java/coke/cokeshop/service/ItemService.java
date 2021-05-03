package coke.cokeshop.service;

import coke.cokeshop.domain.Category;
import coke.cokeshop.domain.Item;

import java.util.List;

public interface ItemService {
    void save(Item item);
    void update(Long id, String name, int price, int stockQuantity, String madeCompany, String releaseDate);
    List<Item> findItems();
    Item findOne(Long id);
    void secessionItem(Item item);
}
