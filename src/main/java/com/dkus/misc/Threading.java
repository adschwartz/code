package com.dkus.misc;

/**
 * @author anders.schwartz
 */
public class Threading {

    public static void main(String[] args) {
        // Lambda Runnable
        Runnable task2 = () -> {
            try {
                System.out.println("Task #2 is running");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // start the thread
        Thread thread = new Thread(task2);
        try {
            thread.start();
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
