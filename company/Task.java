package com.company;

import com.company.Controller;

import java.util.TimerTask;

public class Task extends TimerTask {
    public void run() {
        Controller.BackUp();
    }
}