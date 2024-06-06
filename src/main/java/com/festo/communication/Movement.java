package com.festo.communication;

public class Movement {

    private String robot;

    public void setnameRobot(String robot) {
        this.robot = robot;
    }

    public int moveRobot(String robot, int direction) {
        return BackendComm.moveRobot(robot, direction);
    }
}
