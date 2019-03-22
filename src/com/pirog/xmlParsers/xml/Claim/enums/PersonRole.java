package com.pirog.xmlParsers.xml.Claim.enums;

public enum PersonRole {
    CLAIMANT("Claimant"), REPORTER("Reporter"), OTHER("Other");

    private final String role;

    PersonRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
