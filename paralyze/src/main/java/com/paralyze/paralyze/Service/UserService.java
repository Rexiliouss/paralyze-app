package com.paralyze.paralyze.Service;

import com.paralyze.paralyze.Dto.CreateUserRequest;
import com.paralyze.paralyze.Dto.UserDto;
import com.paralyze.paralyze.Dto.UserDtoConverter;
import com.paralyze.paralyze.Exception.UserNotFoundException;
import com.paralyze.paralyze.Model.User;
import com.paralyze.paralyze.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    UserRepository userRepository;
    UserDtoConverter userDtoConverter;

    public UserService(UserRepository userRepository,UserDtoConverter userDtoConverter){
        this.userRepository=userRepository;
        this.userDtoConverter=userDtoConverter;
    }
    public UserDto createUser(CreateUserRequest createUserRequest){
        User user = new User(createUserRequest.getId(),
                createUserRequest.getUserName(),
                createUserRequest.getDisplayName(),
                createUserRequest.getPassword());
        return userDtoConverter.converter(userRepository.save(user));
    }

    public User findUserById(Long id){
        return userRepository.findById(id).
                orElseThrow(()->new UserNotFoundException("Kullanıcı Bulunamadı"));
    }


}
