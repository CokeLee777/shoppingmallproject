package coke.cokeshop.service;

import coke.cokeshop.domain.Member;
import coke.cokeshop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public Long join(Member member) {
        //중복회원 검증
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }
    //중복회원 검증 로직
    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getUsername());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    @Override
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member findOneById(Long id) {
        Member findMember = memberRepository.findOneById(id);
        //찾는 아이디가 없다면
        if(findMember == null){
            throw new IllegalStateException("아이디가 존재하지 않습니다.");
        }
        return memberRepository.findOneById(id);
    }

    @Override
    public String findPassword(String name) {
        Member findMember = memberRepository.findOneByName(name);
        if(findMember != null){
            return findMember.getPassword();
        } else {
            return null;
        }
    }

    @Override
    public void secessionMember(Long id) {
        Member member = memberRepository.findOneById(id);
        memberRepository.delete(member);
    }

}
