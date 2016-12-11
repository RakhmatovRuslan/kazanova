package com.javacodegeeks.drools.gui;/**
 * Created by Tatyana on 12/8/2016.
 */

import com.javacodegeeks.drools.Question;
import com.javacodegeeks.drools.Questionnaire;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.mvel2.util.Make;

public class MainApp extends Application {

    private static Stage mainStage;
    private RuleEngineClass ruleEngineClass;
    private Questionnaire questionnaire;
    private Question question;
    private String inputMessage="Hey developer, what is your problem?";
    private boolean first;
    private boolean isInserted;

    public MainApp(){
        ruleEngineClass=new RuleEngineClass();
        first=true;
        isInserted=false;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        mainStage = primaryStage;

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 650, 500, Color.WHITE);

        QuestionnaireVBox vbox=new QuestionnaireVBox();
        vbox.addVBox();
        root.setCenter(vbox.getVbox());
        vbox.initGUI(inputMessage);


        vbox.getNext().setOnAction(event -> {
            if(first){
                ruleEngineClass.defineProblem(vbox.getAnswer().getText());
                questionnaire=new Questionnaire(ruleEngineClass.getTask().getTaskType());
                question = new Question(questionnaire.getQuestions().get(0).getDefinition(), questionnaire.getQuestions().get(0).getVariations());
                question.setAny(true);
                ruleEngineClass.setQuestionnaire(questionnaire);
                ruleEngineClass.setGlobals();
                first=false;
               vbox.setScene(question.getVariations());
               vbox.getQuestion().setText(question.getDefinition());
            }
            else{

                question.setAnswer(Integer.valueOf(vbox.getGroup().getSelectedToggle().getUserData().toString()));

            if(!isInserted){
                ruleEngineClass.setFactQuestionInsert(ruleEngineClass.getkSession().insert(question));
                ruleEngineClass.getkSession().fireAllRules();
                isInserted= true;
            }
            else{
                ruleEngineClass.getkSession().update(ruleEngineClass.getFactQuestionInsert(),question);
                ruleEngineClass.getkSession().fireAllRules();
            }

            if(question.hasAny()){
                vbox.setScene(question.getVariations());
                vbox.getQuestion().setText(question.getDefinition());}
            else{
                ruleEngineClass.insertExpressions();
                ruleEngineClass.getkSession().fireAllRules();
                vbox.setResultScene(ruleEngineClass.getTask().toString());
            }
            }


        });

        primaryStage.setTitle("Kazanova DSS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
