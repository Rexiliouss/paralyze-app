package com.paralyze.paralyze.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDto {
    private long userId;
    private String userName;
    private String displayName;
    private String password;
}
