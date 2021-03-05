package coke.cokeshop.repository;

import coke.cokeshop.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryImplTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void findPassword() throws Exception {
        //given
        Member member = new Member();
        member.setEmail("123@123");
        member.setUsername("kim");
        member.setPassword("123456");
        //when
        memberRepository.save(member);
        String findPassword = memberRepository.findPassword("123@123", "kim");
        //then

        Assertions.assertThat(findPassword).isEqualTo("123456");

    }

}