package com.javacodegeeks.drools.Tasks;

/**
 * Created by Ruslan on 11/29/2016.
 */
public class Task {
    protected String framework;
    protected String library;
    protected String definition;

    public Task() {
    }

    public Task(String framework, String library, String definition) {
        this.framework = framework;
        this.library = library;
        this.definition = definition;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }

    public String getLibrary() {
        return library;
    }

    public void setLibrary(String library) {
        this.library = library;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
