package io.github.abidaryassine.productservice.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import io.github.abidaryassine.productservice.dto.Result;

/**
 * @author yassineabidar on 5/2/2023
 */
@RestControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(value = BusinessException.class)
    public ResponseEntity<Result<?>> handleBusinessException(BusinessException ex) {
        Result<?> result = new Result<>();
        result.addErrorMessage(ex.getMessage());
        result.setStatus(400);
        return new ResponseEntity<>(result, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
