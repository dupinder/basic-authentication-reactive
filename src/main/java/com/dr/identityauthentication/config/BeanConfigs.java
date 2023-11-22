package com.dr.identityauthentication.config;

import io.r2dbc.h2.H2ConnectionConfiguration;
import io.r2dbc.h2.H2ConnectionFactory;
import io.r2dbc.mssql.MssqlConnectionConfiguration;
import io.r2dbc.mssql.MssqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.r2dbc.R2dbcProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.r2dbc.core.DatabaseClient;

import static org.springframework.r2dbc.core.DatabaseClient.create;

@Configuration @EnableConfigurationProperties({ R2dbcProperties.class})
public class BeanConfigs {

    @Bean public DatabaseClient databaseClient(@Autowired ConnectionFactory connectionFactory) { return create(connectionFactory);}

    @Bean public ConnectionFactory dbConnectionFactory(@Value("${spring.r2dbc.password}") String password, @Value("${spring.r2dbc.username}") String username, @Value("${spring.r2dbc.database}") String database, @Value("${spring.r2dbc.host}") String host, @Value("${spring.r2dbc.url}") String url) {

        if(url.contains("sqlserver") || url.contains("mssql")) {
            return new MssqlConnectionFactory(MssqlConnectionConfiguration.builder()
                                                      .host(host)
                                                      .database(database)
                                                      .username(username)
                                                      .password(password).build());
        }
        else {
            return new H2ConnectionFactory(H2ConnectionConfiguration.builder()
                                                   .inMemory(database)
                                                   .username(username)
                                                   .password(password).build());
        }
    }
}
