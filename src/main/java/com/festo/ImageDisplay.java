package com.festo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ImageDisplay {

    static ImageView robot;

    public static void createImage(Pane pane) {
        // Laden des Bildes aus einer Datei oder einer URL
        Image image = new Image("file:C:\\Users\\frrei\\iCloudDrive\\Reskilling\\Vorlesungen\\OOS_2\\sshack\\springschool24\\src\\main\\resources\\com\\festo\\labyrinth-simple.png");
        Image image2 = new Image("file:C:\\Users\\frrei\\iCloudDrive\\Reskilling\\Vorlesungen\\OOS_2\\sshack\\springschool24\\src\\main\\resources\\com\\festo\\robo.png");


        // Erstellen eines ImageView und Setzen des Bildes darauf
        ImageView imageView = new ImageView(image);

        // Erstellen eines ImageView und Setzen des Bildes darauf
        robot = new ImageView(image2);
        robot.setFitWidth(64);
        ImageDisplay.robot.setPreserveRatio(true);

        // Optionale Anpassungen am ImageView, z.B. Größe oder Skalierung
        imageView.setFitWidth(560);
        imageView.setLayoutX(0);
        imageView.setLayoutY(0);
        imageView.setPreserveRatio(true);
        pane.getChildren().add(imageView);
      
        pane.getChildren().add(robot);


    }
}
