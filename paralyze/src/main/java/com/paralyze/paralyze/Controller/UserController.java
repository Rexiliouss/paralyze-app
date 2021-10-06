package com.paralyze.paralyze.Controller;

import com.paralyze.paralyze.Dto.CreateUserRequest;
import com.paralyze.paralyze.Model.User;
import com.paralyze.paralyze.Shared.ApiStatusBuilder;
import com.paralyze.paralyze.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
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
    public ApiStatusBuilder<Object> saveUser(@Valid @RequestBody CreateUserRequest createUserRequest){
        return new ApiStatusBuilder(HttpStatus.OK,"Kayıt oluşturuldu.","/api/v1/users/signup",this.userService.createUser(createUserRequest));
    }

    //List All users
    @GetMapping("/allusers")
    public ApiStatusBuilder<Object> findAllUsers(){
        return new ApiStatusBuilder(HttpStatus.OK,"Kayıtlar Listelendi.","/api/v1/users/allusers",this.userService.findAllUsers());
    }

}
