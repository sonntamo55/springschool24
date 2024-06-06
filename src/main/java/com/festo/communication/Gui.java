package com.festo.communication;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class Gui {

    private Movement movement;
    private BackendComm backendComm;

    public Gui() {
        this.backendComm = new BackendComm();
                List[][] array = new List[3][3];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = new ArrayList<>();
            }
        }
        this.movement = new Movement(array);
        this.movement.setnameRobot("gilbert");
    }

    public void start(Stage stage) {
        var lb = new Label("Result: ");


        // Image laden
        Image image = new Image(getClass().getResourceAsStream("/com/festo/labyrinth-simple.png"));
        ImageView imageView = new ImageView(image);




        //Buttons
        Button bte = new Button("Move Gilbert to east");
        Button btw = new Button("Move Gilbert to west");
        Button btn = new Button("Move Gilbert to north");
        Button bts = new Button("Move Gilbert to south");

        bte.setOnAction((e) -> {
            int statusCode = movement.moveRobot("gilbert", 2);
            if (statusCode == 200) {
                lb.setText("Result: SUCCESS");
            } else {
                lb.setText("Result: FAILURE");
            }
        });

        btw.setOnAction((e) -> {
            int statusCode = movement.moveRobot("gilbert", 4);
            if (statusCode == 200) {
                lb.setText("Result: SUCCESS");
            } else {
                lb.setText("Result: FAILURE");
            }
        });

        btn.setOnAction((e) -> {
            int statusCode = movement.moveRobot("gilbert", 1);
            if (statusCode == 200) {
                lb.setText("Result: SUCCESS");
            } else {
                lb.setText("Result: FAILURE");
            }
        });

        bts.setOnAction((e) -> {
            int statusCode = movement.moveRobot("gilbert", 3);
            if (statusCode == 200) {
                lb.setText("Result: SUCCESS");
            } else {
                lb.setText("Result: FAILURE");
            }
        });



        VBox vb = new VBox();
        vb.setPadding(new Insets(10, 10, 10, 10));
        vb.setSpacing(10);
        vb.getChildren().addAll(bte, btw,  btn, bts, lb, imageView);
        var scene = new Scene(vb, 640, 480);
        stage.setScene(scene);
        stage.show();
    }
    
}



