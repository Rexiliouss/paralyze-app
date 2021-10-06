package com.paralyze.paralyze.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String userName;
    private String displayName;
    private String password;

    public User(String userName, String displayName, String password){
        this.userName=userName;
        this.displayName=displayName;
        this.password=password;
    }
}
