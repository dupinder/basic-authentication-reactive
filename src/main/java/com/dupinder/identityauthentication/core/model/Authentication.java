package com.dupinder.identityauthentication.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Authentication {
    String email;
    String password;
}
