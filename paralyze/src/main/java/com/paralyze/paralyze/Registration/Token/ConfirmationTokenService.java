package com.paralyze.paralyze.Registration.Token;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConfirmationTokenService {
    private final ConfirmationTokenRepository confirmationTokenRepository;

    public ConfirmationTokenService(ConfirmationTokenRepository confirmationTokenRepository){
        this.confirmationTokenRepository=confirmationTokenRepository;
    }
    public void saveConfirmationToken(ConfirmationToken confirmationToken){
        this.confirmationTokenRepository.save(confirmationToken);
    }
    public Optional<ConfirmationToken> getToken(String token){
        return this.confirmationTokenRepository.findByToken(token);
    }
}
