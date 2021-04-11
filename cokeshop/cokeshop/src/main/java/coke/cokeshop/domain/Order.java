package coke.cokeshop.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDateTime;
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
@Getter
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
    private List<OrderItem> orderItems;

    //배송 정보 엔티티와 1:1 관계
    @OneToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime dateTime;

    @Enumerated(value = EnumType.STRING)
    private OrderStatus status;

    /**
     * 연관관계 메서드
     */
    private void setMember(Member member){
        this.member = member;
        member.getOrders().add(this);
    }

    private void setDelivery(Delivery delivery){
        delivery = Delivery.createDelivery(this, delivery.getAddress(), delivery.getStatus());
        this.delivery = delivery;
    }
}
