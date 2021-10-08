package com.paralyze.paralyze.Registration.Token;

import com.paralyze.paralyze.User.Model.ParalyzeUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String token;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime expiresAt;
    //private LocalDateTime confirmedAt;
    @ManyToOne
    @JoinColumn(nullable = false,name = "paralyze_users_id")
    private ParalyzeUser paralyzeUser;

    public ConfirmationToken(String token,
                             LocalDateTime createdAt,
                             LocalDateTime expiresAt,
                             ParalyzeUser paralyzeUser) {
        this.token = token;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.paralyzeUser=paralyzeUser;
    }
}
