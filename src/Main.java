import java.lang.Thread;

class MyThread implements Runnable {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " running");
        System.out.println("Priority: " + Thread.currentThread().getPriority());
    }
 }

public class Main {

    public static void main(String[] args) {
        Thread newThread = new Thread(new MyThread(), "Child Thread");
        newThread.setPriority(8);
        newThread.start();
    }
    
}
