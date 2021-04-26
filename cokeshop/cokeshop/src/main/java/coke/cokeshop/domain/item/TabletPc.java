package coke.cokeshop.domain.item;

import coke.cokeshop.domain.Category;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("T")
@Getter @Setter(value = AccessLevel.PROTECTED)
public class TabletPc extends Item{
    @Override
    public Item createItem(String name, int price, int stockQuantity, String madeCompany, String releaseDate, Category category) {
        TabletPc tabletPc = new TabletPc();
        tabletPc.setName(name);
        tabletPc.setPrice(price);
        tabletPc.setStockQuantity(stockQuantity);
        tabletPc.setMadeCompany(madeCompany);
        tabletPc.setReleaseDate(releaseDate);
        tabletPc.setCategory(category);
        return tabletPc;
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
