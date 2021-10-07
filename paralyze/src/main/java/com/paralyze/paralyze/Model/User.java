package com.paralyze.paralyze.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

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
    @NotNull(value = "Kullanıcı adı boş bırakılamaz")
    @Size(min = 3, max = 255)
    @Column(unique = true)
    private String userName;
    @NotNull(value = "Rumuz boş bırakılamaz")
    @Size(min = 3, max = 255)
    private String displayName;
    @NotNull(value = "Şifre boş bırakılamaz")
    @Size(min = 4, max = 255)
    private String password;
}
