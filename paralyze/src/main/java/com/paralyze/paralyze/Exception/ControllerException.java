package com.paralyze.paralyze.Exception;

import lombok.Data;

import java.util.Date;

@Data
public class ControllerException extends RuntimeException{
    private int status;
    private String message;
    private long timestamp = new Date().getTime();
    private String path;

    public ControllerException(int status, String message, String path){
        this.status=status;
        this.message=message;
        this.path=path;
    }
}
