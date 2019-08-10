package Volatile;

import java.util.Scanner;

/**
 * Volatile is used to prevent threads caching variables when they are not changed from within that thread
 * If you are changing the value of variable from a different thread you have to use volatile
 * or something else(thread synchronization)
 */
class Processor extends Thread {

    private volatile boolean running = true;

    public void run() {
        while (running) {
            System.out.println("Hello");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        running = false;
    }
}

public class App {
    public static void main(String[] args) {
        Processor proc1 = new Processor();
        proc1.start();

        System.out.println("press return to stop");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        proc1.shutdown();


    }
}
