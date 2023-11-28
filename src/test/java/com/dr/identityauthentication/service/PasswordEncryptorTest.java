package com.dr.identityauthentication.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class PasswordEncryptorTest {

    private final PasswordEncoder encoder = new BCryptPasswordEncoder();
    private final PasswordEncryptor passwordEncryptor = new PasswordEncryptor(encoder);

    private final String encryptedPassword = "$2a$10$MgRSfrQ7SEtsyvynGonge.BVDk5HbJf9XCuIKckNnjKF0izZI9jlK";

    @Test void shouldReturnEncryptedPassword() {
        assertThat(passwordEncryptor.encrypt("password")).isNotEqualTo(encryptedPassword);
    }

    @Test void shouldNotMatchIfOneCharIsChanged() {
        assertThat(passwordEncryptor.match("Password", encryptedPassword)).isFalse();
    }

    @Test void shouldMatchWithEncryptedPassword() {
        assertThat(passwordEncryptor.match("password", encryptedPassword)).isTrue();
    }
}