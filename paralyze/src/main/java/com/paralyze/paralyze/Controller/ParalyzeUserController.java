package com.paralyze.paralyze.Controller;

import com.paralyze.paralyze.Model.ParalyzeUser;
import com.paralyze.paralyze.Service.ParalyzeUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class ParalyzeUserController {
    private ParalyzeUserService userService;

    public ParalyzeUserController(ParalyzeUserService userService){
        this.userService=userService;
    }
    @PostMapping("/signup")
    public ResponseEntity<?> createUser(ParalyzeUser user){
        return ResponseEntity.ok(userService.createUser(user));
    }
}
