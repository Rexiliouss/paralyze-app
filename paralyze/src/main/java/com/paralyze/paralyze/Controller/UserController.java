package com.paralyze.paralyze.Controller;

import com.paralyze.paralyze.Dto.CreateUserRequest;
import com.paralyze.paralyze.Dto.UserDto;
import com.paralyze.paralyze.Service.UserService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<UserDto> saveUser(@RequestBody CreateUserRequest createUserRequest){
            return this.userService.createUser(createUserRequest);
    }
    //List All users
    @GetMapping("/allusers")
    public ResponseEntity<List<UserDto>> findAllUsers(){
        return this.userService.findAllUsers();
    }
}
