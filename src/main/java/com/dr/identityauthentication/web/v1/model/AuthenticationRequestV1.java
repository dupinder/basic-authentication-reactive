package com.dr.identityauthentication.web.v1.model;

import com.dr.identityauthentication.core.model.Authentication;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class AuthenticationRequestV1 {
    String username;
    String password;

    public Authentication toAuthentication() {
        return new Authentication(this.username, this.password);
    }
}
