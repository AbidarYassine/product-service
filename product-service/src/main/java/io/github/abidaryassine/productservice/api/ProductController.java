package io.github.abidaryassine.productservice.api;

import io.github.abidaryassine.productservice.dto.ProductDto;
import io.github.abidaryassine.productservice.dto.ProductSearchDto;
import io.github.abidaryassine.productservice.service.facade.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

/**
 * @author yassineabidar on 3/2/2023
 */
@RestController
@RequestMapping("products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(value = CREATED)
    public ProductDto save(@RequestBody ProductDto productDto) {
        log.info("Start adding new product {}", productDto);
        return productService.save(productDto);
    }

    @PostMapping("search")
    @ResponseStatus(value = OK)
    public List<ProductDto> search(@RequestBody ProductSearchDto productSearchDto) {
        log.info("Searching products criteria {}", productSearchDto);
        return productService.search(productSearchDto);
    }
}
