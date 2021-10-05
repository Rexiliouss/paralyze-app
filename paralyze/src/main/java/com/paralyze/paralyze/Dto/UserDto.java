package com.paralyze.paralyze.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserDto {
    @NotNull
    private long userId;
    @NotNull
    private String userName;
    @NotNull
    private String displayName;
    @NotNull
    private String password;

}
