package coke.cokeshop.service;

import coke.cokeshop.domain.Member;

import java.util.List;

public interface MemberService {
    Long join(Member member);           //회원 전체 조회
    List<Member> findMembers();         //회원 전체 조회
    Member findOneById(Long id);        //회원 한명 조회(id로 조회)
    String findPassword(String name); //회원 비밀번호 찾기
}