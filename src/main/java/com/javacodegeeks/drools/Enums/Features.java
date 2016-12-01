package com.javacodegeeks.drools.Enums;

/**
 * Created by Ruslan on 11/30/2016.
 */
public enum Features {
    NONE("None"), PERFORMANCE("Performance"), SIZE("Size"), EASE_OF_USE("Ease of use");

    private String name;

    Features(String name) {
        this.name = name;
    }
}
