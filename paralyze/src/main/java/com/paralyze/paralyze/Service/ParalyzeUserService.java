package com.paralyze.paralyze.Service;

import com.paralyze.paralyze.Model.ParalyzeUser;
import com.paralyze.paralyze.Repository.ParalyzeUserRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ParalyzeUserService {
    private ParalyzeUserRepository userRepository;

    public ParalyzeUserService(ParalyzeUserRepository userRepository){
        this.userRepository=userRepository;
    }

}
