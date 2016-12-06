package com.javacodegeeks.drools;

import com.javacodegeeks.drools.enums.TaskType;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Ruslan on 12/7/2016.
 */
public class Questionnaire {
    static final String fileName="questioner.txt";
    private TaskType taskType;
    private List<String> taskProperties;
    private List<Question> questions;

    public Questionnaire(TaskType taskType) {
        this.taskType = taskType;
        taskProperties = new ArrayList<>();
        questions=new ArrayList<>();
        readFile();
    }

    public void readFile(){

        File file = new File(Questionnaire.class.getClassLoader().getResource("knowledge/" + fileName).getFile());
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            List<String> lines = bufferedReader.lines().collect(Collectors.toList());
            lines.forEach(line->{
                String[] statement = line.split(":");
                String[] taskInfo = statement[0].split(" ");
                if(taskType == TaskType.values()[Integer.valueOf(taskInfo[0])]){
                    taskProperties.add(taskInfo[1]);
                    String[] answers= statement[2].split(" ");
                    questions.add(
                            new Question(statement[1],Arrays.asList(answers)));
                }
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public List<String> getTaskProperties() {
        return taskProperties;
    }

    public void setTaskProperties(List<String> taskProperties) {
        this.taskProperties = taskProperties;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Questionnaire{" +
                "taskType=" + taskType +
                ", taskProperties=" + taskProperties +
                ", questions=" + questions +
                '}';
    }
}
