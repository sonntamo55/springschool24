package com.festo;

import com.festo.communication.BackendComm;
import com.festo.communication.Direction;
import com.festo.communication.Robot;

import javafx.application.Application;
import javafx.geometry.Insets;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * JavaFX App
 */
public class App extends Application {


    @Override
    public void start(Stage stage) throws FileNotFoundException {
        Robot robot = new Robot();
        TextField tf = new TextField(robot.getname());
        var lb_2 = new Label("Enter robot name: ");
        var lb = new Label("Result: ");
        int aktPosX = -175;
        int aktPosY = -140;
        BackendComm.resetRobot(robot.getname());

        Image robotImage = new Image(new FileInputStream("src/main/resources/com/festo/robo.png"));
        ImageView robotImageView = new ImageView(robotImage);
        
        StackPane stackPane = new StackPane();
        stackPane.setPadding(new Insets(10));

        // Roboter-Bild positionieren
        robotImageView.setTranslateX(aktPosX); 
        robotImageView.setTranslateY(aktPosY);
        
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        Button bt_e = new Button("to east");
        GridPane.setConstraints(bt_e, 2, 1);
        bt_e.setOnAction((e) -> {
            int statusCode = BackendComm.moveRobot( robot.getname(), Direction.EAST);
            if (statusCode == 200) {
                lb.setText("Result: SUCCESS");
                robotImageView.setTranslateX(robotImageView.getTranslateX()+70);
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
                robotImageView.setTranslateX(robotImageView.getTranslateX()-70);
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
                robotImageView.setTranslateY(robotImageView.getTranslateY()-70);
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
                robotImageView.setTranslateY(robotImageView.getTranslateY()+70);
            } else {
                lb.setText("Result: FAILURE");
            }
        });
        Button bt_name = new Button("Set robot name");
        bt_name.setOnAction((e)-> {
            robot.setname(tf.getText());
        });
        //**********************************
        Button bt_reset = new Button("reset robot");
        bt_reset.setOnAction((e)-> {
            BackendComm.resetRobot(robot.getname());
            robotImageView.setTranslateX(-175); 
            robotImageView.setTranslateY(-140);
        });
        //**********************************
        
        Button bt_pick = new Button("Pick package");
        bt_pick.setOnAction((e)-> {
        if(!robot.get_robothasitem()) {
            int statusCode = BackendComm.pickItem(robot.getname());
            if (statusCode == 200) {
                lb.setText("Robot picked: ");
            } else {
                lb.setText("Robot could not pick item");
            }
            robot.pickitem();
        } else {
            lb.setText("Robot already has item");
        }
        });
        Button bt_drop = new Button("Place package");
        bt_drop.setOnAction((e)-> {
        if(robot.get_robothasitem()) {
            int statusCode = BackendComm.pickItem(robot.getname());
            if (statusCode == 200) {
                lb.setText("Robot placed: ");
            } else {
                lb.setText("Robot could not place item");
            }
            robot.placeitem();
            } else {
                lb.setText("Robot has no item");
            }
        });
        
        gridPane.getChildren().addAll(bt_e, bt_n, bt_s, bt_w);

        Image imageFild = new Image(new FileInputStream("src/main/resources/com/festo/labyrinth-simple.png"));
        ImageView fieldImageView = new ImageView(imageFild);

        stackPane.getChildren().addAll(fieldImageView, robotImageView);

        VBox vb = new VBox();
        vb.setPadding(new Insets(10, 10, 10, 10));
        vb.setSpacing(10);
        
        vb.getChildren().addAll(lb_2, tf, bt_name, bt_reset, bt_pick, bt_drop, gridPane, lb, stackPane);
        var scene = new Scene(vb, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
