package com.dupinder.identityauthentication.core.service;

import com.dupinder.identityauthentication.core.entity.UserAccount;
import com.dupinder.identityauthentication.core.model.Authentication;
import com.dupinder.identityauthentication.core.repository.UserAccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service @Slf4j
public class AuthenticationService {

    private final UserAccountRepository repository;
    private final PasswordEncryptor encryptor;

    public AuthenticationService(UserAccountRepository repository, PasswordEncryptor encryptor) {
        this.repository = repository;
        this.encryptor = encryptor;
    }

    public Mono<String> authenticate(Authentication authentication, UUID tenantId) {
        return repository.findByEmailAndTenantId(authentication.getEmail(), tenantId)
                .filter(userAccount -> doPasswordMatch(authentication, userAccount, tenantId))
                .map(UserAccount::getEmail);
    }

    private boolean doPasswordMatch(Authentication authentication, UserAccount userAccount, UUID tenantId) {
        if(encryptor.match(authentication.getPassword(), userAccount.getPassword())) {
            log.info("Authentication Success!");
            return true;
        }
        else {
            log.info("Authentication Failed! Email {} tenantId {}", authentication.getEmail(), tenantId);
            return false;
        }

    }
}
