class Printer {

    public synchronized void printDocument(String employeeName) {

        System.out.println(employeeName + " is printing...");

        try {

            Thread.sleep(1000);

        } catch (InterruptedException e) {

            System.out.println(e.getMessage());

        }

        System.out.println(employeeName + " completed printing.");

    }
}

class Employee extends Thread {

    Printer printer;

    public Employee(Printer printer, String name) {

        this.printer = printer;

        setName(name);

    }

    public void run() {

        printer.printDocument(getName());

    }
}

public class Task04 {

    public static void main(String[] args) throws InterruptedException {

        Printer printer = new Printer();

        Employee e1 =
                new Employee(printer, "Employee 1");

        Employee e2 =
                new Employee(printer, "Employee 2");

        Employee e3 =
                new Employee(printer, "Employee 3");

        e1.setPriority(Thread.MAX_PRIORITY);

        e1.start();
        e2.start();
        e3.start();

        e1.join();
        e2.join();
        e3.join();

        System.out.println("All print jobs completed.");

    }
}