package com.paralyze.paralyze.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    private long userId;
    @NotNull("Username cannot be null")
    @Size(min = 3)
    private String userName;
    @NotNull("Displayname cannot be null")
    private String displayName;
    @NotNull("Password cannot be null")
    private String password;

}
