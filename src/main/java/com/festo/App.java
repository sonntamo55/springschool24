package com.festo;

import com.festo.communication.BackendComm;
import com.festo.communication.Direction;
import com.festo.communication.Movement;

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

    Movement warehouse = new Movement();
    warehouse.setnameRobot(robot);



}