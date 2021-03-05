package coke.cokeshop.repository;

import coke.cokeshop.domain.Member;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@Getter
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository{

    private final EntityManager em;

    @Override
    public void save(Member member) {
        em.persist(member);
    }

    @Override
    public String findPassword(String email, String name) {
        return em.createQuery("select m.password from Member m where m.email, m.name = :email, :name", String.class)
                .setParameter("email", email)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public String findName(String email) {
        return em.createQuery("select m.name from Member m where m.email = :email", String.class)
                .setParameter("email", email)
                .getSingleResult();
    }
}
