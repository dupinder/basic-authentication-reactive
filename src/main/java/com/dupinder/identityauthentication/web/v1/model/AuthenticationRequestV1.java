package com.dupinder.identityauthentication.web.v1.model;

import com.dupinder.identityauthentication.core.model.Authentication;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class AuthenticationRequestV1 {
    String email;
    String password;

    public Authentication toAuthentication() {
        return new Authentication(this.email, this.password);
    }
}
