package com.paralyze.paralyze.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.Map;

@Data
@AllArgsConstructor
public class ApiError {
    private HttpStatus httpStatus;
    private String message;
    private String path;
    private long timestamp = new Date().getTime();
    private Map<String, String> validationErrors;

    public ApiError(HttpStatus httpStatus, String message, String path){
        this.httpStatus=httpStatus;
        this.message=message;
        this.path=path;
    }
}
