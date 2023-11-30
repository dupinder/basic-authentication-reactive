package com.dupinder.identityauthentication.core.repository;

import com.dupinder.identityauthentication.core.entity.UserAccount;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserAccountRepository  extends ReactiveCrudRepository<UserAccount, Integer> {

    Mono<UserAccount> findByEmailAndTenantId(String email, UUID tenantId);
}
