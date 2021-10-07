package com.paralyze.paralyze.Controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.paralyze.paralyze.Exception.ApiError;
import com.paralyze.paralyze.Model.User;
import com.paralyze.paralyze.Repository.UserRepository;
import com.paralyze.paralyze.Service.UserService;
import com.paralyze.paralyze.Shared.GenericResponse;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }

    //User Creator
    @PostMapping("/signup")
    public GenericResponse saveUser(@Valid @RequestBody User user){
        this.userService.createUser(user);
        return new GenericResponse("Kullanıcı oluşturuldu.");
    }

    //List All users
    @GetMapping("/allusers")
    public GenericResponse findAllUsers(){
        this.userService.findAllUsers();
        return new GenericResponse("Kullanıcılar Listelendi");
    }

    //Exception
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleValidationException(HttpMessageNotReadableException exception){
        Map<String, String> validationErrors = new HashMap<>();
        validationErrors.put(exception.getMessage(), exception.getLocalizedMessage());
        return new ApiError(HttpStatus.BAD_REQUEST,"Doğrulama Hatası","/api/v1/users",validationErrors);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleValidationException(MethodArgumentNotValidException exception){
        Map<String, String> validationErrors = new HashMap<>();
        for (FieldError error:exception.getBindingResult().getFieldErrors()) {
            validationErrors.put(error.getField(),error.getDefaultMessage());
        }
        return new ApiError(HttpStatus.BAD_REQUEST,"Doğrulama Hatası","/api/v1/users",validationErrors);
    }

}
