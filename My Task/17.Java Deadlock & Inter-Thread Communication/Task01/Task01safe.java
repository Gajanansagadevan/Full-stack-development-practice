class Resource {

    private boolean busy = false;
    private String name;

    public Resource(String name) {
        this.name = name;
    }

    public synchronized void acquire(String user) throws InterruptedException {

        while (busy) {
            System.out.println(user + " waiting for " + name);
            wait();
        }

        busy = true;
        System.out.println(user + " acquired " + name);
    }

    public synchronized void release(String user) {

        busy = false;
        System.out.println(user + " released " + name);
        notifyAll();
    }
}

class User extends Thread {

    private Resource printer;
    private Resource scanner;

    public User(String name, Resource printer, Resource scanner) {
        super(name);
        this.printer = printer;
        this.scanner = scanner;
    }

    public void run() {

        try {

            printer.acquire(getName());
            Thread.sleep(500);

            scanner.acquire(getName());
            Thread.sleep(500);

            scanner.release(getName());
            printer.release(getName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Task01safe {

    public static void main(String[] args) {

        Resource printer = new Resource("Printer");
        Resource scanner = new Resource("Scanner");

        new User("User1", printer, scanner).start();
        new User("User2", printer, scanner).start();
    }
}