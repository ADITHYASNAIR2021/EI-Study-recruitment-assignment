import java.time.LocalTime;
import java.time.format.DateTimeParseException;

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
        } catch (DateTimeParseException e) {
            throw new InvalidTimeException("Invalid time format. Please use HH:MM (24-hour format).");
        } catch (IllegalArgumentException e) {
            throw new InvalidTimeException("Invalid priority level. Please use High, Medium, or Low.");
        } catch (Exception e) {
            throw new InvalidTimeException("Invalid input: " + e.getMessage());
        }
    }
}
