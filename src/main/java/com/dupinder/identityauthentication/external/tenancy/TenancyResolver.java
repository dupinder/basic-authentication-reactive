package com.dupinder.identityauthentication.external.tenancy;

import java.util.UUID;

public interface TenancyResolver {
    public TenantMetadata findTenantMetadata(String origin);
    public TenantMetadata findTenantMetadata(UUID tenantId);
}
