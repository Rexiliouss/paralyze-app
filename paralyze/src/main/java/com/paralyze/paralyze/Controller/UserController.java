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
    //private static final Logger log = (Logger) LoggerFactory.getLogger(UserController.class);

    UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.OK)
    //Kullanıcı kaydetme işlemi
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
