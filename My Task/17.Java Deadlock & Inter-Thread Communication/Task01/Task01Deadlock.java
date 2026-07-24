class Printer {
}

class Scanner {
}

class User1 extends Thread {
    private Printer printer;
    private Scanner scanner;

    public User1(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    public void run() {
        synchronized (printer) {
            System.out.println("User1 locked Printer");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }

            synchronized (scanner) {
                System.out.println("User1 locked Scanner");
            }
        }
    }
}

class User2 extends Thread {
    private Printer printer;
    private Scanner scanner;

    public User2(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    public void run() {
        synchronized (scanner) {
            System.out.println("User2 locked Scanner");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }

            synchronized (printer) {
                System.out.println("User2 locked Printer");
            }
        }
    }
}

public class Task01Deadlock {
    public static void main(String[] args) {

        Printer printer = new Printer();
        Scanner scanner = new Scanner();

        new User1(printer, scanner).start();
        new User2(printer, scanner).start();
    }
}


