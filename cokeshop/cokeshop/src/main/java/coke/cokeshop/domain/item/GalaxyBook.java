package coke.cokeshop.domain.item;

import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@DiscriminatorValue(value = "G")
public class GalaxyBook extends Item{

}
