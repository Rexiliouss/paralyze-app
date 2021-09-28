package com.paralyze.paralyze.Dto;

import com.paralyze.paralyze.Model.User;

public class UserDtoConverter {
    public UserDto converter(User from){
        return new UserDto(
                from.getUserName(),
                from.getDisplayName(),
                from.getPassword()
        );
    }
}
