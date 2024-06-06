package com.festo.communication;

import java.util.List;

public class Movement {

    private String robot;
    private List[][] array;
    private int positionX = 0;
    private int positionY = 0;

    public Movement(List[][] array) {
        this.array = array;
    }

    public void setNameRobot(String robot) {
        this.robot = robot;
    }

    public int moveRobot(BackendComm bc, int direction) {
        int httpStatus = bc.moveRobot(robot, direction);
        if (httpStatus == 200) {// if movement worked go ahead
            switch (direction) {
                case 1: // Move north
                    if (positionY < array[0].length - 1) {
                        positionY++;
                    }
                    break;
                case 2: // Move east
                    if (positionX < array.length - 1) {
                        positionX++;
                    }
                    break;
                case 3: // Move south
                    if (positionY > 0) {
                        positionY--;
                    }
                    break;
                case 4: // Move west
                    if (positionX > 0) {
                        positionX--;
                    }
                    break;
                default:
                    System.out.println("Direction wrong...........restart!!!!");
                    break;
            }
        }
        return httpStatus;
    }

    public int getX() {
        return positionX;
    }

    public int getY() {
        return positionY;
    }
}
