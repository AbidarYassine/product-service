package io.github.abidaryassine.productservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

/**
 * @author yassineabidar on 31/1/2023
 */

@Document(collection = "products")
@Getter
@Setter
public class ProductEntity extends AbstractEntity {
    private String libelle;
    private String description;
    private Integer quantite;
    private BigDecimal price;
}
