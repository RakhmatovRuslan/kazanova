package com.javacodegeeks.drools.enums;

/**
 * Created by Ruslan on 11/30/2016.
 */
public enum Features {
    NONE("None"),
    PERFORMANCE("Performance"),
    SIZE("Size"),
    RAPID_APPLICATION_DEVELOPMENT("Rapid application development"),
    COMPLEXITY("Complexity"),
    EASE_OF_USE("Ease of use"),
    DOCUMENTATION_COMMUNITY("Documentation and Community"),
    ECOSYSTEM("Ecosystem"),
    SCALABILITY("Scalability"),
    CODE("Code"),
    LOOK_FEEL("Look and Feel"),
    POPULARITY("Popularity");
    ;

    private String name;

    Features(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
