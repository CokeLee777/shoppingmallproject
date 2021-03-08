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
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setUsername("kim");
        member.setPassword("123456");
        member.setEmail("kim@naver.com");

        //when
        Long id = memberService.join(member);
        Member findMember = memberRepository.findOneById(id);

        //then
        assertThat(member).isEqualTo(findMember);
    }

    @Test
    public void 중복회원예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setUsername("kim");

        Member member2 = new Member();
        member2.setUsername("kim");

        //when
        memberService.join(member1);

        //then
        Assertions.assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));
    }

    @Test
    public void 비밀번호찾기() throws Exception {
        //given
        Member member = new Member();
        member.setUsername("kim");
        member.setPassword("123456");

        //when
        memberService.join(member);
        String findPassword = memberService.findPassword(member.getUsername());
        //then
        assertThat(findPassword).isEqualTo("123456");
    }
}