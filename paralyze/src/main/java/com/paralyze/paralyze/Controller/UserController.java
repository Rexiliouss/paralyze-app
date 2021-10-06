package com.paralyze.paralyze.Controller;

import com.paralyze.paralyze.Model.User;
import com.paralyze.paralyze.Repository.UserRepository;
import com.paralyze.paralyze.Service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }

    //User Creator
    @PostMapping("/signup")
    public User saveUser(@Valid @RequestBody User user){
        return this.userService.createUser(user);
    }

    //List All users
    @GetMapping("/allusers")
    public List<User> findAllUsers(){
        return this.userService.findAllUsers();
    }

}
