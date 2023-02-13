package io.github.abidaryassine.productservice.dto;

import java.math.BigDecimal;

/**
 * @author yassineabidar on 3/2/2023
 */
public record ProductDto(String id,
        String libelle, String description, Integer quantite, BigDecimal price) {
}
