package io.github.abidaryassine.productservice.service.facade;

import io.github.abidaryassine.productservice.dto.ProductDto;
import io.github.abidaryassine.productservice.dto.ProductSearchDto;

import java.util.List;

/**
 * @author yassineabidar on 31/1/2023
 */
public interface ProductService {


    ProductDto save(ProductDto productDto);

    List<ProductDto> search(ProductSearchDto productSearchDto);

}
