package com.paralyze.paralyze.Dto;

import com.paralyze.paralyze.Model.User;

public class UserDtoConverter {
    public UserDto converter(User from){
        return new UserDto(from.getId(),
                from.getUserName(),
                from.getDisplayName(),
                from.getPassword()
        );
    }
}
