package coke.cokeshop.controller;

import coke.cokeshop.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

//    @GetMapping("/item/new")
//    public String create(Model model){
//        model.addAttribute()
//    }
}
