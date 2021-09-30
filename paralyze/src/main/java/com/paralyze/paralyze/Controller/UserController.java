package com.paralyze.paralyze.Controller;

import com.paralyze.paralyze.Dto.CreateUserRequest;
import com.paralyze.paralyze.Dto.UserDto;
import com.paralyze.paralyze.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }

    //Kullanıcı kaydetme işlemi
    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserDto> saveUser(@RequestBody CreateUserRequest createUserRequest){
        Logger.getLogger(createUserRequest.toString());
        return ResponseEntity.
                ok(this.userService.createUser(createUserRequest));
    }
    //Tüm kullanıcıları listele
    @GetMapping("/allusers")
    public ResponseEntity<List<UserDto>> findAllUsers(){
        Logger.getLogger("Tüm kullanıcılar Listeleniyor.");
        return ResponseEntity
                .ok(this.userService.findAllUsers());
    }
}
