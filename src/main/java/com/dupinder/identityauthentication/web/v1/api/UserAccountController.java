package com.dupinder.identityauthentication.web.v1.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController @OpenAPIDefinition(info = @Info(title = "User Account APIs", version = "1.0", description = "Documentation APIs v1.0"))
public class UserAccountController {

    @GetMapping("/createAccount")
    public Mono<Boolean> createAccount() {
        return Mono.just(true);
    }
}
