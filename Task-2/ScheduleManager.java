import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ScheduleManager {
    private static ScheduleManager instance;
    private final List<Task> tasks;
    private final List<Observer> observers;
    private static final Logger logger = LoggerManager.getLogger();

    private ScheduleManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static synchronized ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void addTask(Task newTask) {
        List<Task> conflictingTasks = new ArrayList<>();

        // Identify conflicting tasks
        for (Task t : tasks) {
            if (tasksOverlap(newTask, t)) {
                conflictingTasks.add(t);
            }
        }

        if (conflictingTasks.isEmpty()) {
            tasks.add(newTask);
            System.out.println("Task added successfully. No conflicts.");
            logger.log(Level.INFO, "Task '{0}' added successfully.", newTask.getDescription());
        } else {
            boolean canOverride = true;
            for (Task t : conflictingTasks) {
                if (newTask.getPriority().ordinal() <= t.getPriority().ordinal()) {
                    // New task has lower or equal priority
                    canOverride = false;
                    break;
                }
            }

            if (canOverride) {
                // Prompt user to override
                System.out.println("The new task conflicts with existing tasks:");
                for (Task t : conflictingTasks) {
                    System.out.println("- " + t);
                }
                System.out.print("Do you want to override these tasks? (yes/no): ");
                try (Scanner scanner = new Scanner(System.in)) {
                    String response = scanner.nextLine().trim();

                    if (response.equalsIgnoreCase("yes")) {
                        // Remove conflicting tasks
                        tasks.removeAll(conflictingTasks);
                        tasks.add(newTask);
                        System.out.println("Existing tasks overridden. New task added.");
                        logger.log(Level.INFO, "Task '{0}' added, overriding existing tasks.", newTask.getDescription());
                    } else {
                        System.out.println("Task not added.");
                        logger.log(Level.INFO, "Task '{0}' not added by user choice.", newTask.getDescription());
                    }
                }
            } else {
                // New task has lower or equal priority
                String conflictMessage = "Error: Task conflicts with existing tasks of equal or higher priority.";
                notifyObservers(conflictMessage);
                logger.log(Level.WARNING, "Failed to add task '{0}': {1}", new Object[]{newTask.getDescription(), conflictMessage});
            }
        }
    }

    public void removeTask(String description) {
        Task taskToRemove = null;
        for (Task t : tasks) {
            if (t.getDescription().equalsIgnoreCase(description)) {
                taskToRemove = t;
                break;
            }
        }
        if (taskToRemove != null) {
            tasks.remove(taskToRemove);
            System.out.println("Task removed successfully.");
            logger.log(Level.INFO, "Task '{0}' removed successfully.", description);
        } else {
            System.out.println("Error: Task not found.");
            logger.log(Level.WARNING, "Failed to remove task '{0}': Task not found.", description);
        }
    }

    public void editTask(String oldDescription, Task newTask) {
        removeTask(oldDescription);
        addTask(newTask);
    }

    public void markTaskAsCompleted(String description) {
        for (Task t : tasks) {
            if (t.getDescription().equalsIgnoreCase(description)) {
                t.setCompleted(true);
                System.out.println("Task marked as completed.");
                logger.log(Level.INFO, "Task '{0}' marked as completed.", description);
                return;
            }
        }
        System.out.println("Error: Task not found.");
        logger.log(Level.WARNING, "Failed to mark task '{0}' as completed: Task not found.", description);
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
            return;
        }
        tasks.sort((t1, t2) -> t1.getStartTime().compareTo(t2.getStartTime()));
        for (Task t : tasks) {
            System.out.println(t);
        }
    }

    public void viewTasksByPriority(PriorityLevel priority) {
        List<Task> filteredTasks = tasks.stream()
                .filter(t -> t.getPriority() == priority)
                .sorted((t1, t2) -> t1.getStartTime().compareTo(t2.getStartTime()))
                .collect(Collectors.toList());

        if (filteredTasks.isEmpty()) {
            System.out.println("No tasks with priority " + priority);
            return;
        }

        for (Task t : filteredTasks) {
            System.out.println(t);
        }
    }

    private boolean tasksOverlap(Task t1, Task t2) {
        return t1.getStartTime().isBefore(t2.getEndTime()) && t1.getEndTime().isAfter(t2.getStartTime());
    }
}
