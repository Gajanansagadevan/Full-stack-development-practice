class Report {

    public synchronized void writeResult(String student, int marks) {

        System.out.println(student + " Marks : " + marks);

    }
}

class StudentThread extends Thread {

    Report report;
    String student;
    int marks;

    public StudentThread(Report report, String student, int marks) {

        this.report = report;
        this.student = student;
        this.marks = marks;
    }

    public void run() {

        report.writeResult(student, marks);

    }
}

public class Task03 {

    public static void main(String[] args) throws InterruptedException {

        Report report = new Report();

        StudentThread s1 =
                new StudentThread(report, "Kamal", 85);

        StudentThread s2 =
                new StudentThread(report, "Ravi", 90);

        StudentThread s3 =
                new StudentThread(report, "Anu", 95);

        s1.start();
        s2.start();
        s3.start();

        while (s1.isAlive() || s2.isAlive() || s3.isAlive()) {

        }

        System.out.println("All student results generated.");
    }
}