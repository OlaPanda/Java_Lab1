package com.company;

import java.io.*;

public class BackUp extends Thread {

    private static String pathname;
    private static Universiteis universiteis;

    public BackUp(String pathname, Universiteis universiteis){
        this.pathname = pathname;
        this.universiteis = universiteis;
    }

    @Override
    public void run(){
        try {
            BackUp();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void BackUp() throws IOException {
        Realization realization = new Realization(pathname);
        realization.New(universiteis);
    }
}