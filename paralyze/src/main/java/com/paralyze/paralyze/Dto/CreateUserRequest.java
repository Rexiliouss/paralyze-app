package com.paralyze.paralyze.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    private long userId;
    private String userName;
    private String displayName;
    private String password;

    @Override
    public String toString() {
        return "CreateUserRequest{" +
                ", userName='" + userName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
