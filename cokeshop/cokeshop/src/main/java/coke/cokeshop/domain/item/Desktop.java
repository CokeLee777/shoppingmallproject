package coke.cokeshop.domain.item;

import coke.cokeshop.domain.Category;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("D")
@Getter @Setter(value = AccessLevel.PROTECTED)
public class Desktop extends Item{

    @Override
    public Item createItem(String name, int price, int stockQuantity, String madeCompany, String releaseDate, Category category) {
        Desktop desktop = new Desktop();
        desktop.setName(name);
        desktop.setPrice(price);
        desktop.setStockQuantity(stockQuantity);
        desktop.setMadeCompany(madeCompany);
        desktop.setReleaseDate(releaseDate);
        desktop.setCategory(category);
        return desktop;
    }

    @Override
    public void updateItem(Item item, String name, int price, int stockQuantity, String madeCompany, String releaseDate, Category category) {
        item.setName(name);
        item.setPrice(price);
        item.setStockQuantity(stockQuantity);
        item.setMadeCompany(madeCompany);
        item.setReleaseDate(releaseDate);
        item.setCategory(category);
    }

}
