package com.dupinder.identityauthentication.config;

import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration @Profile("default") @Slf4j
@EnableConfigurationProperties({ R2dbcProperties.class, FlywayProperties.class })

// Flyway migration configuration for production application.
public class FlywayConfig {

    @Bean public boolean flyway(FlywayProperties flywayProperties, R2dbcProperties r2dbcProperties) {
        var flyway = Flyway.configure().cleanDisabled(true).locations("classpath:db/migration/mssql")
                .dataSource(flywayProperties.getUrl(), r2dbcProperties.getUsername(), r2dbcProperties.getPassword())
                .baselineOnMigrate(true).load();
        flyway.migrate();
        log.info("Flyway migration completed");
        return true;
    }
}
