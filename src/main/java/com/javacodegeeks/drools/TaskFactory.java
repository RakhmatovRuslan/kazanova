package com.javacodegeeks.drools;

import com.javacodegeeks.drools.enums.TaskType;
import com.javacodegeeks.drools.tasks.JsonParserTask;
import com.javacodegeeks.drools.tasks.Task;

/**
 * Created by Ruslan on 12/1/2016.
 */
public class TaskFactory {
    private static TaskFactory ourInstance = new TaskFactory();

    public static TaskFactory getInstance() {
        return ourInstance;
    }

    private TaskFactory() {
    }

    public Task getTask(TaskType taskType){
        if(taskType == null){
            return null;
        }
        if(taskType == TaskType.JSON_PARSER){
            return new JsonParserTask("This library is used for json serialization/deserialization parsing task");
        }else if (taskType == TaskType.WEB_FRAMEWORK){
            return new Task();
        }
        return null;
    }
}
