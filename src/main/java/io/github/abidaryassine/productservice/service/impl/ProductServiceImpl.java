package io.github.abidaryassine.productservice.service.impl;

import io.github.abidaryassine.productservice.entities.ProductEntity;
import io.github.abidaryassine.productservice.repository.ProductRepository;
import io.github.abidaryassine.productservice.service.facade.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author yassineabidar on 31/1/2023
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public ProductEntity save(ProductEntity product) {
        return null;
    }
}
