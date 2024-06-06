package com.festo.communication;

public class Movement {

    private String robot;

    public void setnameRobot(String robot) {
        this.robot = robot;
    }

    public int moveRobot(BackendComm bc, int direction) {
        return bc.moveRobot(robot, direction);
    }
}
