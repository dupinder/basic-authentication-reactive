package com.dupinder.identityauthentication.web.v1.api;

import com.dupinder.identityauthentication.core.service.AuthenticationService;
import com.dupinder.identityauthentication.external.tenancy.TenancyResolver;
import com.dupinder.identityauthentication.web.v1.model.AuthenticationRequestV1;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController @RequestMapping("/v1/authentication") @AllArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;
    private final TenancyResolver tenancyResolver;

    @PostMapping("")
    public Mono<String> authenticate(@NotBlank @RequestBody AuthenticationRequestV1 authenticationRequest, @NotBlank @RequestHeader String origin) {
        var tenantId = tenancyResolver.findTenantMetadata(origin).getTenantId();
        return service.authenticate(authenticationRequest.toAuthentication(), tenantId);
    }
}
