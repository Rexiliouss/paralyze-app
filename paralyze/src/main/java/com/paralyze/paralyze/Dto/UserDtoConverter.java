package com.paralyze.paralyze.Dto;

import com.paralyze.paralyze.Model.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {
    public UserDto converter(User from){
        return new UserDto(from.getUserId(),
                from.getUserName(),
                from.getDisplayName(),
                from.getPassword()
        );

    }
}
