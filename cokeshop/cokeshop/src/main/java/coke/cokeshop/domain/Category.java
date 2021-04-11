package coke.cokeshop.domain;

import coke.cokeshop.domain.item.Item;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;

/**
 * 카테고리 엔티티
 * name: 카테고리 이름
 */
@Entity
@Getter
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    //상품 엔티티와 1:N 관계
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Item> items;
}
