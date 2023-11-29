package com.dr.identityauthentication.web.v1.api;

import com.dr.identityauthentication.service.AuthenticationService;
import com.dr.identityauthentication.web.v1.model.AuthenticationRequestV1;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController @RequestMapping("/v1/authentication") @AllArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;

    @PostMapping("")
    public Mono<String> authenticate(@RequestBody AuthenticationRequestV1 authenticationRequest) {
        return Mono.just(service.authenticate(authenticationRequest.toAuthentication()));
    }
}
