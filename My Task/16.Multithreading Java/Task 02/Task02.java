class NumberPrinter {

    public synchronized void printNumber(int number) {

        System.out.println(number);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}

class OddThread extends Thread {

    NumberPrinter printer;

    public OddThread(NumberPrinter printer) {
        this.printer = printer;
    }

    public void run() {

        for (int i = 1; i <= 10; i += 2) {
            printer.printNumber(i);
        }
    }
}

class EvenThread extends Thread {

    NumberPrinter printer;

    public EvenThread(NumberPrinter printer) {
        this.printer = printer;
    }

    public void run() {

        for (int i = 2; i <= 10; i += 2) {
            printer.printNumber(i);
        }
    }
}

public class Task02 {

    public static void main(String[] args) {

        NumberPrinter printer = new NumberPrinter();

        OddThread odd = new OddThread(printer);
        EvenThread even = new EvenThread(printer);

        odd.start();
        even.start();
    }
}