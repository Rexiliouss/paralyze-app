package com.paralyze.paralyze.Shared;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;



public class ApiStatusBuilder<T>{
    private HttpStatus status;
    private String message;
    private long timestamp = new Date().getTime();
    private String path;
    private Map<String,String> traceList;
    T data;


    public ApiStatusBuilder(HttpStatus status, String message, String path, T data){
        this.status=status;
        this.message=message;
        this.path=path;
        this.data = data;
    }
    public ApiStatusBuilder(HttpStatus status, String message, String path,Map<String,String> traceList){
        this.status=status;
        this.message=message;
        this.path=path;
        this.traceList=traceList;
    }
    public ApiStatusBuilder(HttpStatus status, String message, String path){
        this.status=status;
        this.message=message;
        this.path=path;
    }
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiStatusBuilder nullExceptionHandler(MethodArgumentNotValidException methodArgumentNotValidException){
        Map<String,String> traceList = new HashMap<>();
        for (FieldError err:methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
            traceList.put(err.getField(),err.getDefaultMessage());
        }
        return new ApiStatusBuilder(HttpStatus.BAD_REQUEST,"Kullanıcı Oluşturulamadı","/api/v1/users/signup",traceList);
    }
}
