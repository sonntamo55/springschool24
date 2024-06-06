package com.festo;

import com.festo.communication.BackendComm;
import com.festo.communication.Direction;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
        var lb = new Label("Result: ");
        Button bt_e = new Button("Move john to east");
        bt_e.setOnAction((e) -> {
            int statusCode = BackendComm.moveRobot("john", Direction.EAST);
            if (statusCode == 200) {
                lb.setText("Result: SUCCESS");
            } else {
                lb.setText("Result: FAILURE");
            }
        });
        Button bt_w = new Button("Move john to west");
        bt_w.setOnAction((e) -> {
            int statusCode = BackendComm.moveRobot("john", Direction.WEST);
            if (statusCode == 200) {
                lb.setText("Result: SUCCESS");
            } else {
                lb.setText("Result: FAILURE");
            }
        });
        Button bt_n = new Button("Move john to north");
        bt_n.setOnAction((e) -> {
            int statusCode = BackendComm.moveRobot("john", Direction.NORTH);
            if (statusCode == 200) {
                lb.setText("Result: SUCCESS");
            } else {
                lb.setText("Result: FAILURE");
            }
        });
        Button bt_s = new Button("Move john to south");
        bt_s.setOnAction((e) -> {
            int statusCode = BackendComm.moveRobot("john", Direction.SOUTH);
            if (statusCode == 200) {
                lb.setText("Result: SUCCESS");
            } else {
                lb.setText("Result: FAILURE");
            }
        });
        VBox vb = new VBox();
        vb.setPadding(new Insets(10, 10, 10, 10));
        vb.setSpacing(10);
        vb.getChildren().addAll(bt_n, bt_w, bt_e, bt_s, lb);
        var scene = new Scene(vb, 640, 480);

        
        stage.setScene(scene);
        
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}