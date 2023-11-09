package com.burnfield.burnfieldstats.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.http.HttpStatus;
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class BurnfieldException extends RuntimeException {

    private final HttpStatus httpStatus;

    public BurnfieldException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public BurnfieldException(String message) {
        super(message);
        this.httpStatus = HttpStatus.BAD_REQUEST;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
