package com.paralyze.paralyze.Controller;

import com.paralyze.paralyze.Model.User;
import com.paralyze.paralyze.Repository.UserRepository;
import com.paralyze.paralyze.Service.UserService;
import com.paralyze.paralyze.Shared.GenericResponse;
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
    public GenericResponse saveUser(@RequestBody User user){
        this.userService.createUser(user);
        return new GenericResponse("Kullanıcı oluşturuldu.");
    }

    //List All users
    @GetMapping("/allusers")
    public GenericResponse findAllUsers(){
        this.userService.findAllUsers();
        return new GenericResponse("Kullanıcılar Listelendi");
    }

}
