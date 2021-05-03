package coke.cokeshop.controller;

import coke.cokeshop.domain.Address;
import coke.cokeshop.domain.Member;
import coke.cokeshop.dto.member.MemberCreateDto;
import coke.cokeshop.dto.member.MemberListDto;
import coke.cokeshop.dto.member.MemberUpdateDto;
import coke.cokeshop.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * 회원가입 Form
     */
    @GetMapping("/member/new")
    public String createForm(Model model){
        model.addAttribute("memberCreateDto", new MemberCreateDto());

        log.info("회원가입 form access");

        return "member/createMemberForm";
    }

    /**
     * 회원가입
     */
    @PostMapping("/member/new")
    public String create(@Valid MemberCreateDto memberCreateDto, BindingResult result){
        //오류가 나면 오류메시지 출력
        if(result.hasErrors()){
            return "member/createMemberForm";
        }

        Address address = Address.createAddress(memberCreateDto.getCity(), memberCreateDto.getStreet(), memberCreateDto.getZipcode());
        Member member = Member.createMember(
                memberCreateDto.getUsername(),
                memberCreateDto.getPassword(),
                memberCreateDto.getEmail(),
                address);

        memberService.join(member);

        log.info("회원가입: username={}", member.getUsername());

        //로직 종료 후 홈으로 리다이렉션
        return "redirect:/";
    }

    /**
     * 회원 조회
     */
    @GetMapping("/members")
    public String memberInfo(Model model){
        List<Member> members = memberService.findMembers();
        List<MemberListDto> memberListDtos = members.stream()
                .map(m -> new MemberListDto(m.getId(),m.getUsername(),m.getEmail(),m.getAddress()))
                .collect(Collectors.toList());

        model.addAttribute("members", memberListDtos);

        log.info("회원조회 form access");
        return "member/memberList";
    }

    /**
     * 회원 수정 Form
     */
    @GetMapping("/members/{id}/edit")
    public String updateForm(@PathVariable("id") Long id, Model model){
        Member member = memberService.findOne(id);
        MemberUpdateDto memberUpdateDto = new MemberUpdateDto(
                member.getId(),
                member.getUsername(),
                member.getEmail(),
                member.getAddress().getCity(),
                member.getAddress().getStreet(),
                member.getAddress().getZipcode());

        model.addAttribute("memberUpdateDto", memberUpdateDto);

        log.info("회원수정 form access");

        return "member/updateMemberForm";
    }

    /**
     * 회원 수정
     */
    @PostMapping("/members/{id}/edit")
    public String update(
            @PathVariable("id") Long id,
            @Valid @ModelAttribute("memberUpdateDto") MemberUpdateDto memberUpdateDto,
            BindingResult result){

        //오류가 나면 오류메시지 출력
        if(result.hasErrors()){
            return "member/updateMemberForm";
        }

        Address address = Address.createAddress(memberUpdateDto.getCity(), memberUpdateDto.getStreet(), memberUpdateDto.getZipcode());
        memberService.update(
                id,
                memberUpdateDto.getUsername(),
                memberUpdateDto.getEmail(),
                address);

        log.info("회원수정: id={}", memberUpdateDto.getId());

        return "redirect:/members";
    }

    /**
     * 회원 삭제
     */
    @GetMapping("/members/{id}/delete")
    public String delete(@PathVariable("id") Long id){
        Member member = memberService.findOne(id);
        memberService.secessionMember(member);

        log.info("회원삭제: id={}", id);

        return "redirect:/members";
    }

}
