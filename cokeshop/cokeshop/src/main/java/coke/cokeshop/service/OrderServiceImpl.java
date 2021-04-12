package coke.cokeshop.service;

import coke.cokeshop.domain.Order;
import coke.cokeshop.repository.MemberRepository;
import coke.cokeshop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;

    //수정중
    @Override
    @Transactional
    public Long Order(Long memberId, Long ItemId, int count) {
        return null;
    }

    @Override
    @Transactional
    public void cancelOrder(Long orderId) {
        Order order = orderRepository.findOneById(orderId);
        order.cancel();
    }
}
