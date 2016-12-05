package com.javacodegeeks.drools;

import com.javacodegeeks.drools.enums.TaskType;
import com.javacodegeeks.drools.tasks.JsonParserTask;
import com.javacodegeeks.drools.tasks.Task;
import com.javacodegeeks.drools.tasks.WebFrameworkTask;

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
            Task task = new JsonParserTask();
            task.setTaskType(taskType);
            return task;
        }else if (taskType == TaskType.WEB_FRAMEWORK){
            Task task = new WebFrameworkTask();
            task.setTaskType(taskType);
            return task;
        }
        return null;
    }
}
