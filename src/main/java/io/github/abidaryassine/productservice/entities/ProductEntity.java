package io.github.abidaryassine.productservice.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author yassineabidar on 31/1/2023
 */

@Document(collection = "products")
@Getter
@Setter
public class ProductEntity extends AbstractEntity {
    protected String libelle;
    protected String description;
    protected Integer quantite;
}
