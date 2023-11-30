package com.dupinder.identityauthentication.external.tenancy;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor @Getter
public class TenantMetadata {
    String tenantName;
    UUID tenantId;
    String dns;
}
