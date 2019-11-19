import java.util.Date;
import java.util.Timer;

public class ClassExecutingTask {
    long delay = 5 * 1000;
    LoopTask task = new LoopTask();
    Timer timer = new Timer("Backup");

    public void start() {
        timer.cancel();
        timer = new Timer("Backup");
        Date executionDate = new Date();
        timer.scheduleAtFixedRate(task, executionDate, delay);
    }
}