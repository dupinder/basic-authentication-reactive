package com.dupinder.identityauthentication.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Timestamp;
import java.util.UUID;

@Data @AllArgsConstructor @NoArgsConstructor @Table("user_account")
public class UserAccount {
    @Id Integer id;
    String username;
    String password;
    String email;
    UUID userId;
    String role;
    UUID tenantId;
    UUID createdBy;
    Timestamp createdAt;
    UUID updatedBy;
    Timestamp updatedAt;
}
