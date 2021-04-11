package coke.cokeshop.service;

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

    @Test
    public void joinMember() throws Exception {
        //given
        Member member = Member.createMember("kim", "123", "kim@naver.com");

        //when
        Long id = memberService.join(member);
        Member findMember = memberRepository.findOneById(id);

        //then
        assertThat(member).isEqualTo(findMember);
    }

    @Test
    public void duplicateMemberException() throws Exception {
        //given
        Member member1 = Member.createMember("kim", "123", "kim@naver.com");

        Member member2 = Member.createMember("kim", "123", "kim@naver.com");

        //when
        memberService.join(member1);

        //then
        Assertions.assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));
    }

    @Test
    public void findPassword() throws Exception {
        //given
        Member member = Member.createMember("kim", "123", "kim@naver.com");

        //when
        memberService.join(member);
        String findPassword = memberService.findPassword(member.getUsername());
        //then
        assertThat(findPassword).isEqualTo("123");
    }
}