package coke.cokeshop.domain.item;

import coke.cokeshop.domain.Category;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("N")
@Getter @Setter(value = AccessLevel.PROTECTED)
public class NoteBook extends Item{
    @Override
    public Item createItem(String name, int price, int stockQuantity, String madeCompany, String releaseDate, Category category) {
        NoteBook noteBook = new NoteBook();
        noteBook.setName(name);
        noteBook.setPrice(price);
        noteBook.setStockQuantity(stockQuantity);
        noteBook.setMadeCompany(madeCompany);
        noteBook.setReleaseDate(releaseDate);
        noteBook.setCategory(category);
        return noteBook;
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
