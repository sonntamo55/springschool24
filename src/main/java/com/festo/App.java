package com.festo;

import com.festo.communication.BackendComm;
import com.festo.communication.Direction;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    
    
    @Override
    public void start(Stage stage) {

        BackendComm.resetRobot("jessica");

        var lb = new Label("Result: ");
        
        Button btEast = new Button("Move jessica to east");
        btEast.setOnAction((e) -> {
            int statusCode = BackendComm.moveRobot("jessica", Direction.EAST);
            if (statusCode == 200) {
                lb.setText("Result: SUCCESS");
                MoveRobot.movexy(ImageDisplay.robot.getLayoutX()+70, ImageDisplay.robot.getLayoutY());
            } else {
                lb.setText("Result: FAILURE");
            }
        });
        
        Button btWest = new Button("Move jessica to west");
        btWest.setOnAction((e) -> {
            int statusCode = BackendComm.moveRobot("jessica", Direction.WEST);
            if (statusCode == 200) {
                lb.setText("Result: SUCCESS");
                MoveRobot.movexy(ImageDisplay.robot.getLayoutX()-70, ImageDisplay.robot.getLayoutY());
            } else {
                lb.setText("Result: FAILURE");
            }
        });
        
        Button btNorth = new Button("Move jessica to north");
        btNorth.setOnAction((e) -> {
            int statusCode = BackendComm.moveRobot("jessica", Direction.NORTH);
            if (statusCode == 200) {
                lb.setText("Result: SUCCESS");
                MoveRobot.movexy(ImageDisplay.robot.getLayoutX(), ImageDisplay.robot.getLayoutY()-70);
            } else {
                lb.setText("Result: FAILURE");
            }
        });
        
        Button btSouth = new Button("Move jessica to south");
        btSouth.setOnAction((e) -> {
            int statusCode = BackendComm.moveRobot("jessica", Direction.SOUTH);
            if (statusCode == 200) {
                lb.setText("Result: SUCCESS");
                MoveRobot.movexy(ImageDisplay.robot.getLayoutX(), ImageDisplay.robot.getLayoutY()+70);
                
            } else {
                lb.setText("Result: FAILURE");
            }
        });

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        // Position the buttons
        grid.add(btNorth, 1, 0);
        grid.add(btWest, 0, 1);
        grid.add(btEast, 2, 1);
        grid.add(btSouth, 1, 2);
        grid.add(lb, 1, 3);

        Pane pane = new Pane();
        pane.getChildren().add(grid);
        grid.setLayoutX(0);
        grid.setLayoutY(500);
        ImageDisplay.createImage(pane);
        MoveRobot.movexy(75,75);
       
     

        var scene = new Scene(pane, 800, 800);
        stage.setScene(scene);
        stage.setTitle("Warehouse1");
      //  ImageView iv1 = new ImageView();
     //   iv1.setImage(image);

        stage.show();
    }

 //   @Override public void start(Stage stage) {
        // load the image
    //    Image image = new Image("flower.png");

        // simple displays ImageView the image as is
      
    public static void main(String[] args) {
        launch();
    }
}
