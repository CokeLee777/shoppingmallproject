package coke.cokeshop.service;

import coke.cokeshop.domain.Order;
import coke.cokeshop.dto.order.OrderSearchDto;

import java.util.List;

public interface OrderService {
    Long order(Long memberId, Long itemId, int count);
    void cancelOrder(Long orderId);
    List<Order> findOrders(OrderSearchDto orderSearchDto);
}
