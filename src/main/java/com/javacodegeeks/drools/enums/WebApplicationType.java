package com.javacodegeeks.drools.enums;

/**
 * Created by Ruslan on 12/3/2016.
 */
public enum WebApplicationType {
    REQUEST_BASED("request based type"), COMPONENT_BASED("component based type"), HYBRID("hybrid"), META("meta type"), RIA_BASED("ria based"), NONE("none one");

    private String name;

    WebApplicationType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
