package demo;
/*
* 1. This is a sample class which demonstrate Thread creation by extending Thread class
* 2. Overriding run method of Thread class
* 3. Running start method from the main -->This will create a new thread
*
* */
class Runner extends Thread {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello " + i);

            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class App {
    public static void main(String[] args) {
        Runner runner1 = new Runner();
        runner1.start();

        Runner runner2 = new Runner();
        runner2.start();
    }
}
