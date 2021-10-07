package com.paralyze.paralyze.Controller;

import com.paralyze.paralyze.Exception.ApiError;
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
    public ApiError loginUser(@RequestHeader(name="Authorization", required = false) String auth){
        if(auth!=null && (auth.isBlank() || auth.isBlank())){
            return new ApiError(HttpStatus.UNAUTHORIZED,"Yetkilendirme Başarısız","/auth");
        }else{
            return new ApiError(HttpStatus.OK,"Yetkilendirme Başarılı","/auth");
        }

    }
}
