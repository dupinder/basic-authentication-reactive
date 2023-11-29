package com.dr.identityauthentication.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
                .formLogin(Customizer.withDefaults())
                //.httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers(HttpMethod.GET, "/authentication/swagger-ui.html**", "/authentication/webjars/**", "/authentication/api-docs/**", "/authentication/swagger-resources/**", "/authentication/favicon.ico").permitAll()
                        .anyExchange().authenticated()
                )
                ;

        return http.build();
    }
}
