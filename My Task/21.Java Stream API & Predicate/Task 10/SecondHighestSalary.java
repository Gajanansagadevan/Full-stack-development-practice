import java.util.*;

public class SecondHighestSalary {

    public static void main(String[] args) {


        List<Employee> employees = Arrays.asList(

                new Employee(101, "John", 28, 55000, "IT"),
                new Employee(102, "Alice", 35, 75000, "HR"),
                new Employee(103, "David", 40, 95000, "IT"),
                new Employee(104, "Mark", 32, 85000, "Finance")

        );


        Double secondHighestSalary = employees.stream()

                .map(Employee::getSalary)

                .sorted(Comparator.reverseOrder())

                .skip(1)

                .findFirst()

                .get();


        System.out.println("Second Highest Salary: " 
                + secondHighestSalary);

    }
}