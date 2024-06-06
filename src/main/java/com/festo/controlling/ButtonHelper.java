package com.festo.controlling;

import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class ButtonHelper {
    public static void setButtonProperties(double height, double layoutX, double layoutY, Button button) {
        button.setPrefHeight(height);
        button.setLayoutX(layoutX);
        button.setLayoutY(layoutY);
        button.setAlignment(Pos.CENTER);
    }
}

