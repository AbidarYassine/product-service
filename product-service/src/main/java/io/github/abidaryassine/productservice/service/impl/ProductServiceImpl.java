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

import java.util.ArrayList;
import java.util.List;

import static io.github.abidaryassine.productservice.mapper.ProductMapper.*;

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
        // TODO validate dto
        log.info("Start validating productDto {}", productDto);
        final var productEntity = toEntity(productDto);
        final var savedProduct = productRepository.save(productEntity);
        log.info("Product saved with id {}", savedProduct.getId());
        return toDto(savedProduct);
    }

    @Override
    public List<ProductDto> search(final ProductSearchDto productSearchDto) {
        Query query = new Query();
        List<Criteria> criteria = new ArrayList<>();

        criteria.add(Criteria.where("price").is(productSearchDto.price()));
        criteria.add(Criteria.where("libelle").is(productSearchDto.libelle()));
        criteria.add(Criteria.where("description").is(productSearchDto.description()));

        query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[0])));
        List<ProductEntity> result = mongoTemplate.find(query, ProductEntity.class);
        return toDtos(result);
    }
}
