// DeadlockFreeDemo.java

class Printer {
    private boolean busy = false;

    public synchronized void acquire(String user) throws InterruptedException {
        while (busy) {
            System.out.println(user + " waiting for Printer...");
            wait();
        }
        busy = true;
        System.out.println(user + " acquired the Printer.");
    }

    public synchronized void release(String user) {
        busy = false;
        System.out.println(user + " released the Printer.");
        notifyAll();
    }
}

class Scanner {
    private boolean busy = false;

    public synchronized void acquire(String user) throws InterruptedException {
        while (busy) {
            System.out.println(user + " waiting for Scanner...");
            wait();
        }
        busy = true;
        System.out.println(user + " acquired the Scanner.");
    }

    public synchronized void release(String user) {
        busy = false;
        System.out.println(user + " released the Scanner.");
        notifyAll();
    }
}

class User extends Thread {
    private String name;
    private Printer printer;
    private Scanner scanner;

    User(String name, Printer printer, Scanner scanner) {
        this.name = name;
        this.printer = printer;
        this.scanner = scanner;
    }

    public void run() {
        try {
            // FIX: Every thread acquires resources in the SAME order:
            // Printer first, then Scanner. This breaks circular wait.
            printer.acquire(name);
            Thread.sleep(50); // simulate some work / interleaving

            scanner.acquire(name);

            System.out.println(name + " is printing and scanning...");
            Thread.sleep(200); // simulate using both resources

            scanner.release(name);
            printer.release(name);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class DeadlockFreeDemo {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Scanner scanner = new Scanner();

        User user1 = new User("User1", printer, scanner);
        User user2 = new User("User2", printer, scanner);

        user1.start();
        user2.start();
    }
}