package com.paralyze.paralyze.Registration.Service;

import com.paralyze.paralyze.Registration.Model.ParalyzeRegistrationRequest;
import com.paralyze.paralyze.User.Model.ParalyzeUser;
import com.paralyze.paralyze.User.Model.ParalyzeUserRole;
import com.paralyze.paralyze.User.Service.ParalyzeUserService;
import org.springframework.stereotype.Service;

@Service
public class ParalyzeRegistrationService {
    private final EmailValidator emailValidator;
    private final ParalyzeUserService paralyzeUserService;


    public ParalyzeRegistrationService(EmailValidator emailValidator,ParalyzeUserService paralyzeUserService){
        this.emailValidator=emailValidator;
        this.paralyzeUserService=paralyzeUserService;
    }

    public String register(ParalyzeRegistrationRequest request){
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException("Email is not valid");
        }
        return this.paralyzeUserService.signUp(new ParalyzeUser(
                request.getName(),
                request.getUsername(),
                request.getEmail(),
                request.getPassword(),
                ParalyzeUserRole.USER
        ));
    }
}
