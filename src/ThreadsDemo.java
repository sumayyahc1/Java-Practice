import java.lang.Thread;

class ChildThread implements Runnable {

    String str1, str2;
    Thread t;

    public ChildThread(String name, String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
        this.t = new Thread(this, name);
        t.start();
    }

    public void run() {
        System.out.println(t.getName() + " running");
        str1 = str1.concat(str2);
        System.out.println(str1);
    }
}

public class ThreadsDemo {
    public static void main (String [] args) {
        String s1 = "hello";
        String s2 = "world";
        ChildThread newThread = new ChildThread("Child Thread", s1, s2);
        System.out.println("Main thread");
        System.out.println(s1.toUpperCase());
    }
}
