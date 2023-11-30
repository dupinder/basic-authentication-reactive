package com.dupinder.identityauthentication.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;

@Configuration @EnableWebFluxSecurity
public class WebSecurityConfig {

    @Bean public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
                .formLogin(ServerHttpSecurity.FormLoginSpec::disable)
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
                .authorizeExchange(exchanges -> exchanges
                        .anyExchange().permitAll()
                                           /*.pathMatchers(GET, "/authentication/swagger-ui.html**", "/authentication/webjars/**", "/authentication/api-docs/**", "/authentication/swagger-resources/**", "/authentication/favicon.ico").permitAll()
                                           .pathMatchers(POST, "/authentication/v1/authentication**").permitAll()*/
                        );

        return http.build();
    }
}
