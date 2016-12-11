package com.javacodegeeks.drools.tasks;

import com.javacodegeeks.drools.enums.Features;
import com.javacodegeeks.drools.enums.TaskType;
import com.javacodegeeks.drools.frameworks.Framework;
import com.javacodegeeks.drools.libraries.Library;

/**
 * Created by Ruslan on 11/29/2016.
 */
public class Task {
    protected Framework framework;
    protected Library library;
    protected String definition;
    protected Features featurePriority;
    protected String reason;
    protected TaskType taskType;
    protected boolean findCorrelation;


    public Task() {
    }

    public Framework getFramework() {
        return framework;
    }

    public void setFramework(Framework framework) {
        this.framework = framework;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public Features getFeaturePriority() {
        return featurePriority;
    }

    public void setFeaturePriority(Features featurePriority) {
        this.featurePriority = featurePriority;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isFindCorrelation() {
        return findCorrelation;
    }

    public void setFindCorrelation(boolean findCorrelation) {
        this.findCorrelation = findCorrelation;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    @Override
    public String toString() {
        return "Task{" +
                "framework=" + framework +
                ", library=" + library +
                ", definition='" + definition + '\'' +
                ", featurePriority=" + featurePriority +
                ", reason='" + reason + '\'' +
                '}';
    }
}
