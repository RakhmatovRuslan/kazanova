package com.javacodegeeks.drools;

import com.aliasi.spell.EditDistance;
import com.aliasi.util.Distance;
import com.javacodegeeks.drools.Enums.TaskType;
import com.javacodegeeks.drools.Tasks.JsonParserTask;
import com.javacodegeeks.drools.Tasks.Task;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ruslan on 12/1/2016.
 */
public class ProblemAnalyzer {
    static final Distance<CharSequence> distance
            = new EditDistance(true);
    static final String [] jsonLibClassifiers = {"json", "parser"};
    private Map<TaskType,String []> classifiers = null;

    public ProblemAnalyzer() {
        classifiers = new HashMap<>();
        classifiers.put(TaskType.JSON_PARSER,jsonLibClassifiers);
    }

    public  Task analyzerProblemDefinition(String problemDefinition){
        String [] words = problemDefinition.split(" ");
        for(Map.Entry<TaskType,String[]> entry : classifiers.entrySet()){
            TaskType classifierName = entry.getKey();
            String [] classifier = entry.getValue();
            for (String keyWord : classifier) {
                for (String word : words) {
                    double disValue = distance.distance(keyWord, word);
                    if (disValue == 0.0 || disValue == 1) {
                        return TaskFactory.getInstance().getTask(classifierName);
                    }
                }
            }
        }
        return new Task();
    }
}
