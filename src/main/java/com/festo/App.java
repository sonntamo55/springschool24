package com.festo;

import com.festo.communication.BackendComm;
import com.festo.communication.Movement;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Scanner;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        // GUI is not implemented, so we leave this empty
    }

    public static void main(String[] args) {
        String robot = "gilbert";

        Movement warehouse = new Movement();
        warehouse.setnameRobot(robot);
        BackendComm backendcom = new BackendComm();

        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.print("Enter command (reset/move/getinfo/exit): ");
            command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "reset":
                    int resetStatus = backendcom.reset(robot);
                    System.out.println("Reset status: " + resetStatus);
                    break;
                case "move":
                    System.out.print("Enter direction (1=north, 2=east, 3=south, 4=west): ");
                    int direction = scanner.nextInt();
                    scanner.nextLine(); // consume the remaining newline
                    int moveStatus = warehouse.moveRobot(backendcom, direction);
                    System.out.println("Move status: " + moveStatus);
                    break;
                case "getinfo":
                    int infoStatus = backendcom.getInfo(robot);
                    System.out.println("Info status: " + infoStatus);
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Unknown command. Please try again.");
                    break;
            }
        }
    }
}
