// Abstract Class
abstract class LibraryItem {

    // Abstract method
    abstract void displayInfo();
}

// Interface
interface Borrowable {

    void borrowItem();

    void returnItem();
}

// Base Class (Inheritance)
class Person {

    protected String name;
    protected int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Display person details
    public void displayPerson() {
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
    }
}

// Student Class
class Student extends Person implements Borrowable {

    private int studentId;

    public Student(String name, int age, int studentId) {
        super(name, age);
        this.studentId = studentId;
    }

    public void displayStudent() {
        System.out.println("Student Details");
        displayPerson();
        System.out.println("Student ID : " + studentId);
    }

    @Override
    public void borrowItem() {
        System.out.println("Student borrowed a book.");
    }

    @Override
    public void returnItem() {
        System.out.println("Student returned a book.");
    }
}

// Librarian Class
class Librarian extends Person {

    private int employeeId;

    public Librarian(String name, int age, int employeeId) {
        super(name, age);
        this.employeeId = employeeId;
    }

    public void displayLibrarian() {
        System.out.println("Librarian Details");
        displayPerson();
        System.out.println("Employee ID : " + employeeId);
    }
}

// Book Class
class Book extends LibraryItem implements Borrowable {

    // Encapsulation
    private int bookId;
    private String title;
    private String author;
    private double price;

    // Getters
    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    // Setters
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Abstraction
    @Override
    public void displayInfo() {
        System.out.println("Book ID : " + bookId);
        System.out.println("Title   : " + title);
        System.out.println("Author  : " + author);
        System.out.println("Price   : $" + price);
    }

    // Interface methods
    @Override
    public void borrowItem() {
        System.out.println("Book has been borrowed.");
    }

    @Override
    public void returnItem() {
        System.out.println("Book has been returned.");
    }
}

// Main Class
public class LibraryManagementSystem {

    public static void main(String[] args) {

        // ------------------------------
        // Encapsulation
        // ------------------------------
        Book book = new Book();

        book.setBookId(101);
        book.setTitle("Java Programming");
        book.setAuthor("James Gosling");
        book.setPrice(4500.00);

        System.out.println("===== Book Details =====");
        System.out.println("Book ID : " + book.getBookId());
        System.out.println("Title   : " + book.getTitle());
        System.out.println("Author  : " + book.getAuthor());
        System.out.println("Price   : $" + book.getPrice());

        // ------------------------------
        // Inheritance
        // ------------------------------
        Student student = new Student("John", 21, 1001);

        Librarian librarian = new Librarian("David", 40, 5001);

        System.out.println("\n===== Student Information =====");
        student.displayStudent();

        System.out.println("\n===== Librarian Information =====");
        librarian.displayLibrarian();

        // ------------------------------
        // Abstraction
        // ------------------------------
        System.out.println("\n===== Book Information (Abstraction) =====");
        book.displayInfo();

        // ------------------------------
        // Polymorphism
        // ------------------------------
        System.out.println("\n===== Runtime Polymorphism =====");
        LibraryItem item = new Book();

        ((Book) item).setBookId(202);
        ((Book) item).setTitle("Object-Oriented Programming");
        ((Book) item).setAuthor("Bjarne Stroustrup");
        ((Book) item).setPrice(5200.00);

        item.displayInfo();

        // ------------------------------
        // Interface Demonstration
        // ------------------------------
        System.out.println("\n===== Borrowable Interface =====");
        student.borrowItem();
        student.returnItem();

        System.out.println();

        book.borrowItem();
        book.returnItem();
    }
}