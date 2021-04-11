package coke.cokeshop.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(value = EnumType.STRING)
    private DeliveryStatus status;

    /**
     * 배송 생성 메서드
     */
    public static Delivery createDelivery(Order order, Address address, DeliveryStatus status){
        Delivery delivery = new Delivery();
        delivery.order = order;
        delivery.address = address;
        delivery.status = status;

        return delivery;
    }

}
