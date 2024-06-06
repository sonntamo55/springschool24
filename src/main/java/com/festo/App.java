package com.festo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.festo.communication.BackendComm;
import com.festo.communication.Direction;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;


public class App extends Application {

    @Override
    public void start(Stage stage) {
        //moveRob(stage);
        //imageshow(stage);
        moveRobWeb(stage);
        
    }

    private void imageshow(Stage stage)
    {
        ImageView iv = null;
        try {
            
            FileInputStream inputstream = new FileInputStream("/home/user/springschool24/src/main/resources/com/festo/labyrinth-simple.png");
            Image image = new Image(inputstream);
            iv = new ImageView(image);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void moveRobWeb(Stage stage)
    {
        Pane pane = new Pane();
        Label lb = new Label("Result: ");
        lb.setPrefHeight(50);
        lb.setAlignment(Pos.CENTER);
        //lb.setVisible(false);
        Button north = new Button("Move North");
        north.setPrefHeight(20);
        north.setLayoutX(200);
        north.setLayoutY(300);
        north.setAlignment(Pos.CENTER);
        north.setOnAction((e) -> {
            int statusCode = BackendComm.moveRobot("jason", Direction.NORTH);
            if (statusCode == 200) {
                lb.setText("Result: SUCCESS Move North");
            } else {
                lb.setText("Result: FAILURE Move North");
            }
        });
        Button south = new Button("Move South");
        south.setPrefHeight(20);
        south.setLayoutX(10);
        south.setLayoutY(300);
        south.setAlignment(Pos.CENTER);
        south.setOnAction((e) -> {
            int statusCode = BackendComm.moveRobot("jason", Direction.SOUTH);
            if (statusCode == 200) {
                lb.setText("Result: SUCCESS Move South");
            } else {
                lb.setText("Result: FAILURE Move South");
            }
        });
        Button east = new Button("Move East");
        east.setPrefHeight(20);
        east.setLayoutX(200);
        east.setLayoutY(350);
        east.setAlignment(Pos.CENTER);
        east.setOnAction((e) -> {
            int statusCode = BackendComm.moveRobot("jason", Direction.EAST);
            if (statusCode == 200) {
                lb.setText("Result: SUCCESS Move East");
            } else {
                lb.setText("Result: FAILURE Move East");
            }
        });
        Button west = new Button("Move West");
        west.setPrefHeight(20);
        west.setLayoutX(10);
        west.setLayoutY(350);        
        west.setAlignment(Pos.CENTER);
        west.setOnAction((e) -> {
            int statusCode = BackendComm.moveRobot("jason", Direction.WEST);
            if (statusCode == 200) {
                lb.setText("Result: SUCCESS Move West");
            } else {
                lb.setText("Result: FAILURE Move West");
            }
        });

        pane.getChildren().addAll(north, west, east, south, lb);

        Scene scene = new Scene(pane, 600, 400);
        stage.setScene(scene);
        stage.setTitle("First Game");
        stage.show();
    }

    private void moveRob(Stage stage)
    {
        var lb = new Label("Result: ");
        Button bt = new Button("Move jason to east");
        bt.setOnAction((e) -> {
            int statusCode = BackendComm.moveRobot("jason", Direction.NORTH);
            if (statusCode == 200) {
                lb.setText("Result: SUCCESS");
            } else {
                lb.setText("Result: FAILURE");
            }
        });
        
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}