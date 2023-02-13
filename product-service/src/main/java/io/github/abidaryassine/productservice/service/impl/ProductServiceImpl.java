package io.github.abidaryassine.productservice.service.impl;

import io.github.abidaryassine.productservice.dto.ProductDto;
import io.github.abidaryassine.productservice.dto.ProductSearchDto;
import io.github.abidaryassine.productservice.entity.ProductEntity;
import io.github.abidaryassine.productservice.repository.ProductRepository;
import io.github.abidaryassine.productservice.service.facade.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static io.github.abidaryassine.productservice.mapper.ProductMapper.*;
import static io.github.abidaryassine.productservice.validator.ProductValidator.validateProduct;

/**
 * @author yassineabidar on 31/1/2023
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final MongoTemplate mongoTemplate;


    @Override
    public ProductDto save(final ProductDto productDto) {
        log.info("Start validating productDto {}", productDto);
        validateProduct(productDto);
        final var productEntity = toEntity(productDto);
        final var savedProduct = productRepository.save(productEntity);
        log.info("Product saved with id {}", savedProduct.getId());
        return toDto(savedProduct);
    }

    @Override
    public List<ProductDto> search(final String keyword) {
        Query query = new Query();
        List<Criteria> criteria = new ArrayList<>();
        criteria.add(Criteria.where("libelle").is(keyword));
        criteria.add(Criteria.where("description").is(keyword));

        query.addCriteria(new Criteria().orOperator(criteria.toArray(new Criteria[0])));
        List<ProductEntity> result = mongoTemplate.find(query, ProductEntity.class);
        return toDtos(result);
    }

    @Override
    public List<ProductDto> all() {
        final var all = productRepository.findAll();
        return toDtos(all);
    }
}
