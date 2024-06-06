package com.festo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.festo.communication.BackendComm;
import com.festo.communication.Direction;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class App extends Application {
    static final Double SWPOS = 70.;
    static final Double INIT = 72.;

    @Override
    public void start(Stage stage) {
        
        //moveRobWeb(stage);
        moveRobImage(stage);
    }
    private void ButtonSide(double dHigh, double dsetX, double  dsetY, Button b1)
    {
        b1.setPrefHeight(dHigh);
        b1.setLayoutX(dsetX);
        b1.setLayoutY(dsetY);
        b1.setAlignment(Pos.CENTER);
    }
  
    private void moveRobImage(Stage stage)
    {
        ImageView iv = null;
        //ImageView bv = null;

        var lb = new Label("Result: ");
        Button north = new Button("Move North");
        Button south = new Button("Move South");
        Button west = new Button("Move West");
        Button east = new Button("Move East");
        Button init = new Button("Initialisieren");
        ButtonSide(20, 200, 300, north);
        ButtonSide(20, 10, 300, south);
        ButtonSide(20, 10, 350, west);
        ButtonSide(20, 200, 350, east);
        ButtonSide(20, 100, 400, init);

        try {
            FileInputStream inputstream = new FileInputStream("/home/user/lab/warehouse/springschool24/src/main/resources/com/festo/labyrinth-simple.png");
            FileInputStream robotinputstream = new FileInputStream("/home/user/lab/warehouse/springschool24/src/main/resources/com/festo/robo.png");
            Image image = new Image(inputstream);
            Image robot = new Image(robotinputstream);
            iv = new ImageView(image);
            ImageView bv = new ImageView(robot); 
            
            
            bv.setLayoutX(INIT);
            bv.setLayoutY(INIT);
            
            north.setOnAction((e) -> {
                int statusCode = BackendComm.moveRobot("jason", Direction.NORTH);
                if (statusCode == 200) {
                    lb.setText("Result: SUCCESS Move North");
                    bv.setLayoutY(bv.getLayoutY()- SWPOS);
                } else {
                    lb.setText("Result: FAILURE Move North");
                }
            
            });
            
            south.setOnAction((e) -> {
                int statusCode = BackendComm.moveRobot("jason", Direction.SOUTH);
                if (statusCode == 200) {
                    lb.setText("Result: SUCCESS Move South");
                    bv.setLayoutY(bv.getLayoutY() + SWPOS);
                } else {
                    lb.setText("Result: FAILURE Move South");
                }
            });
            east.setOnAction((e) -> {
                int statusCode = BackendComm.moveRobot("jason", Direction.EAST);
                if (statusCode == 200) {
                    lb.setText("Result: SUCCESS Move East");
                    bv.setLayoutX(bv.getLayoutX()+ SWPOS);
                } else {
                    lb.setText("Result: FAILURE Move East");
                }
            });
            west.setOnAction((e) -> {
                int statusCode = BackendComm.moveRobot("jason", Direction.WEST);
                if (statusCode == 200) {
                    lb.setText("Result: SUCCESS Move West");
                    bv.setLayoutX(bv.getLayoutX()- SWPOS);
                } else {
                    lb.setText("Result: FAILURE Move West");
                }
            });
            init.setOnAction((e) -> {
                int statusCode = BackendComm.resetRobot("jason");
                if (statusCode == 200) {
                    lb.setText("Result: SUCCESS Robot initialized");
                    bv.setLayoutX(INIT);
                    bv.setLayoutY(INIT);
                } else {
                    lb.setText("Result: FAILURE Robot lost");
                }

            });
            Pane pane = new Pane();
            pane.getChildren().addAll(iv, north, south, west, east, lb, init, bv);
       
            var scene = new Scene(pane, 640, 480);
            stage.setScene(scene);
            stage.show();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 


    }


    public static void main(String[] args) {
        launch();
    }

}