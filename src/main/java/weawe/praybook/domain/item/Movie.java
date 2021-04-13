package weawe.praybook.domain.item;

import lombok.Getter;
import lombok.Setter;
import weawe.praybook.domain.item.Item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M")
@Getter @Setter
public class Movie extends Item {
    private String director;
    private String actor;
}