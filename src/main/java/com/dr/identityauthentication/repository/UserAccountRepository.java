package com.dr.identityauthentication.repository;

import com.dr.identityauthentication.core.model.UserAccount;
import reactor.core.publisher.Mono;

public class UserAccountRepository {

    public Mono<UserAccount> findByUsername(String username) {
        return null;
    }
}
