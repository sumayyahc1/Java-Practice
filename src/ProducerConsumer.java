import java.lang.Thread;

class Q {
    int num;
    boolean valueSet = false;

    synchronized int get() {
        while (!valueSet) {
            try {
                this.wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Got " + num);
        valueSet = false;
        this.notify();
        return num;
    }

    synchronized void put(int num) {
        while (valueSet) {
            try {
                this.wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        this.num = num;
        valueSet = true;
        System.out.println("Put " + num);
        this.notify();
    }
}

class Producer implements Runnable {
    Q que;

    public Producer(Q que) {
        this.que = que;
        new Thread(this, "Producer").start();
    }

    public void run() {
        int n = 0;
        while(true) {
            que.put(n++);
        }
    }
}

class Consumer implements Runnable {
    Q que;

    public Consumer(Q que) {
        this.que = que;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        while(true) {
            que.get();
        }
    }
}

public class ProducerConsumer {
    public static void main (String[] args) {
        Q que = new Q();
        new Producer(que);
        new Consumer(que);
        System.out.println("Ctrl+C to stop.");
    }
    
}
