package io.github.abidaryassine.productservice.dto;

import java.math.BigDecimal;

/**
 * @author yassineabidar on 3/2/2023
 */
public record ProductSearchDto(String libelle, String description, BigDecimal price) {
}

