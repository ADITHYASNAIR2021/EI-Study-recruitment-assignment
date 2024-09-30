// File: TaskFactory.java
import java.time.LocalTime;

public class TaskFactory {
    public static Task createTask(String description, String startTimeStr, String endTimeStr, String priorityStr) throws InvalidTimeException {
        try {
            LocalTime startTime = LocalTime.parse(startTimeStr);
            LocalTime endTime = LocalTime.parse(endTimeStr);
            PriorityLevel priority = PriorityLevel.valueOf(priorityStr.toUpperCase());

            if (startTime.isAfter(endTime) || startTime.equals(endTime)) {
                throw new InvalidTimeException("Start time must be before end time.");
            }

            return new Task(description, startTime, endTime, priority);
        } catch (Exception e) {
            throw new InvalidTimeException("Invalid input: " + e.getMessage());
        }
    }
}
