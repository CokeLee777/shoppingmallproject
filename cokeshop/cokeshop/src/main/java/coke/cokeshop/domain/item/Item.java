package coke.cokeshop.domain.item;

import coke.cokeshop.domain.Category;
import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

/**
 * 상품 엔티티
 * name: 상품 이름
 * price: 상품 가격
 * stockQuantity: 재고수량
 * madeCompany: 만든 회사
 * releaseDate: 출시일
 */
@Entity
@Getter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;
    private String madeCompany;
    private int releaseDate;

    //카테고리 엔티티와 N:1 관계
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

}
