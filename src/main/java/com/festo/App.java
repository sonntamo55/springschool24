package com.festo;

import com.festo.communication.BackendComm;
import com.festo.communication.Direction;

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
    static String robot = "gilbert"; //Name of our Robot


    @Override
    public void start(Stage stage) {
        var lb = new Label("Result: ");
        Button bt = new Button("Move ricky to east");
        bt.setOnAction((e) -> {
            int statusCode = BackendComm.moveRobot( robot, Direction.EAST);
            if (statusCode == 200) {
                lb.setText("Result: SUCCESS");
            } else {
                lb.setText("Result: FAILURE");
            }
        });
        VBox vb = new VBox();
        vb.setPadding(new Insets(10, 10, 10, 10));
        vb.setSpacing(10);
        vb.getChildren().addAll(bt, lb);
        var scene = new Scene(vb, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}