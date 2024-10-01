import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = LoggerManager.getLogger();
    private static final ScheduleManager manager = ScheduleManager.getInstance();

    public static void main(String[] args) {
        manager.addObserver(new UserNotification());
        try (Scanner scanner = new Scanner(System.in)) {
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
                
                processCommand(command, scanner);
            }
        }
    }

    private static void processCommand(String command, Scanner scanner) {
        try {
            switch (command.toLowerCase()) {
                case "add" -> addTask(scanner);
                case "remove" -> removeTask(scanner);
                case "view" -> manager.viewTasks();
                case "edit" -> editTask(scanner);
                case "mark" -> markTask(scanner);
                case "view priority" -> viewByPriority(scanner);
                case "view logs" -> viewLogs();
                case "help" -> displayHelp();
                default -> System.out.println("Unknown command. Type 'help' to see the list of commands.");
            }
        } catch (InvalidTimeException e) {
            logger.log(Level.SEVERE, "An error occurred while processing command '{0}': {1}", new Object[]{command, e.getMessage()});
            System.out.println("An error occurred: " + e.getMessage());
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
            logger.log(Level.WARNING, "Invalid priority level entered: {0}", priorityStr);
        }
    }

    private static void viewLogs() {
        List<String> logLines = LoggerManager.getInMemoryLogs();
        if (logLines.isEmpty()) {
            System.out.println("No logs available for this session.");
        } else {
            System.out.println("Session Logs:");
            for (String line : logLines) {
                System.out.println(line);
            }
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
        System.out.println("view logs       - View application logs");
        System.out.println("help            - Display this help message");
        System.out.println("exit            - Exit the application");
    }
}
