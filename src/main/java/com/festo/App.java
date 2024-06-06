package com.festo;

import com.festo.communication.BackendComm;
import com.festo.communication.Direction;
import com.festo.communication.Robot;

import javafx.application.Application;
import javafx.geometry.Insets;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
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
        
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        var lb = new Label("Result: ");
        lb.setText("Enter robot name: ");
        Button bt_e = new Button("to east");
        GridPane.setConstraints(bt_e, 2, 1);
        bt_e.setOnAction((e) -> {
            int statusCode = BackendComm.moveRobot( robot.getname(), Direction.EAST);
            if (statusCode == 200) {
                lb.setText("Result: SUCCESS");
            } else {
                lb.setText("Result: FAILURE");
            }
        });
        Button bt_w = new Button("to west");
        GridPane.setConstraints(bt_w, 0, 1);
        bt_w.setOnAction((e) -> {
            int statusCode = BackendComm.moveRobot(robot.getname(), Direction.WEST);
            if (statusCode == 200) {
                lb.setText("Result: SUCCESS");
            } else {
                lb.setText("Result: FAILURE");
            }
        });
        Button bt_n = new Button("to north");
        GridPane.setConstraints(bt_n, 1, 0);
        bt_n.setOnAction((e) -> {
            int statusCode = BackendComm.moveRobot(robot.getname(), Direction.NORTH);
            if (statusCode == 200) {
                lb.setText("Result: SUCCESS");
            } else {
                lb.setText("Result: FAILURE");
            }
        });
        Button bt_s = new Button("to south");
        GridPane.setConstraints(bt_s, 1, 2);
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

        gridPane.getChildren().addAll(bt_e, bt_n, bt_s, bt_w);
        Image image = new Image(new FileInputStream("src/main/resources/com/festo/labyrinth-simple.png"));
        ImageView imageView = new ImageView(image);
        VBox vb = new VBox();
        vb.setPadding(new Insets(10, 10, 10, 10));
        vb.setSpacing(10);
        //vb.getChildren().addAll(tf, bt_n, bt_w, bt_e, bt_s, lb, ImageView);
        vb.getChildren().addAll(lb, tf, gridPane, imageView);
        var scene = new Scene(vb, 640, 480);

        

        stage.setScene(scene);
        
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}