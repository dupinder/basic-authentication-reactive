package com.dr.identityauthentication.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class Authentication {
    String username;
    String password;
}
