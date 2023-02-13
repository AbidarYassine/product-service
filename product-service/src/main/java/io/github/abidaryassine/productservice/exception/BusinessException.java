package io.github.abidaryassine.productservice.exception;

/**
 * @author yassineabidar on 5/2/2023
 */
public class BusinessException extends RuntimeException {

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }
}
