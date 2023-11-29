package com.dr.identityauthentication.service;

import com.dr.identityauthentication.core.model.Authentication;
import com.dr.identityauthentication.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserAccountRepository repository;

    public AuthenticationService(UserAccountRepository repository) {
        this.repository = repository;
    }

    public String authenticate(Authentication authentication) {
        /*repository.findByUsername(authentication.getUsername())
                .filter(userAccount -> userAccount.getPassword().equals(authentication.getPassword()))
                .switchIfEmpty(Mono.error(new AuthenticationException("Invalid username or password")))
                .subscribe();*/
        return null;
    }
}
