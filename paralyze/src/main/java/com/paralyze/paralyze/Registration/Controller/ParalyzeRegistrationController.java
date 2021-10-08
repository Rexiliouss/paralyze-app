package com.paralyze.paralyze.Registration.Controller;

import com.paralyze.paralyze.Registration.Model.ParalyzeRegistrationRequest;
import com.paralyze.paralyze.Registration.Service.ParalyzeRegistrationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
public class ParalyzeRegistrationController {
    private ParalyzeRegistrationService registrationService;

    public ParalyzeRegistrationController(ParalyzeRegistrationService registrationService){
        this.registrationService=registrationService;
    }

    @PostMapping("/registration")
    public String register(@RequestBody ParalyzeRegistrationRequest registrationRequest){
        return registrationService.register(registrationRequest);
    }
}
