import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

public class LoggerManager {
    private static final Logger logger = Logger.getLogger("AstronautSchedulerLogger");
    private static FileHandler fileHandler;
    private static SimpleFormatter formatter;
    private static List<String> inMemoryLogs = new ArrayList<>();

    static {
        try {
            fileHandler = new FileHandler("scheduler.log", true);
            formatter = new SimpleFormatter() {
                private static final String FORMAT = "[%1$tF %1$tT] [%2$-7s] %3$s %n";

                @Override
                public synchronized String format(LogRecord lr) {
                    return String.format(FORMAT,
                            new java.util.Date(lr.getMillis()),
                            lr.getLevel().getLocalizedName(),
                            lr.getMessage()
                    );
                }
            };
            fileHandler.setFormatter(formatter);
            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);
            logger.setUseParentHandlers(false);

            logger.addHandler(new Handler() {
                @Override
                public void publish(LogRecord record) {
                    String logEntry = formatter.format(record);
                    inMemoryLogs.add(logEntry);
                }

                @Override
                public void flush() {}

                @Override
                public void close() throws SecurityException {}
            });
        } catch (IOException e) {
            System.err.println("Failed to initialize logger handler.");
        }
    }

    public static Logger getLogger() {
        return logger;
    }

    public static List<String> getInMemoryLogs() {
        return inMemoryLogs;
    }
}
