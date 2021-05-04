package coke.cokeshop.dto.order;

import coke.cokeshop.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderSearchDto {

    private String memberName;          //회원 이름
    private OrderStatus orderStatus;    //주문 상태[ORDER, CANCEL]

}
