package com.javacodegeeks.drools;

import com.javacodegeeks.drools.enums.TaskType;
import com.javacodegeeks.drools.tasks.*;

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
        Task task = null;
        if(taskType == TaskType.JSON_PARSER){
            task = new JsonParserTask();
        }else if (taskType == TaskType.WEB_FRAMEWORK){
            task = new WebFrameworkTask();
       }else if(taskType == TaskType.ORM_FRAMEWORK){
            task = new OrmFrameworkTask();
       }else if(taskType == TaskType.GUI_FRAMEWORK){
            task = new GuiFrameworkTask();
       }else if(taskType == TaskType.APPLICATION_SERVER){
            task = new ApplicationServerTask();
       }
        task.setTaskType(taskType);
        return task;

    }
}
