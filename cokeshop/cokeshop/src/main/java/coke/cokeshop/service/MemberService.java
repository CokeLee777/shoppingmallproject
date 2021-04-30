package coke.cokeshop.service;

import coke.cokeshop.domain.Address;
import coke.cokeshop.domain.Member;

import java.util.List;

public interface MemberService {
    Long join(Member member);           //회원 전체 조회
    List<Member> findMembers();         //회원 전체 조회
    Member findOne(Long id);        //회원 한명 조회(id로 조회)
    Member findOne(String name);        //회원 한명 조회(id로 조회)
    String findPassword(String name, String email);   //회원 비밀번호 찾기
    void update(Long id, String name, String email, Address address);   //회원 정보 수정
    void secessionMember(Member member);      //회원 탈퇴
}