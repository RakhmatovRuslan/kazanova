package com.javacodegeeks.drools.Tasks;

import com.javacodegeeks.drools.Condition;
import com.javacodegeeks.drools.Enums.DataProcess;
import com.javacodegeeks.drools.Enums.DataType;
import com.javacodegeeks.drools.Enums.Features;

/**
 * Created by Ruslan on 11/29/2016.
 */
public class JsonParserTask extends Task {
    private DataType dataType;
    private DataProcess dataProcess;
    private Features featurePriority;

    public JsonParserTask() {
        this.featurePriority = Features.NONE;
    }

    public JsonParserTask(String definition) {
        this.definition = definition;
        this.featurePriority = Features.NONE;
    }

    public JsonParserTask(String definition, Features featurePriority,DataType dataType) {
        this.definition = definition;
        this.dataType = dataType;
        this.featurePriority = featurePriority;
    }

    public JsonParserTask(String definition, Features featurePriority) {
        this.definition = definition;
        this.featurePriority = featurePriority;
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

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public DataProcess getDataProcess() {
        return dataProcess;
    }

    public void setDataProcess(DataProcess dataProcess) {
        this.dataProcess = dataProcess;
    }

    public Features getFeaturePriority() {
        return featurePriority;
    }

    public void setFeaturePriority(Features featurePriority) {
        this.featurePriority = featurePriority;
    }

    public void askForConditions(){
        this.featurePriority = Condition.inputJsonParserFeatureCondition();
        if(this.featurePriority == Features.PERFORMANCE)
        this.dataType = Condition.inputJsonParserDataTypeCondition();
    }

    @Override
    public String toString() {
        return "JsonParserTask{" +
                "framework='" + framework + '\'' +
                ", library='" + library + '\'' +
                ", definition='" + definition + '\'' +
                ", dataType=" + dataType +
                '}';
    }
}
