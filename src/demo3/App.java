package demo3;

/*
 * 1. This is a sample class which demonstrate Thread creation by using anonymous inner class
 * 2. Implementing run method of Runnable interface inside that anonymous class
 * 3. Running start method from the main -->This will create a new thread
 *
 * */
public class App {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
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
        });

        t1.start();
    }
}
