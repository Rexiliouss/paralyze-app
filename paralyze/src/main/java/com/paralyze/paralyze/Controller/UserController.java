package com.paralyze.paralyze.Controller;

import com.paralyze.paralyze.Dto.CreateUserRequest;
import com.paralyze.paralyze.Service.UserService;
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
    public ResponseEntity<Object> saveUser(@RequestBody CreateUserRequest createUserRequest){
        Logger.getLogger(createUserRequest.toString());
            return (ResponseEntity<Object>) this.userService.createUser(createUserRequest);
    }
    //List All users
    @GetMapping("/allusers")
    public ResponseEntity<List<Object>> findAllUsers(){
        Logger.getLogger("Tüm kullanıcılar Listeleniyor.");
        return ResponseEntity
                .ok(this.userService.findAllUsers());
    }
}
