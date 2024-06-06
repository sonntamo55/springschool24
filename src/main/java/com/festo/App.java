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

        // Reset the robot initially
        int resetStatus = backendcom.reset(robot);
        System.out.println("Initial reset status: " + resetStatus);

        while (true) {package com.festo;

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
            
                    // Reset the robot initially
                    int resetStatus = backendcom.reset(robot);
                    System.out.println("Initial reset status: " + resetStatus);
            
                    while (true) {
                        System.out.print("Enter direction (1=north, 2=east, 3=south, 4=west, 5=reset): ");
                        int direction = scanner.nextInt();
                        scanner.nextLine(); // consume the remaining newline
            
                        if (direction == 5) {
                            resetStatus = backendcom.reset(robot);
                            System.out.println("Reset status: " + resetStatus);
                        } else {
                            int moveStatus = warehouse.moveRobot(backendcom, direction);
                            System.out.println("Move status: " + moveStatus);
                        }
                    }
                }
            }
            
            System.out.print("Enter direction (1=north, 2=east, 3=south, 4=west, 5=reset): ");
            int direction = scanner.nextInt();
            scanner.nextLine(); // consume the remaining newline

            if (direction == 5) {
                resetStatus = backendcom.reset(robot);
                System.out.println("Reset status: " + resetStatus);
            } else {
                int moveStatus = warehouse.moveRobot(backendcom, direction);
                System.out.println("Move status: " + moveStatus);
            }
        }
    }
}
