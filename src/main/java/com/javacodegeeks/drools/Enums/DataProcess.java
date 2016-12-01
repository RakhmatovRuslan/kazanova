package com.javacodegeeks.drools.Enums;

/**
 * Created by Ruslan on 11/29/2016.
 */
public enum DataProcess {
    NO_ONE("None one"), SERIALIZATION("Serialization"), DESERIALIZATION("Deserialization");
    private String name;

    DataProcess(String name) {
        this.name = name;
    }
}
