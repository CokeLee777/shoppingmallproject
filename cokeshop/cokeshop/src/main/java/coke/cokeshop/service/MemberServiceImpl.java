package coke.cokeshop.service;

import coke.cokeshop.domain.Address;
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
        Member findMember = memberRepository.findByName(member.getUsername());
        if(findMember != null){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    @Override
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member findOne(Long id) {
        Member findMember = memberRepository.findById(id);
        //찾는 아이디가 없다면
        if(findMember == null){
            throw new IllegalStateException("아이디가 존재하지 않습니다.");
        }
        return memberRepository.findById(id);
    }

    @Override
    public Member findOne(String name) {
        Member findMember = memberRepository.findByName(name);
        //찾는 아이디가 없다면
        if(findMember == null){
            throw new IllegalStateException("아이디가 존재하지 않습니다.");
        }
        return memberRepository.findByName(name);
    }

    @Override
    public String findPassword(String name, String email) {
        Member findMember1 = memberRepository.findByName(name);
        Member findMember2 = memberRepository.findByEmail(email);
        if(!findMember1.equals(findMember2)){
            throw new IllegalStateException("이름과 이메일에 따른 아이디가 존재하지 않습니다.");
        }

        if(findMember1 != null){
            return findMember1.getPassword();
        } else {
            return null;
        }
    }

    @Override
    @Transactional
    public void update(Long id, String name, String email, String password, Address address) {
        Member findMember = memberRepository.findById(id);
        Member.updateMember(findMember, name, password, email, address);
    }

    @Override
    public void secessionMember(Long id) {
        Member member = memberRepository.findById(id);
        memberRepository.delete(member);
    }

}
