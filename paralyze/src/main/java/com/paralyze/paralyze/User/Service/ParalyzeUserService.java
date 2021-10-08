package com.paralyze.paralyze.User.Service;

import com.paralyze.paralyze.User.Model.ParalyzeUser;
import com.paralyze.paralyze.User.Repository.ParalyzeUserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParalyzeUserService implements UserDetailsService {
    private final ParalyzeUserRepository paralyzeUserRepository;
    private final static String USER_NOT_FOUND_MSG="The %s not found";
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public ParalyzeUserService(ParalyzeUserRepository paralyzeUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.paralyzeUserRepository=paralyzeUserRepository;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
    }


    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return this.paralyzeUserRepository
                .findByEmail(email).
                orElseThrow(()->
                        new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG,email)));
    }

    public String signUp(ParalyzeUser user){
        boolean userExist = this.paralyzeUserRepository.findByEmail(user.getEmail())
                .isPresent();
        if(userExist){
            throw new IllegalStateException(String.format("Email already taken"));
        }
        String encodedPassword=bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        this.paralyzeUserRepository.save(user);
        return "it works";
    }
    public List<ParalyzeUser> listAllUsers(){
        return this.paralyzeUserRepository.findAll();
    }
}
