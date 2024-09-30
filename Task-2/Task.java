// File: Task.java
import java.time.LocalTime;

public class Task {
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private PriorityLevel priority;
    private boolean isCompleted;

    public Task(String description, LocalTime startTime, LocalTime endTime, PriorityLevel priority) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.priority = priority;
        this.isCompleted = false;
    }

    // Getters and setters
    public String getDescription() { return description; }
    public LocalTime getStartTime() { return startTime; }
    public LocalTime getEndTime() { return endTime; }
    public PriorityLevel getPriority() { return priority; }
    public boolean isCompleted() { return isCompleted; }

    public void setDescription(String description) { this.description = description; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }
    public void setPriority(PriorityLevel priority) { this.priority = priority; }
    public void setCompleted(boolean isCompleted) { this.isCompleted = isCompleted; }

    @Override
    public String toString() {
        return String.format("%s - %s: %s [%s]%s",
                startTime.toString(),
                endTime.toString(),
                description,
                priority,
                isCompleted ? " (Completed)" : "");
    }
}
