package coke.cokeshop.repository;

import coke.cokeshop.domain.Member;

public interface MemberRepository {

    void save(Member member);
    String findPassword(String email, String name);
    String findName(String email);
}
