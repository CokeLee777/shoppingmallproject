package coke.cokeshop.controller;

import coke.cokeshop.domain.Category;
import coke.cokeshop.domain.Item;
import coke.cokeshop.dto.item.ItemCreateDto;
import coke.cokeshop.dto.item.ItemListDto;
import coke.cokeshop.dto.item.ItemUpdateDto;
import coke.cokeshop.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    /**
     * 상품 등록 Form
     */
    @GetMapping("/item/new")
    public String createForm(Model model) {

        List<Category> categories = new ArrayList<>();
        categories.add(Category.createCategory("Desktop"));
        categories.add(Category.createCategory("NoteBook"));
        categories.add(Category.createCategory("TabletPc"));

        model.addAttribute("categories", categories);

        model.addAttribute("itemCreateDto", new ItemCreateDto());

        log.info("상품등록 form access");

        return "item/createItemForm";
    }

    /**
     * 상품 등록
     * 수정중 -> 카테고리가 생성이 안됨
     */
    @PostMapping("/item/new")
    public String create(
            @Valid ItemCreateDto itemCreateDto,
            BindingResult result){

        //오류가 있다면 출력
        if(result.hasErrors()){
            return "item/createItemForm";
        }

        Item item = Item.createItem(
                itemCreateDto.getName(),
                itemCreateDto.getPrice(),
                itemCreateDto.getStockQuantity(),
                itemCreateDto.getMadeCompany(),
                itemCreateDto.getReleaseDate()
        );

        itemService.save(item);

        log.info("상품등록: name={}", itemCreateDto.getName());

        return "redirect:/";
    }

    /**
     * 상품목록 조회
     */
    @GetMapping("/items")
    public String itemInfo(Model model){
        List<Item> items = itemService.findItems();
        List<ItemListDto> itemListDtos = items.stream()
                .map(i -> new ItemListDto(i.getId(), i.getName(), i.getPrice(), i.getStockQuantity(), i.getMadeCompany(), i.getReleaseDate()))
                .collect(Collectors.toList());

        model.addAttribute("items", itemListDtos);

        log.info("상품목록조회 form access");

        return "item/itemList";
    }

    /**
     * 상품 수정 Form
     */
    @GetMapping("/items/{id}/edit")
    public String updateForm(@PathVariable("id") Long id, Model model){
        Item item = itemService.findOne(id);
        ItemUpdateDto itemUpdateDto = new ItemUpdateDto(
                id,
                item.getName(),
                item.getPrice(),
                item.getStockQuantity(),
                item.getMadeCompany(),
                item.getReleaseDate()
        );

        model.addAttribute("itemUpdateDto", itemUpdateDto);

        log.info("상품수정 form access");

        return "item/updateItemForm";
    }

    @PostMapping("/items/{id}/edit")
    public String update(
            @PathVariable("id") Long id,
            @Valid @ModelAttribute("itemUpdateDto") ItemUpdateDto itemUpdateDto,
            BindingResult result
    ){
        //오류발생시 오류문구 출력
        if(result.hasErrors()){
            return "item/updateItemForm";
        }

        itemService.update(
                id,
                itemUpdateDto.getName(),
                itemUpdateDto.getPrice(),
                itemUpdateDto.getStockQuantity(),
                itemUpdateDto.getMadeCompany(),
                itemUpdateDto.getReleaseDate()
        );

        log.info("상품수정: name={}", itemUpdateDto.getName());

        return "redirect:/items";
    }

    /**
     * 회원 삭제
     */
    @GetMapping("/items/{id}/delete")
    public String delete(@PathVariable("id") Long id){
        Item item = itemService.findOne(id);
        itemService.secessionItem(item);

        log.info("상품삭제: id={}", id);

        return "redirect:/items";
    }

}
