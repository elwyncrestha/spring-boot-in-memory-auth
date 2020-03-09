package com.github.elwyncrestha.springbootinmemoryauth.core.enums;

/**
 * @author Elvin Shrestha on 3/9/2020
 */
public enum Status {

    INACTIVE("Inactive"),
    ACTIVE("Active"),
    DELETED("Deleted");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
