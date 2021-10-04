package com.paralyze.paralyze.Exception;

import lombok.Data;

import javax.management.RuntimeErrorException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Data
public class ControllerExceptionHandler {
    private int status;
    private String message;
    private String path;
    private long timestamp= new Date().getTime();
    Map<String,String> validationErrors = new HashMap<>();
    public ControllerExceptionHandler(int status, String message,String path,Map<String,String> validationErrors){
        this.status=status;
        this.message=message;
        this.path=path;
        this.validationErrors=validationErrors;
    }
}
