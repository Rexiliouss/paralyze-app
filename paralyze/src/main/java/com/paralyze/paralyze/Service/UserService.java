package com.paralyze.paralyze.Service;

import com.paralyze.paralyze.Dto.CreateUserRequest;
import com.paralyze.paralyze.Dto.UserDto;
import com.paralyze.paralyze.Dto.UserDtoConverter;
import com.paralyze.paralyze.Model.User;
import com.paralyze.paralyze.Repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class UserService {
    UserRepository userRepository;
    UserDtoConverter userDtoConverter;
    PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,UserDtoConverter userDtoConverter){
        this.userRepository=userRepository;
        this.userDtoConverter=userDtoConverter;
    }
    public UserDto createUser(CreateUserRequest createUserRequest){
        //password Encryptor
        String encryptedPassword=this.passwordEncoder.encode(createUserRequest.getPassword());
        Logger.getLogger(encryptedPassword);
        User user = new User(createUserRequest.getUserId(),
                createUserRequest.getUserName(),
                createUserRequest.getDisplayName(),
                createUserRequest.getPassword());
        return userDtoConverter.converter(this.userRepository.save(user));
    }
    public List<UserDto> findAllUsers(){
        return userRepository.findAll().
                stream().map(x -> userDtoConverter.converter(x)).collect(Collectors.toList());
    }


}
