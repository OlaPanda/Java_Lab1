package com.company;

import java.util.Date;
import java.util.Timer;
import com.company.Task;
public class ClassExecutingTask {

    private Task task = new Task();
    private Timer timer = new Timer("BackUp");

    public void start() {
        timer.cancel();
        timer = new Timer("BackUp");
        Date executionDate = new Date();
        long delay = 60 * 1000; // Время в секундах
        timer.scheduleAtFixedRate(task, executionDate, delay);
    }
}