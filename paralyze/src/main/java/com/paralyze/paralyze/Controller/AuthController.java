package com.paralyze.paralyze.Controller;

import com.paralyze.paralyze.Service.UserService;
import com.paralyze.paralyze.Shared.GenericResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class AuthController {
    private UserService userService;
    @PostMapping("/auth")
    public ResponseEntity<?> loginUser(@RequestHeader(name="Authorization", required = false) String auth){
        if(auth==null || auth.isBlank() || auth.isBlank()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }else{
            return ResponseEntity.status(HttpStatus.OK).build();
        }

    }
}
