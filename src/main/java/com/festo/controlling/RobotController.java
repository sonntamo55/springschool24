package com.festo.controlling;

import com.festo.communication.BackendComm;
import com.festo.communication.Direction;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class RobotController {
    private ImageView robotView;
    private Label resultLabel;
    //private Direction d1;

    public RobotController(ImageView robotView, Label resultLabel) {
        this.robotView = robotView;
        this.resultLabel = resultLabel;
    }

    public void initializeRobot(Button initButton) {
        initButton.setOnAction(e -> {
            int statusCode = BackendComm.resetRobot("jason");
            if (statusCode == 200) {
                resultLabel.setText("Result: SUCCESS Robot initialized");
                robotView.setLayoutX(Constants.INIT);
                robotView.setLayoutY(Constants.INIT);
            } else {
                resultLabel.setText("Result: FAILURE Robot lost");
            }
        });
    }

    public void moveRobot(Button button, Direction direction) {
        button.setOnAction(e -> {
            int statusCode = BackendComm.moveRobot("jason", direction);
            if (statusCode == 200) {
                resultLabel.setText("Result: SUCCESS Move " + direction);
                switch (direction) {
                    case NORTH : robotView.setLayoutY(robotView.getLayoutY() - Constants.SWPOS); break;
                    case SOUTH : robotView.setLayoutY(robotView.getLayoutY() + Constants.SWPOS); break;
                    case EAST : robotView.setLayoutX(robotView.getLayoutX() + Constants.SWPOS); break;
                    case WEST : robotView.setLayoutX(robotView.getLayoutX() - Constants.SWPOS); break;
                }
            } else {
                resultLabel.setText("Result: FAILURE Move " + direction);
            }
        });
    }
}

