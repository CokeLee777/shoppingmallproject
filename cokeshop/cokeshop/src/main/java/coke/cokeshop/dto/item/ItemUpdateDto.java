package coke.cokeshop.dto.item;

import coke.cokeshop.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
@AllArgsConstructor
public class ItemUpdateDto {

    private Long id;

    @NotEmpty(message = "상품 이름은 필수입니다")
    private String name;

    private int price;
    private int stockQuantity;

    private String madeCompany;
    private String releaseDate;
    //private Category category;
}
