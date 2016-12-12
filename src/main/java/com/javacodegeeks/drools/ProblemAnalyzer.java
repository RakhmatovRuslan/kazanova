package com.javacodegeeks.drools;

import com.aliasi.spell.EditDistance;
import com.aliasi.util.Distance;
import com.javacodegeeks.drools.enums.TaskType;
import com.javacodegeeks.drools.tasks.Task;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ruslan on 12/1/2016.
 */
public class ProblemAnalyzer {
    static final Distance<CharSequence> distance
            = new EditDistance(true);
    static final String [] jsonLibDictionary = {"json", "java"};
    static final String [] webFrameWorkDictionary = {"java", "web"};
    private Map<TaskType,String []> classifiers = null;

    public ProblemAnalyzer() {
        classifiers = new HashMap<>();
        classifiers.put(TaskType.JSON_PARSER, jsonLibDictionary);
        classifiers.put(TaskType.WEB_FRAMEWORK, webFrameWorkDictionary);
    }

    public  Task analyzerProblemDefinition(String problemDefinition){
        String [] words = problemDefinition.split(" ");
        for(Map.Entry<TaskType,String[]> entry : classifiers.entrySet()){
            int counter=0;
            TaskType classifierName = entry.getKey();
            String [] classifier = entry.getValue();
            for (String keyWord : classifier) {
                for (String word : words) {
                    double disValue = distance.distance(keyWord, word);
                    if (disValue == 0.0 || disValue == 1) {
                        counter++;
                    }
                }
            }
            if(counter == classifier.length)
            return TaskFactory.getInstance().getTask(classifierName);
        }
        return new Task();
    }
}
