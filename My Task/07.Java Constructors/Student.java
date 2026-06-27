public class Student {

// Attributes
    private int studentId;
    private String studentName;
    private String course;

    // Default Constructor
    public Student() {
        studentId = 0;
        studentName = "Not Assigned";
        course = "Not Enrolled";
    }

    // Parameterized Constructor
    public Student(int studentId, String studentName, String course) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.course = course;
    }

    // Copy Constructor
    public Student(Student otherStudent) {
        this.studentId = otherStudent.studentId;
        this.studentName = otherStudent.studentName;
        this.course = otherStudent.course;
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("Student ID   : " + studentId);
        System.out.println("Student Name : " + studentName);
        System.out.println("Course       : " + course);
        System.out.println("--------------------------------");
    }

    // Main Method
    public static void main(String[] args) {

        // Object using Default Constructor
        Student student1 = new Student();

        // Object using Parameterized Constructor
        Student student2 = new Student(101, "Gajanan Sagadevan", "BSc (Hons) Software Engineering, Cyber Security");

        // Object using Copy Constructor
        Student student3 = new Student(student2);

        // Display Details
        System.out.println("Student 1 Details");
        student1.displayDetails();

        System.out.println("Student 2 Details");
        student2.displayDetails();

        System.out.println("Student 3 Details (Copied Object)");
        student3.displayDetails();
    }
}