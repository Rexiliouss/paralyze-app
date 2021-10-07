package com.paralyze.paralyze.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class ApiError{
    private HttpStatus httpStatus;
    private String message;
    private String path;
    private long timestamp = new Date().getTime();
    private Map<String, String> validationErrors = new HashMap<>();

    public ApiError(HttpStatus httpStatus, String message, String path){
        this.httpStatus=httpStatus;
        this.message=message;
        this.path=path;
    }
    public ApiError(HttpStatus httpStatus, String message, String path, Map<String,String>validationErrors){
        this.httpStatus=httpStatus;
        this.message=message;
        this.path=path;
        this.validationErrors=validationErrors;
    }
}
