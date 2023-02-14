package io.github.abidaryassine.productservice.util;

import io.github.abidaryassine.productservice.dto.ProductDto;
import io.github.abidaryassine.productservice.entity.ProductEntity;

import java.math.BigDecimal;

/**
 * @author yassineabidar on 14/2/2023
 */
public final class TestUtils {

    public static final String DESCRIPTION = "Description";

    public static final String LIBELLE = "Libelle";

    private TestUtils() {
        throw new IllegalArgumentException("TestUtils private constructor");
    }

    public static ProductEntity getEntity() {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setDescription(DESCRIPTION);
        productEntity.setPrice(BigDecimal.ONE);
        productEntity.setLibelle(LIBELLE);
        productEntity.setQuantite(1);
        return productEntity;
    }

    public static ProductDto getDto() {
        return new ProductDto("id", LIBELLE, DESCRIPTION, 1, BigDecimal.ONE);
    }
}
