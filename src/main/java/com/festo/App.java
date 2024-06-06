package com.festo;

import com.festo.communication.BackendComm;
import com.festo.communication.Direction;
import com.festo.communication.Robot;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * JavaFX App
 */
public class App extends Application {


    @Override
    public void start(Stage stage) throws FileNotFoundException {
        Robot robot = new Robot();
        TextField tf = new TextField(robot.getname());
        var lb = new Label("Result: ");
        lb.setText("Enter robot name: ");
        Button bt_e = new Button("Move " + robot.getname() + " to east");
        bt_e.setOnAction((e) -> {
            int statusCode = BackendComm.moveRobot( robot.getname(), Direction.EAST);
            if (statusCode == 200) {
                lb.setText("Result: SUCCESS");
            } else {
                lb.setText("Result: FAILURE");
            }
        });
        Button bt_w = new Button("Move " + robot.getname() + " to west");
        bt_w.setOnAction((e) -> {
            int statusCode = BackendComm.moveRobot(robot.getname(), Direction.WEST);
            if (statusCode == 200) {
                lb.setText("Result: SUCCESS");
            } else {
                lb.setText("Result: FAILURE");
            }
        });
        Button bt_n = new Button("Move " + robot.getname() + " to north");
        bt_n.setOnAction((e) -> {
            int statusCode = BackendComm.moveRobot(robot.getname(), Direction.NORTH);
            if (statusCode == 200) {
                lb.setText("Result: SUCCESS");
            } else {
                lb.setText("Result: FAILURE");
            }
        });
        Button bt_s = new Button("Move " + robot.getname() + " to south");
        bt_s.setOnAction((e) -> {
            int statusCode = BackendComm.moveRobot(robot.getname(), Direction.SOUTH);
            if (statusCode == 200) {
                lb.setText("Result: SUCCESS");
            } else {
                lb.setText("Result: FAILURE");
            }
        });
        Button bt_name = new Button("Set robot name");
        bt_name.setOnAction((e)-> {
            robot.setname(lb.getText());
        });

        VBox vb = new VBox();
        vb.setPadding(new Insets(10, 10, 10, 10));
        vb.setSpacing(10);
        vb.getChildren().addAll(tf, bt_n, bt_w, bt_e, bt_s, lb);
        var scene = new Scene(vb, 640, 480);

        

        stage.setScene(scene);
        
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}