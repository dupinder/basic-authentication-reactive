package com.dr.identityauthentication.service;

import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncryptor {
    private final PasswordEncoder encoder;

    public PasswordEncryptor(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public String encrypt(String password){
        return encoder.encode(password);
    }

    public boolean match(String password, String encryptedPassword){
        return encoder.matches(password, encryptedPassword);
    }

}
