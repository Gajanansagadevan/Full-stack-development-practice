class Employee {
     // Fields
    protected String name;
    protected int id;

    // Constructor
    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Method to display employee information
    public void displayInfo() {
        System.out.println("Employee ID   : " + id);
        System.out.println("Employee Name : " + name);
    }
}

// Child Class - FullTimeEmployee
class FullTimeEmployee extends Employee {

    // Field
    private double monthlySalary;

    // Constructor
    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    // Method to calculate salary
    public double calculateSalary() {
        return monthlySalary;
    }
}

// Child Class - PartTimeEmployee
class PartTimeEmployee extends Employee {

    // Fields
    private int hoursWorked;
    private double hourlyRate;

    // Constructor
    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    // Method to calculate salary
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
}

// Main Class
public class EmployeeDemo{

    public static void main(String[] args) {

        // Full-Time Employee Object
        FullTimeEmployee fullTime = new FullTimeEmployee(
                "Gajanan Sagadevan",
                101,
                80000);

        // Part-Time Employee Object
        PartTimeEmployee partTime = new PartTimeEmployee(
                "Kasun Perera",
                102,
                120,
                500);

        // Display Full-Time Employee Details
        System.out.println("===== Full-Time Employee =====");
        fullTime.displayInfo();
        System.out.println("Monthly Salary : ₹" + fullTime.calculateSalary());

        System.out.println();

        // Display Part-Time Employee Details
        System.out.println("===== Part-Time Employee =====");
        partTime.displayInfo();
        System.out.println("Hours Worked   : 120");
        System.out.println("Hourly Rate    : ₹500");
        System.out.println("Total Salary   : ₹" + partTime.calculateSalary());
    }
}
