package coke.cokeshop.controller;

import coke.cokeshop.domain.Category;
import coke.cokeshop.dto.item.ItemCreateDto;
import coke.cokeshop.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/item/new")
    public String createForm(Model model) {
        List<Category> categories = Category.createCategory("Desktop", "NoteBook", "TabletPc");

        model.addAttribute("categories", categories);
        model.addAttribute("itemCreateDto", new ItemCreateDto());

        log.info("상품등록 form access");

        return "item/createItemForm";
    }

//    @PostMapping("/item/new")
//    public String create(@RequestParam("categoryId") Long categoryId){
//
//        return "redirect:/items";
//    }

}
