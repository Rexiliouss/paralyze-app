package com.paralyze.paralyze.Exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.ZonedDateTime;

@Data
@ControllerAdvice
public class ControllerException extends RuntimeException{
    private String message;
    private Throwable throwable;
    private HttpStatus httpStatus;
    private ZonedDateTime timestamp;

    public ControllerException(String message) {
        super(message);
    }

    public ControllerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResponseEntity<Object> handleControllerRequestException(String message, Throwable throwable, HttpStatus httpStatus){
        this.message=message;
        this.throwable=throwable;
        this.httpStatus=httpStatus;
        this.timestamp=ZonedDateTime.now();
    }
}
