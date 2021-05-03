package coke.cokeshop.service;

import coke.cokeshop.domain.Category;
import coke.cokeshop.domain.Item;
import coke.cokeshop.repository.ItemRepository;
import coke.cokeshop.repository.ItemRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{

    private final ItemRepository itemRepository;

    @Override
    @Transactional
    public void save(Item item) {
        itemRepository.save(item);
    }

    @Override
    @Transactional
    public void update(Long id, String name, int price, int stockQuantity, String madeCompany, String releaseDate) {
        Item item = itemRepository.findById(id);
        item.updateItem(item, name, price, stockQuantity, madeCompany, releaseDate);
    }

    @Override
    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item findOne(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    @Transactional
    public void secessionItem(Item item) {
        itemRepository.delete(item);
    }
}
