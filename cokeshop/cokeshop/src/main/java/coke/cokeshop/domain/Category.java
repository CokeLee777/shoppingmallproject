package coke.cokeshop.domain;

import coke.cokeshop.domain.item.Item;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Item> items;
}
