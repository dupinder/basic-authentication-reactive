package com.dr.identityauthentication.config;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayProperties;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration @Slf4j @Profile("dev")
@EnableConfigurationProperties({ R2dbcProperties.class, FlywayProperties.class })
// Flyway migration configuration local development and test environments.
public class FlywayDevConfig {

    @SneakyThrows @Bean public boolean cleanAndMigrate(FlywayProperties flywayProperties, R2dbcProperties r2dbcProperties) {
        var dbType = (flywayProperties.getUrl().contains("sqlserver") || flywayProperties.getUrl().contains("mssql")) ? "mssql" : "h2";
        var dataSource = DataSourceBuilder.create().url(flywayProperties.getUrl()).username(r2dbcProperties.getUsername()).password(r2dbcProperties.getPassword()).build();
        var flyway = Flyway.configure().cleanDisabled(false).dataSource(dataSource).locations("classpath:db/migration/" + dbType, "classpath:testdata/").load();
        flyway.clean();
        flyway.migrate();
        return true;
    }
}
