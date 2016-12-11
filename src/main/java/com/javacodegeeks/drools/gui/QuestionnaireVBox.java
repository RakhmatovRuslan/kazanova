package com.javacodegeeks.drools.gui;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tatyana on 12/8/2016.
 */
public class QuestionnaireVBox extends VBox {
    public Label question;
    public TextArea answer;
    public Button next;
    private VBox vbox;
    private boolean isInserted;
    private ToggleGroup group;
    private ArrayList<RadioButton> radioButtons;
    private Text title;

    public void addVBox() {
        vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        isInserted=false;
            }

    public void initGUI(String inputMessage){
        title = new Text("Questions");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vbox.getChildren().add(title);

        question=new Label();
        question.setText(inputMessage);
        vbox.getChildren().addAll(question);

        answer=new TextArea();
        vbox.getChildren().addAll(answer);

        next=new Button();
        next.setText("Next");
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
