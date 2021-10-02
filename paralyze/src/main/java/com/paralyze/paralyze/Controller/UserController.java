package com.paralyze.paralyze.Controller;

import com.paralyze.paralyze.Dto.CreateUserRequest;
import com.paralyze.paralyze.Dto.UserDto;
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
        //KullanıcıAdı, Parola boş ise BadRequest gönder, kaydı ekleme.
        if
          (createUserRequest.getUserName().isEmpty()
        || createUserRequest.getUserName()==""
        || createUserRequest.getPassword().isEmpty()
        || createUserRequest.getPassword()==""
        || createUserRequest.getDisplayName().isEmpty()
        || createUserRequest.getDisplayName()==""){
            return ResponseEntity.badRequest().body("Tüm Bilgiler Eksiksiz Doldurulmalıdır.");
        }else{
            return ResponseEntity.
                    ok(this.userService.createUser(createUserRequest));
        }
    }
    //List All users
    @GetMapping("/allusers")
    public ResponseEntity<List<UserDto>> findAllUsers(){
        Logger.getLogger("Tüm kullanıcılar Listeleniyor.");
        return ResponseEntity
                .ok(this.userService.findAllUsers());
    }
}
