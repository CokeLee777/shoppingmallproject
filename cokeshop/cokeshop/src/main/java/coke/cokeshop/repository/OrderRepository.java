package coke.cokeshop.repository;

import coke.cokeshop.domain.Order;

public interface OrderRepository {

    void save(Order order);     //주문 저장
    Order findOneById(Long id); //주문 조회
}
