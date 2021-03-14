package coke.cokeshop.controller;

import coke.cokeshop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //회원가입
//    @GetMapping("/members/new")
//    public String createForm(Model model){
//        model.addAttribute("memberForm")
//    }
}
