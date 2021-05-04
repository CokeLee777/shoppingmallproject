package coke.cokeshop.repository;

import coke.cokeshop.domain.Order;
import coke.cokeshop.dto.order.OrderSearchDto;

import java.util.List;

public interface OrderRepository {

    void save(Order order);     //주문 저장
    Order findOneById(Long id); //주문 조회
    List<Order> findAllByString(OrderSearchDto orderSearchDto);
}
