package com.paralyze.paralyze.Registration.Model;

import lombok.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ParalyzeRegistrationRequest {
    private final String name;
    private final String username;
    private final String email;
    private final String password;
}
