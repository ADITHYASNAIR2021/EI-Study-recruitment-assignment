// File: Main.java
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final ScheduleManager manager = ScheduleManager.getInstance();

    public static void main(String[] args) {
        manager.addObserver(new UserNotification());
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Astronaut Daily Schedule Organizer");
        System.out.println("Type 'help' to see the list of commands.");

        while (true) {
            System.out.print("> ");
            command = scanner.nextLine().trim();

            if (command.equalsIgnoreCase("exit")) {
                System.out.println("Exiting application.");
                break;
            }

            try {
                processCommand(command, scanner);
            } catch (Exception e) {
                logger.log(Level.SEVERE, "An error occurred: ", e);
            }
        }

        scanner.close();
    }

    private static void processCommand(String command, Scanner scanner) throws InvalidTimeException {
        switch (command.toLowerCase()) {
            case "add":
                addTask(scanner);
                break;
            case "remove":
                removeTask(scanner);
                break;
            case "view":
                manager.viewTasks();
                break;
            case "edit":
                editTask(scanner);
                break;
            case "mark":
                markTask(scanner);
                break;
            case "view priority":
                viewByPriority(scanner);
                break;
            case "help":
                displayHelp();
                break;
            default:
                System.out.println("Unknown command. Type 'help' to see the list of commands.");
        }
    }

    private static void addTask(Scanner scanner) throws InvalidTimeException {
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter start time (HH:MM): ");
        String startTime = scanner.nextLine();
        System.out.print("Enter end time (HH:MM): ");
        String endTime = scanner.nextLine();
        System.out.print("Enter priority (High, Medium, Low): ");
        String priority = scanner.nextLine();

        Task task = TaskFactory.createTask(description, startTime, endTime, priority);
        manager.addTask(task);
    }

    private static void removeTask(Scanner scanner) {
        System.out.print("Enter task description to remove: ");
        String description = scanner.nextLine();
        manager.removeTask(description);
    }

    private static void editTask(Scanner scanner) throws InvalidTimeException {
        System.out.print("Enter description of the task to edit: ");
        String oldDescription = scanner.nextLine();

        System.out.println("Enter new details for the task.");
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter start time (HH:MM): ");
        String startTime = scanner.nextLine();
        System.out.print("Enter end time (HH:MM): ");
        String endTime = scanner.nextLine();
        System.out.print("Enter priority (High, Medium, Low): ");
        String priority = scanner.nextLine();

        Task newTask = TaskFactory.createTask(description, startTime, endTime, priority);
        manager.editTask(oldDescription, newTask);
    }

    private static void markTask(Scanner scanner) {
        System.out.print("Enter task description to mark as completed: ");
        String description = scanner.nextLine();
        manager.markTaskAsCompleted(description);
    }

    private static void viewByPriority(Scanner scanner) {
        System.out.print("Enter priority level to view (High, Medium, Low): ");
        String priorityStr = scanner.nextLine();

        try {
            PriorityLevel priority = PriorityLevel.valueOf(priorityStr.toUpperCase());
            manager.viewTasksByPriority(priority);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid priority level.");
        }
    }

    private static void displayHelp() {
        System.out.println("Available commands:");
        System.out.println("add             - Add a new task");
        System.out.println("remove          - Remove an existing task");
        System.out.println("view            - View all tasks");
        System.out.println("edit            - Edit an existing task");
        System.out.println("mark            - Mark a task as completed");
        System.out.println("view priority   - View tasks by priority");
        System.out.println("help            - Display this help message");
        System.out.println("exit            - Exit the application");
    }
}
