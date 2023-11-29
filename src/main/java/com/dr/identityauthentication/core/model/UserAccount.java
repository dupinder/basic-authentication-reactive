package com.dr.identityauthentication.core.model;

import lombok.Data;

@Data
public class UserAccount {
    String username;
    String password;
    String email;
    String phone;
    String userId;
    String role;
    String tenantId;
    String createdBy;
    String updatedBy;
}
