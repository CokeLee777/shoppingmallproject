package coke.cokeshop.service;

public interface OrderService {
    Long Order(Long memberId, Long ItemId, int count);
    void cancelOrder(Long orderId);
}
