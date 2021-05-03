package coke.cokeshop.dto.item;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class ItemListDto {

    private Long id;

    private String name;
    private int price;
    private int stockQuantity;
    private String madeCompany;
    private String releaseDate;

}
