package coke.cokeshop.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 카테고리 엔티티
 * name: 카테고리 이름
 */
@Entity
@Getter @Setter(AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    //상품 엔티티와 1:N 관계
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Item> items;

    public static Category createCategory(String name){
        Category category = new Category();
        category.setName(name);

        return category;
    }
}
