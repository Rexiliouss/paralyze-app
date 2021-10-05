package com.paralyze.paralyze.Controller;

import com.paralyze.paralyze.Dto.CreateUserRequest;
import com.paralyze.paralyze.Dto.UserDto;
import com.paralyze.paralyze.Exception.ControllerException;
import com.paralyze.paralyze.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
    public ResponseEntity<?> saveUser(@Valid @RequestBody CreateUserRequest createUserRequest){
        try{
            return ResponseEntity.ok(this.userService.createUser(createUserRequest));
        }catch (Error exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ControllerException(400,"Kullanıcı oluşturulamadı.","/api/v1/users/signup"));
        }
    }

    //List All users
    @GetMapping("/allusers")
    public ResponseEntity<List<UserDto>> findAllUsers(){
        return ResponseEntity.ok(this.userService.findAllUsers());
    }

}
