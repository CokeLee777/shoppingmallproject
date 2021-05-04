package coke.cokeshop.repository;

import coke.cokeshop.domain.Order;
import coke.cokeshop.dto.order.OrderSearchDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository{

    private final EntityManager em;

    @Override
    public void save(Order order) {
        em.persist(order);
    }

    @Override
    public Order findOneById(Long id) {
        return em.find(Order.class, id);
    }

    /**
     * JPQL 권장 X
     * 추후에 Query DSL 로 변경할 예정
     */
    @Override
    public List<Order> findAllByString(OrderSearchDto orderSearchDto) {

        String jpql = "select o from Order o join o.member m";
        boolean isFirstCondition = true;

        //주문 상태 검색
        if(orderSearchDto.getOrderStatus() != null){
            if(isFirstCondition){
                jpql += " where";
                isFirstCondition = false;
            } else {
                jpql += " and";
            }
            jpql += " o.status = :status";
        }

        //회원 이름 검색
        if(StringUtils.hasText(orderSearchDto.getMemberName())){
            if(isFirstCondition) {
                jpql += " where";
                isFirstCondition = false;
            } else {
                jpql += " and";
            }
            jpql += " m.username like :username";
        }

        TypedQuery<Order> query = em.createQuery(jpql, Order.class)
                .setMaxResults(1000);//최대 1000개까지 조회

        if(orderSearchDto.getOrderStatus() != null){
            query = query.setParameter("status", orderSearchDto.getOrderStatus());
        }
        if(StringUtils.hasText(orderSearchDto.getMemberName())){
            query = query.setParameter("username", orderSearchDto.getMemberName());
        }

        return query.getResultList();
    }
}
