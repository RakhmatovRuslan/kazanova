package com.javacodegeeks.drools.gui;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.effect.Effect;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tatyana on 12/8/2016.
 */
public class QuestionnaireVBox extends VBox {
    private Label question;
    private TextArea answer;
    private Button next;
    private VBox vbox;
    private boolean isInserted;
    private ToggleGroup group;
    private ArrayList<RadioButton> radioButtons;
    private Text title;
    private Label info;
    private String inputMessage="Hey developer, what is your problem?";



    public void addVBox() {
        vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        isInserted=false;
            }

    public void initGUI(){
        info = new Label();
        info.setText("Let's Pick Up Java Library/Framework");
        info.setFont(Font.font("Broadway",FontWeight.MEDIUM,18));
        info.setTextFill(Color.DARKGREY);
        //info.setTranslateX(100);
        vbox.getChildren().addAll(info);

        title = new Text("Questions");
        title.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
        vbox.getChildren().add(title);

        question=new Label();
        question.setText(inputMessage);
        question.setFont(Font.font("Calibri",FontWeight.MEDIUM,18));
        vbox.getChildren().addAll(question);

        answer=new TextArea();
        answer.setMaxWidth(380);
        answer.setMaxHeight(50);
        vbox.getChildren().addAll(answer);

        next=new Button();
        next.setText("Next");
        next.setTranslateX(340);
        vbox.getChildren().addAll(next);

    }

    public void setScene(List<String> variations){

        vbox.getChildren().clear();
        vbox.getChildren().addAll(title,question);
        group=new ToggleGroup();
        radioButtons= new ArrayList<>();
        RadioButton r;
        for(int i=0;i<variations.size();i++){
            r=new RadioButton();
            r.setUserData(i);
            r.setText(variations.get(i));
            r.setToggleGroup(group);
            radioButtons.add(r);
        }
        vbox.getChildren().addAll(radioButtons);
        vbox.getChildren().addAll(next);

    }

    public void setResultScene(String result){

        vbox.getChildren().clear();
        question.setText("Result:");
        Label viewResult=new Label();
        viewResult.setText(result);
        vbox.getChildren().addAll(title,question,viewResult);

    }

    public ToggleGroup getGroup() {
        return group;
    }

    public void setGroup(ToggleGroup group) {
        this.group = group;
    }

    public Label getQuestion() {
        return question;
    }

    public void setQuestion(Label question) {
        this.question = question;
    }

    public TextArea getAnswer() {
        return answer;
    }

    public void setAnswer(TextArea answer) {
        this.answer = answer;
    }

    public Button getNext() {
        return next;
    }

    public void setNext(Button next) {
        this.next = next;
    }

    public VBox getVbox() {
        return vbox;
    }

    public void setVbox(VBox vbox) {
        this.vbox = vbox;
    }
}
