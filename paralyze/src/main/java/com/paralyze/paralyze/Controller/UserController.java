package com.paralyze.paralyze.Controller;

import com.paralyze.paralyze.Dto.CreateUserRequest;
import com.paralyze.paralyze.Dto.UserDto;
import com.paralyze.paralyze.Exception.ControllerExceptionHandler;
import com.paralyze.paralyze.Service.UserService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public ControllerExceptionHandler saveUser(@Validated @RequestBody CreateUserRequest createUserRequest){
        ControllerExceptionHandler controllerExceptionHandler = new ControllerExceptionHandler(400,"Validation Error","/api/v1/users/signup");
        Map<String,String> validationErrors = new HashMap<>();

        this.userService.createUser(createUserRequest);
        return new ControllerExceptionHandler(200,"Kullanıcı Oluşturuldu");
    }
    //List All users
    @GetMapping("/allusers")
    public ResponseEntity<List<UserDto>> findAllUsers(){
        return ResponseEntity.ok(this.userService.findAllUsers());
    }


}
