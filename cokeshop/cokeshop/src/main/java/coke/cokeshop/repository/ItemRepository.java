package coke.cokeshop.repository;

import coke.cokeshop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository implements ItemRepositoryImpl{

    private final EntityManager em;

    @Override
    public void save(Item item) {
        if(item.getId() == null){
            em.persist(item);
        } else {
            em.merge(item);
        }
    }

    @Override
    public Item findById(Long id) {
        return em.find(Item.class, id);
    }

    @Override
    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }
}
