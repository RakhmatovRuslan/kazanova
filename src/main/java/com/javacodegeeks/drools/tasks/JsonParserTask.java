package com.javacodegeeks.drools.tasks;

import com.javacodegeeks.drools.Condition;
import com.javacodegeeks.drools.enums.DataProcess;
import com.javacodegeeks.drools.enums.DataType;
import com.javacodegeeks.drools.enums.Features;

/**
 * Created by Ruslan on 11/29/2016.
 */
public class JsonParserTask extends Task {
    private DataType dataType;
    private DataProcess dataProcess;

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
