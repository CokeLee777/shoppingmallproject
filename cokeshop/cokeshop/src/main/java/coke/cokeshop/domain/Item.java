package coke.cokeshop.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Getter @Setter(value = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "dtype")
public class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;
    private String madeCompany;
    private String releaseDate;

    //카테고리 엔티티와 N:1 관계
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    /**
     * 비즈니스 로직
     */

    //재고 증가
    public void addStock(int quantity){
        this.stockQuantity += quantity;
    }

    //재고 감소
    public void removeStock(int quantity){
        int restQuantity = this.stockQuantity - quantity;
        //재고가 없다면
        if(restQuantity < 0){
            throw new IllegalStateException("상품 재고가 부족합니다");
        }

        this.stockQuantity = restQuantity;
    }

    /**
     * 생성 메서드
     */

    //상품 생성 메서드
    public static Item createItem(String name, int price, int stockQuantity, String madeCompany, String releaseDate){
        Item item = new Item();
        item.setName(name);
        item.setPrice(price);
        item.setStockQuantity(stockQuantity);
        item.setMadeCompany(madeCompany);
        item.setReleaseDate(releaseDate);

        return item;
    }

    //상품 수정 메서드
    public void updateItem(Item item, String name, int price, int stockQuantity, String madeCompany, String releaseDate){
        item.setName(name);
        item.setPrice(price);
        item.setStockQuantity(stockQuantity);
        item.setMadeCompany(madeCompany);
        item.setReleaseDate(releaseDate);
    }

}
