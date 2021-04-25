package coke.cokeshop.service;

import coke.cokeshop.domain.Address;
import coke.cokeshop.domain.Member;
import coke.cokeshop.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@Transactional
class MemberServiceImplTest {

    @Autowired MemberRepository memberRepository;
    @Autowired MemberService memberService;

    //회원 가입
    @Test
    public void joinMember() throws Exception {
        //given
        Address address = Address.createAddress("안양시", "관악대로", "135");
        Member member = Member.createMember("kim", "123", "kim@naver.com", address);

        //when
        Long id = memberService.join(member);
        Member findMember = memberRepository.findById(id);

        //then
        assertThat(member).isEqualTo(findMember);
    }

    //중복회원 예외처리
    @Test
    public void duplicateMemberException() throws Exception {
        //given
        Address address = Address.createAddress("안양시", "관악대로", "135");
        Member member1 = Member.createMember("kim", "123", "kim@naver.com", address);

        Member member2 = Member.createMember("kim", "123", "kim@naver.com", address);

        //when
        memberService.join(member1);

        //then
        Assertions.assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));
    }

    //비밀번호 찾기
    @Test
    public void findPassword() throws Exception {
        //given
        Address address = Address.createAddress("안양시", "관악대로", "135");
        Member member = Member.createMember("kim", "123", "kim@naver.com", address);

        //when
        memberService.join(member);
        String findPassword = memberService.findPassword(member.getUsername(), member.getEmail());
        //then
        assertThat(findPassword).isEqualTo("123");
    }

    //회원 탈퇴
    @Test
    public void deleteMember() throws Exception {
        //given
        Address address = Address.createAddress("안양시", "관악대로", "135");
        Member member = Member.createMember("kim", "123", "kim@naver.com", address);
        Long joinId = memberService.join(member);
        //when
        memberService.secessionMember(joinId);
        //then
        Assertions.assertThrows(IllegalStateException.class,
                () -> memberService.findOne(joinId));
    }
}