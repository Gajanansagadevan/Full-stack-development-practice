class ThreadManager {

    public synchronized void printDetails(String threadName) {
        System.out.println(threadName + " is running.");
    }
}

class MyThread extends Thread {

    ThreadManager manager;

    public MyThread(ThreadManager manager, String name) {
        this.manager = manager;
        setName(name);
    }

    public void run() {
        manager.printDetails(getName());
    }
}

public class Task01 {

    public static void main(String[] args) throws InterruptedException {

        ThreadManager manager = new ThreadManager();

        MyThread t1 = new MyThread(manager, "Thread 1");
        MyThread t2 = new MyThread(manager, "Thread 2");
        MyThread t3 = new MyThread(manager, "Thread 3");

        t1.start();
        t2.start();
        t3.start();

        System.out.println("Thread 1 Alive : " + t1.isAlive());

        t1.join();
        t2.join();
        t3.join();

        System.out.println("All threads completed.");
    }
}