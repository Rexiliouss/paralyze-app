package com.paralyze.paralyze.Exception;

import com.paralyze.paralyze.Dto.CreateUserRequest;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Data
public class ControllerExceptionHandler {
    private int status;
    private String message;
    private String path;
    private long timestamp= new Date().getTime();
    Map<String,String> validationErrors;

    public ControllerExceptionHandler(){}
    public  ControllerExceptionHandler(int status, String message,String path,Map<String,String> validationErrors){
        this.status=status;
        this.message=message;
        this.path=path;
        this.validationErrors=validationErrors;
    }
    public  ControllerExceptionHandler(int status, String message,String path){
        this.status=status;
        this.message=message;
        this.path=path;
    }
    public  ControllerExceptionHandler(int status, String message){
        this.status=status;
        this.message=message;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
   public ControllerExceptionHandler handleValidateException(MethodArgumentNotValidException exception){
       ControllerExceptionHandler apiError = new ControllerExceptionHandler(400,"Validation-Error","/api/v1/users/signup");
       Map<String,String> validationErrors = new HashMap<>();
        for (FieldError fieldError:exception.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(),fieldError.getDefaultMessage());
        }
        apiError.setValidationErrors(validationErrors);
       return apiError;
   }
}
