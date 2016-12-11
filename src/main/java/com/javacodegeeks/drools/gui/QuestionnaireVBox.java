package com.javacodegeeks.drools.gui;



import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Created by Tatyana on 12/8/2016.
 */
public class QuestionnaireVBox extends VBox {

    public VBox addVBox() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);

        Text title = new Text("Questions");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vbox.getChildren().add(title);

        Label question=new Label();
        question.setText("????");
        vbox.getChildren().addAll(question);

        TextArea answer=new TextArea();
        vbox.getChildren().addAll(answer);

        Button next=new Button();
        next.setText("Next");
        vbox.getChildren().addAll(next);

        return vbox;
    }



}
