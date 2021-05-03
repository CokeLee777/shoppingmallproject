package coke.cokeshop.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;

/**
 * 주문 엔티티
 * member: 회원
 * orderItems: 주문 상품
 * delivery: 배송 정보
 * dateTime: 주문 날짜
 * status: 주문 상태
 */
@Entity
@Table(name = "orders")
@Getter @Setter(AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    //회원 엔티티와 N:1 관계
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    //주문 상품 엔티티와 1:N 관계
    @OneToMany(mappedBy = "order", cascade = ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    //배송 정보 엔티티와 1:1 관계
    @OneToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate;

    //Enum 객체
    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;

    /**
     * 연관관계 메서드
     */
    public void setMember(Member member){
        this.member = member;
        member.getOrders().add(this);
    }

    public void setDelivery(Delivery delivery){
        this.delivery = delivery;
        delivery.setOrder(this);
    }

    public void addOrderItem(OrderItem orderItem){
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    /**
     * 주문 생성 메서드
     */
    public static Order createOrder(Member member, Delivery delivery, OrderItem ... orderItems){
        Order order = new Order();
        order.setMember(member);
        order.setDelivery(delivery);
        for (OrderItem orderItem : orderItems) {
            order.addOrderItem(orderItem);
        }
        order.setStatus(OrderStatus.ORDER);
        order.setOrderDate(LocalDateTime.now());

        return order;
    }

    /**
     * 비즈니스 로직
     */

    //주문 취소
    public void cancel(){
        //배송 완료되었을 때 취소불가
        if(delivery.getStatus() == DeliveryStatus.SHIPPING ||
                delivery.getStatus() == DeliveryStatus.COMPLETE){
            throw new IllegalStateException("상품이 배송중이거나 배송완료되면 취소가 불가능합니다.");
        }

        this.setStatus(OrderStatus.CANCEL);
        for(OrderItem orderItem: orderItems){
            orderItem.cancel();
        }
    }

    /**
     * 조회 로직
     */

    //전체 주문 가격 조회
    public int getTotalPrice(){
        int totalPrice = 0;
        for(OrderItem orderItem: orderItems){
            totalPrice += orderItem.totalPrice();
        }
        return totalPrice;
    }

}
