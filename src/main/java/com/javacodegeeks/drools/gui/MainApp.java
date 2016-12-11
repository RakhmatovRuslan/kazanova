package com.javacodegeeks.drools.gui;/**
 * Created by Tatyana on 12/8/2016.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MainApp extends Application {

    private static Stage mainStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        mainStage = primaryStage;

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 650, 500, Color.WHITE);

        VBox vbox=new QuestionnaireVBox().addVBox();
        root.setCenter(vbox);

        primaryStage.setTitle("Kazanova DSS");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
