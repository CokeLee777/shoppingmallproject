package coke.cokeshop.controller;

import coke.cokeshop.domain.Address;
import coke.cokeshop.domain.Member;
import coke.cokeshop.dto.MemberForm;
import coke.cokeshop.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //회원가입 form
    @GetMapping("/members/new")
    public String createForm(Model model){
        model.addAttribute("memberForm", new MemberForm());

        log.info("회원가입 form access");

        return "members/createMemberForm";
    }

    //회원가입
    @PostMapping("/members/new")
    public String create(@Valid MemberForm form, BindingResult result){
        //오류가 나면 오류메시지 출력
        if(result.hasErrors()){
            return "members/createMemberForm";
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


}
