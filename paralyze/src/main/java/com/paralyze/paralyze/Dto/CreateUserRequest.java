package com.paralyze.paralyze.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    private long userId;
    @NotNull
    private String userName;
    @NotNull
    private String displayName;
    @NotNull
    private String password;

}
