package com.paralyze.paralyze.User.Controller;

import com.paralyze.paralyze.User.Model.ParalyzeUser;
import com.paralyze.paralyze.User.Service.ParalyzeUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ParalyzeUserController {
    private ParalyzeUserService userService;

    public ParalyzeUserController(ParalyzeUserService userService){
        this.userService=userService;
    }
    @GetMapping("allusers")
    public List<ParalyzeUser> findAllUsers(){
        return this.userService.listAllUsers();
    }
}
