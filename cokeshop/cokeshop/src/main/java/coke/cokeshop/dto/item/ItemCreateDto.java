package coke.cokeshop.dto.item;

import coke.cokeshop.domain.Category;

public class ItemCreateDto {
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;
    private String madeCompany;
    private String releaseDate;
    private Category category;
}
