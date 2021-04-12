package coke.cokeshop.domain;

import coke.cokeshop.domain.item.Item;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

/**
 * 주문 상품 엔티티
 * orderPrice: 주문 상품 가격
 * count: 주문 상품 수량
 */
@Entity
@Getter @Setter(AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    //주문 엔티티와 N:1 관계
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    //상품 엔티티와 N:1 관계
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    private int orderPrice;
    private int count;

    /**
     * 주문 상품 생성 메서드
     */
    public static OrderItem createOrderItem(Item item, int orderPrice, int count){
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOrderPrice(orderPrice);
        orderItem.setCount(count);

        //재고 수량 없애는 메서드
        item.removeStock(count);

        return orderItem;
    }

    /**
     * 비즈니스 로직
     */

    public void cancel(){
        getItem().addStock(count);
    }

    /**
     * 조회 로직
     */

    public int totalPrice(){
        return getOrderPrice() * getCount();
    }

}
