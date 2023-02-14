package io.github.abidaryassine.productservice.mapper;

import org.junit.jupiter.api.Test;

import static io.github.abidaryassine.productservice.util.TestUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author yassineabidar on 14/2/2023
 */
class ProductMapperTest {


    @Test
    void testToDto() {
        final var productDto = ProductMapper.toDto(getEntity());
        assertEquals(DESCRIPTION, productDto.description());
        assertEquals(LIBELLE, productDto.libelle());
    }

    @Test
    void testToEntity() {
        final var productEntity = ProductMapper.toEntity(getDto());
        assertEquals(DESCRIPTION, productEntity.getDescription());
        assertEquals(LIBELLE, productEntity.getLibelle());
    }


}