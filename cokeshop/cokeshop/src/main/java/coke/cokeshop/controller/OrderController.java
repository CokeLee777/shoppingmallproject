package coke.cokeshop.controller;

import coke.cokeshop.domain.Item;
import coke.cokeshop.domain.Member;
import coke.cokeshop.service.ItemService;
import coke.cokeshop.service.MemberService;
import coke.cokeshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final MemberService memberService;
    private final ItemService itemService;

    @GetMapping("/order/new")
    public String createForm(Model model){

        List<Member> members = memberService.findMembers();
        List<Item> items = itemService.findItems();

        model.addAttribute("members", members);
        model.addAttribute("items", items);

        return "order/createOrderForm";
    }

    @PostMapping("/order/new")
    public String create(
            @RequestParam("memberId") Long memberId,
            @RequestParam("itemId") Long itemId,
            @RequestParam("count") int count){

        orderService.order(memberId, itemId, count);

        return "redirect:/";
    }


}
