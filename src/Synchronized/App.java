package Synchronized;

/**
 * t1.join()--> what join does is wait until the above thread execution is complete
 */
public class App {

    private int count = 0;


    public synchronized void increment() {
        count++;
    }

    public static void main(String[] args) {
        App app = new App();
        app.doWork();
    }

    public void doWork() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    //count++;
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    //count++;
                    increment();
                }
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
/**
 * t1.join()--> what join does is wait until the above thread execution is complete
 * so in above code we have started t1 and t2 threads, if we don't do t1.join and t2.join the execution
 * will go directly to below print statement and it will return 0 because count variable is increasing
 * and the treads are still executing
 *
 * when we do t1.join-->it waits for the tread t1 and once t1 executes completely then only it goes to next line
 * which is t2.join-->again it waits for thread t2 to complete
 *
 * and at the end it prints the count variable which is what we want here.
 *
 *
 *
 * Sample Output after some running is below
 *
 * "C:\Program Files\Java\jdk-9.0.4\bin\java.exe" "-javaagent:D:\IntelliJ\IntelliJ IDEA Community Edition 2019.1.3\lib\idea_rt.jar=56969:D:\IntelliJ\IntelliJ IDEA Community Edition 2019.1.3\bin" -Dfile.encoding=UTF-8 -classpath D:\IntelliJ\ThreadConcepts\out\production\ThreadConcepts Synchronized.App
 * count is: 18813
 *
 * Process finished with exit code 0
 *
 *
 * Here we didn't get 20000 as we expected because "count++" is not an atomic operation
 *
 * it involves
 * count=count+1
 * 1. get the count value
 * 2. increment the count value
 * 3. set the incremented count value to the count variable
 *
 * while above 3 statements run, the another thread gets into it and read the unincremented value and increment that
 * also we can also have twice increments for one iteration in each thread.
 *
 * That's because to threads are using the variable simultaneously
 *
 * SOLUTION
 *
 * use synchronized
 *
 * Explanation:
 * Every object in java have an intrinsic lock  (monitor lock MUTEX),
 * it you call synchronized method of an object, you have to acquire the intrinsic lock
 * and only one thread can acquire that lock at a time
 *
 * If one thread acquire the intrinsic lock another thread has to wait,
 * until the first thread releases the lock
 *
 *
 */


        System.out.println("count is: " + count);
    }
}
