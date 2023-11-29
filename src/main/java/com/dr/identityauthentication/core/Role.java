package com.dr.identityauthentication.core;

public enum Role {
    Admin(1),
    User(2);

    private int value;
    int getValue() {
        return value;
    }
    Role(int value) {
        this.value = value;
    }
}
