package com.paralyze.paralyze.Controller;

import com.paralyze.paralyze.Dto.CreateUserRequest;
import com.paralyze.paralyze.Dto.UserDto;
import com.paralyze.paralyze.Exception.ControllerExceptionHandler;
import com.paralyze.paralyze.Service.UserService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }
    //User Creator
    @PostMapping("/signup")
    public ResponseEntity<Object> saveUser(@RequestBody CreateUserRequest createUserRequest){
        if(createUserRequest.getUserName().isEmpty() || createUserRequest.getUserName().trim()==""
        || createUserRequest.getDisplayName().isEmpty() || createUserRequest.getDisplayName().trim()==""
        || createUserRequest.getPassword().isEmpty() || createUserRequest.getPassword().trim()==""){
            Map<String,String> validationErrors = new HashMap<>();
            validationErrors.put("error","Tüm alanları giriniz");
            ControllerExceptionHandler apiError = new ControllerExceptionHandler(400,"Validation-Error","/api/v1/users/signup",validationErrors);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
        }else{
            return ResponseEntity.ok(this.userService.createUser(createUserRequest));
        }
    }
    //List All users
    @GetMapping("/allusers")
    public ResponseEntity<List<UserDto>> findAllUsers(){
        return ResponseEntity.ok(this.userService.findAllUsers());
    }
}
