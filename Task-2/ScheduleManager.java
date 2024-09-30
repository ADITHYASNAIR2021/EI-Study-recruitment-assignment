// File: ScheduleManager.java
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> tasks;
    private List<Observer> observers;

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
    } else {
        boolean canOverride = true;
        for (Task t : conflictingTasks) {
            if (newTask.getPriority().ordinal() >= t.getPriority().ordinal()) {
                // New task has higher or equal priority
                continue;
            } else {
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
            Scanner scanner = new Scanner(System.in);
            String response = scanner.nextLine().trim();

            if (response.equalsIgnoreCase("yes")) {
                // Remove conflicting tasks
                tasks.removeAll(conflictingTasks);
                tasks.add(newTask);
                System.out.println("Existing tasks overridden. New task added.");
            } else {
                System.out.println("Task not added.");
            }
        } else {
            // New task has lower priority
            System.out.println("Error: Task conflicts with higher-priority existing tasks.");
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
        } else {
            System.out.println("Error: Task not found.");
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
                return;
            }
        }
        System.out.println("Error: Task not found.");
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
