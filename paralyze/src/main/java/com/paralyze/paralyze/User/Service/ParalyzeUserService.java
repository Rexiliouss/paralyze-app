package com.paralyze.paralyze.User.Service;

import com.paralyze.paralyze.Registration.Token.ConfirmationToken;
import com.paralyze.paralyze.Registration.Token.ConfirmationTokenService;
import com.paralyze.paralyze.User.Model.ParalyzeUser;
import com.paralyze.paralyze.User.Repository.ParalyzeUserRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service

public class ParalyzeUserService implements UserDetailsService {
    private final ParalyzeUserRepository paralyzeUserRepository;
    private final static String USER_NOT_FOUND_MSG="The %s not found";
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    public ParalyzeUserService(ParalyzeUserRepository paralyzeUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder,ConfirmationTokenService confirmationTokenService){
        this.paralyzeUserRepository=paralyzeUserRepository;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
        this.confirmationTokenService=confirmationTokenService;
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
        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(30),
                user);
        confirmationTokenService.saveConfirmationToken(confirmationToken);
        //TODO: Send Mail
        return token;
    }
    public List<ParalyzeUser> listAllUsers(){
        return this.paralyzeUserRepository.findAll();
    }
}
