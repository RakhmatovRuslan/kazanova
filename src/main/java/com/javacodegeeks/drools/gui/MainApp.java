package com.javacodegeeks.drools.gui;/**
 * Created by Tatyana on 12/8/2016.
 */

import com.javacodegeeks.drools.Question;
import com.javacodegeeks.drools.Questionnaire;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import org.mvel2.util.Make;

public class MainApp extends Application {

    private static Stage mainStage;
    private RuleEngineClass ruleEngineClass;
    private Questionnaire questionnaire;
    private QuestionnaireVBox box;
    private Question question;
    private boolean first;
    private boolean isInserted;
    private  Stage dialog;

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
      //  primaryStage.initStyle(StageStyle.UTILITY);

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 400, 400, Color.WHITE);

        QuestionnaireVBox vbox=new QuestionnaireVBox();
        vbox.addVBox();
        root.setCenter(vbox.getVbox());
        vbox.initGUI();

        dialog = new Stage();
        dialog.initStyle(StageStyle.DECORATED);
        box = new QuestionnaireVBox();
        box.addVBox();

        Scene sc = new Scene(box,200,200,Color.BLACK);


        vbox.getNext().setOnAction(event -> {
            if(first){
                ruleEngineClass.defineProblem(vbox.getAnswer().getText());
                questionnaire=new Questionnaire(ruleEngineClass.getTask().getTaskType());
                question = new Question(questionnaire.getQuestions().get(0).getDefinition(), questionnaire.getQuestions().get(0).getVariations());
                question.setAny(true);
                ruleEngineClass.setQuestionnaire(questionnaire);
                ruleEngineClass.setGlobals();
                vbox.setScene(question.getVariations());
                vbox.getQuestion().setText(question.getDefinition());

                box.setDialog(ruleEngineClass.getTask().getTaskType().name());

                dialog.setScene(sc);
                dialog.show();

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
                vbox.setResultScene(ruleEngineClass.getTask().getFramework()!=null?ruleEngineClass.getTask().getFramework().getName():ruleEngineClass.getTask().getLibrary().getName());
            }
            }
        });


        box.getYes().setOnAction(e->{

            first=false;
            dialog.close();

        });

        box.getNo().setOnAction(e->{

            primaryStage.close();
            Platform.runLater( () -> new MainApp().start( new Stage() ) );
            dialog.close();

        });
        vbox.getRestart().setOnAction(event->{

            primaryStage.close();
            Platform.runLater( () -> new MainApp().start( new Stage() ) );

        });

        primaryStage.setTitle("Kazanova DSS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
