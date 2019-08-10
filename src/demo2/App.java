package demo2;

/*
 * 1. This is a sample class which demonstrate Thread creation by implementing Runnable interface
 * 2. Implementing run method of Runnable interface
 * 3. In the main creating Thread instance and calling arg constructor and passing the newly
 *      created class (which is implementing Runnable) inside it
 * 3. Running start method from the main -->This will create a new thread
 *
 * */
class Runner implements Runnable {

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            System.out.println("Hello " + i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

public class App {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runner());
        Thread t2 = new Thread(new Runner());

        t1.start();

        t2.start();
    }
}
