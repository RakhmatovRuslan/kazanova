package com.javacodegeeks.drools.enums;

/**
 * Created by Ruslan on 11/29/2016.
 */
public enum DataType {

    NONE("None"), SMALL_DATA("Small data"), BIG_DATA("Big data");

    private String name;

    DataType(String name) {
        this.name = name;
    }
}
