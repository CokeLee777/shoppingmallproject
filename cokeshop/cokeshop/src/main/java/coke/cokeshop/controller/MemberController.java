package coke.cokeshop.controller;

import coke.cokeshop.domain.Address;
import coke.cokeshop.domain.Member;
import coke.cokeshop.dto.MemberFormDto;
import coke.cokeshop.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //회원가입 form
    @GetMapping("/member/new")
    public String createForm(Model model){
        model.addAttribute("memberFormDto", new MemberFormDto());

        log.info("회원가입 form access");

        return "member/createMemberForm";
    }

    //회원가입
    @PostMapping("/member/new")
    public String create(@Valid MemberFormDto form, BindingResult result){
        //오류가 나면 오류메시지 출력
        if(result.hasErrors()){
            return "member/createMemberForm";
        }

        Address address = Address.createAddress(form.getCity(), form.getStreet(), form.getZipcode());
        Member member = Member.createMember(
                form.getUsername(),
                form.getPassword(),
                form.getEmail(),
                address);

        memberService.join(member);

        log.info("회원가입: username={}", member.getUsername());

        //로직 종료 후 홈으로 리다이렉션
        return "redirect:/";
    }

    //내 정보 출력
    @GetMapping("/member/info/{id}")
    public String memberInfo(@PathVariable("id") Long id, Model model){
        Member member = memberService.findOne(id);
        model.addAttribute("member", member);
        return "member/info";
    }
}
