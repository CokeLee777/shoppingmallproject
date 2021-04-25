package coke.cokeshop.repository;

import coke.cokeshop.domain.Member;

import java.util.List;

public interface MemberRepository {

    void save(Member member);               //회원 저장
    Member findById(Long id);            //회원 한명 찾기(id로)
    Member findByName(String name);      //회원 한명 찾기(name로)
    Member findByEmail(String email); //회원 이메일로 찾기
    List<Member> findAll();                 //회원 모두 찾기
    void delete(Member member);                 //회원 삭제
}
