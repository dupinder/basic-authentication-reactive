package com.dr.identityauthentication.web.v1.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserAccountV1 {

     @NotBlank String username;
     @NotBlank String password;
     @NotBlank String email;
     @NotBlank String phone;
     @NotBlank String userId;
     @NotBlank String role;
     @NotBlank String tenantId;
     @NotBlank String createdBy;
     @NotBlank String updatedBy;

}
