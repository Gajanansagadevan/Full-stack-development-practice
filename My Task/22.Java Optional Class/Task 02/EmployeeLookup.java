import java.util.*;

class Employee {

    private int id;
    private String name;
    private double salary;


    public Employee(int id, String name, double salary) {

        this.id = id;
        this.name = name;
        this.salary = salary;

    }


    public int getId() {

        return id;

    }


    @Override
    public String toString() {

        return "ID: " + id +
                ", Name: " + name +
                ", Salary: " + salary;

    }

}


public class EmployeeLookup {


    public static Optional<Employee> findEmployee(int id) {


        List<Employee> employees = Arrays.asList(

                new Employee(101, "John", 50000),
                new Employee(102, "Alice", 70000),
                new Employee(103, "David", 90000)

        );


        return employees.stream()

                .filter(employee -> employee.getId() == id)

                .findFirst();

    }



    public static void main(String[] args) {


        Employee defaultEmployee =
                new Employee(0, "Default Employee", 0);



        Employee employee = findEmployee(105)

                .orElse(defaultEmployee);



        System.out.println("Employee Details:");

        System.out.println(employee);


    }

}