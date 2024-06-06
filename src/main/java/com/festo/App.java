package com.festo;

import com.festo.communication.BackendComm;
import com.festo.communication.Direction;
import com.festo.communication.Gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        new Gui().start(stage);
    }
    
    public static void main(String[] args) {
        launch();
    }

}