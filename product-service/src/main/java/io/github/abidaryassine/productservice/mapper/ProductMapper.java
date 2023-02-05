package io.github.abidaryassine.productservice.mapper;

import io.github.abidaryassine.productservice.dto.ProductDto;
import io.github.abidaryassine.productservice.entity.ProductEntity;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author yassineabidar on 3/2/2023
 */
public final class ProductMapper {

    private ProductMapper() {
        throw new IllegalArgumentException("Private Constructor ProductMapper");
    }


    public static ProductDto toDto(final ProductEntity productEntity) {
        return new ProductDto(productEntity.getId(), productEntity.getLibelle(),
                productEntity.getDescription(), productEntity.getQuantite(), productEntity.getPrice());
    }

    public static ProductEntity toEntity(final ProductDto productDto) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setLibelle(productDto.libelle());
        productEntity.setDescription(productDto.description());
        productEntity.setQuantite(productDto.quantite());
        productEntity.setPrice(productDto.price());
        return productEntity;
    }

    public static List<ProductDto> toDtos(final List<ProductEntity> productsEntities) {
        if (CollectionUtils.isEmpty(productsEntities)) return Collections.emptyList();
        return productsEntities.stream().map(ProductMapper::toDto).toList();
    }
}
