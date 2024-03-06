import java.util.Scanner;

public class DroneStateMachine {
    enum State {
        DRONEPAD, STANDBY, PATH_PLANNING, FLIGHT, TRACKING, RETURNING_TO_BASE
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        State currentState = State.DRONEPAD;

        while (true) {
            System.out.println("Current state: " + currentState);
            switch (currentState) {
                case DRONEPAD:
                    System.out.println("Possible inputs: turnOn");
                    String input = scanner.nextLine();
                    switch (input) {
                        case "turnOn":
                            System.out.println("Drone is turning on.");
                            currentState = State.STANDBY;
                            break;
                        default:
                            System.out.println("Invalid input.");
                            break;
                    }
                    break;
                case STANDBY:
                    System.out.println("Possible inputs: generateRoute, turnOff");
                    input = scanner.nextLine();
                    switch (input) {
                        case "generateRoute":
                            System.out.println("Generating route.");
                            currentState = State.PATH_PLANNING;
                            break;
                        case "turnOff":
                            System.out.println("Turning off.");
                            return;
                        default:
                            System.out.println("Invalid input.");
                            break;
                    }
                    break;
                case PATH_PLANNING:
                    System.out.println("Possible inputs: abortPathPlanning, flyPath");
                    input = scanner.nextLine();
                    switch (input) {
                        case "abortPathPlanning":
                            System.out.println("Aborting path planning.");
                            currentState = State.STANDBY;
                            break;
                        case "flyPath":
                            System.out.println("Route generated, starting flight.");
                            currentState = State.FLIGHT;
                            break;
                        default:
                            System.out.println("Invalid input.");
                            break;
                    }
                    break;
                case FLIGHT:
                    System.out.println("Possible inputs: trackingPerson, returnToBase");
                    input = scanner.nextLine();
                    switch (input) {
                        case "trackingPerson":
                            System.out.println("Person found, starting tracking.");
                            currentState = State.TRACKING;
                            break;
                        case "returnToBase":
                            System.out.println("Emergency canceled, returning to base.");
                            currentState = State.RETURNING_TO_BASE;
                            break;
                        default:
                            System.out.println("Invalid input.");
                            break;
                    }
                    break;
                case TRACKING:
                    System.out.println("Possible inputs: searchMode, returnToBase");
                    input = scanner.nextLine();
                    switch (input) {
                        case "searchMode":
                            System.out.println("Person lost, switching to search mode.");
                            currentState = State.FLIGHT;
                            break;
                        case "returnToBase":
                            System.out.println("Victim found by responders, returning to base.");
                            currentState = State.RETURNING_TO_BASE;
                            break;
                        default:
                            System.out.println("Invalid input.");
                            break;
                    }
                    break;
                case RETURNING_TO_BASE:
                    System.out.println("Possible inputs: landing");
                    input = scanner.nextLine();
                    switch (input) {
                        case "landing":
                            System.out.println("Landing.");
                            currentState = State.STANDBY;
                            break;
                        default:
                            System.out.println("Invalid input.");
                            break;
                    }
                    break;

                default:
                    System.out.println("Invalid state.");
                    break;
            }
        }
    }
}
