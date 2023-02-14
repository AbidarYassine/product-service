package io.github.abidaryassine.productservice.validator;

import io.github.abidaryassine.productservice.dto.ProductDto;
import io.github.abidaryassine.productservice.dto.Result;
import io.github.abidaryassine.productservice.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;


/**
 * @author yassineabidar on 5/2/2023
 */
@Slf4j
public final class ProductValidator {


    private ProductValidator() {
        throw new IllegalArgumentException("Private constructor ProductValidator");
    }

    public static void validateProduct(ProductDto productDto) {
        Result<?> errors = new Result<>();
        validateLibelle(productDto.libelle(), errors);
        validateDescription(productDto.description(), errors);
        validatePrice(productDto.price(), errors);
        log.info("ERROR length {}", errors.getErrors().size());
        if (!errors.hasError()) throw new BusinessException(errors.getErrors().toString());
    }


    private static void validatePrice(BigDecimal price, Result<?> errors) {
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) errors.addErrorMessage("Invalid Price");
    }

    private static void validateDescription(String description, Result<?> errors) {
        if (!StringUtils.hasLength(description)) errors.addErrorMessage("Description required");
    }

    private static void validateLibelle(String libelle, Result<?> errors) {
        if (!StringUtils.hasLength(libelle)) errors.addErrorMessage("Libelle required !!");
    }
}
