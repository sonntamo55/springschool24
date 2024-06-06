package com.festo;


public class MoveRobot {

public static void movexy(double xr, double yr){
    

    ImageDisplay.robot.setLayoutX(xr);
    ImageDisplay.robot.setLayoutY(yr);
   
}
}
