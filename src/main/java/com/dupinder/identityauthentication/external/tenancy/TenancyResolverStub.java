package com.dupinder.identityauthentication.external.tenancy;

import java.util.UUID;

public class TenancyResolverStub implements TenancyResolver {

    @Override public TenantMetadata findTenantMetadata(String origin) {
        return new TenantMetadata("test", UUID.fromString("7a1e092e-5102-4a1b-ae54-9d17e01a3c4c"), "test.dupinder.com");
    }

    @Override public TenantMetadata findTenantMetadata(UUID tenantId) {
        return new TenantMetadata("test", UUID.fromString("7a1e092e-5102-4a1b-ae54-9d17e01a3c4c"), "test.dupinder.com");
    }
}
