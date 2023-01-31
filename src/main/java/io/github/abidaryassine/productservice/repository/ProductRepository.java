package io.github.abidaryassine.productservice.repository;

import io.github.abidaryassine.productservice.entities.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author yassineabidar on 31/1/2023
 */
@Repository
public interface ProductRepository extends MongoRepository<ProductEntity, String> {

}
