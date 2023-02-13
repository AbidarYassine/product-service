package io.github.abidaryassine.productservice.api;

import io.github.abidaryassine.productservice.dto.ProductDto;
import io.github.abidaryassine.productservice.dto.ProductSearchDto;
import io.github.abidaryassine.productservice.service.facade.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

/**
 * @author yassineabidar on 3/2/2023
 */
@RestController
@RequestMapping("api/products")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/")
    @ResponseStatus(value = CREATED)
    public ProductDto save(@RequestBody ProductDto productDto) {
        log.info("Start adding new product {}", productDto);
        return productService.save(productDto);
    }

    @GetMapping("/")
    @ResponseStatus(value = OK)
    public List<ProductDto> all() {
        return productService.all();
    }

    @GetMapping("/search")
    @ResponseStatus(value = OK)
    public List<ProductDto> search(@Param(value = "keyword") String keyword) {
        log.info("Searching products criteria {}", keyword);
        return productService.search(keyword);
    }
}
