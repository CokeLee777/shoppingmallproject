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

    private EntityManager em;

    @Override
    public void save(Member member) {

    }

    @Override
    public String findPassword(String email, String name) {
        return null;
    }

    @Override
    public String findName(String email) {
        return null;
    }
}
