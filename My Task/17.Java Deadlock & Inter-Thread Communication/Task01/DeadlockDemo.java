
// DeadlockDemo.java
class Printer {
    public synchronized void print(String user) {
        System.out.println(user + " is using the Printer.");
    }
}

class Scanner {
    public synchronized void scan(String user) {
        System.out.println(user + " is using the Scanner.");
    }
}

class User1 extends Thread {
    private Printer printer;
    private Scanner scanner;

    User1(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    public void run() {
        synchronized (printer) {
            System.out.println("User1: locked Printer, waiting for Scanner...");
            try { Thread.sleep(100); } catch (InterruptedException e) {}

            synchronized (scanner) {
                System.out.println("User1: acquired both Printer and Scanner.");
            }
        }
    }
}

class User2 extends Thread {
    private Printer printer;
    private Scanner scanner;

    User2(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    public void run() {
        synchronized (scanner) {
            System.out.println("User2: locked Scanner, waiting for Printer...");
            try { Thread.sleep(100); } catch (InterruptedException e) {}

            synchronized (printer) {
                System.out.println("User2: acquired both Scanner and Printer.");
            }
        }
    }
}

public class DeadlockDemo {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Scanner scanner = new Scanner();

        User1 u1 = new User1(printer, scanner);
        User2 u2 = new User2(printer, scanner);

        u1.start();
        u2.start();
    }
}