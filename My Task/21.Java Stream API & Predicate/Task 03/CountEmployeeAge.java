import java.util.*;
import java.util.function.Predicate;

public class CountEmployeeAge {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(

                new Employee(101, "John", 28, 55000, "IT"),
                new Employee(102, "Alice", 35, 75000, "HR"),
                new Employee(103, "David", 40, 95000, "IT"),
                new Employee(104, "Mark", 32, 65000, "Finance")

        );


        Predicate<Employee> ageAbove30 =
                employee -> employee.getAge() > 30;


        long count = employees.stream()
                .filter(ageAbove30)
                .count();


        System.out.println("Employees above age 30: " + count);

    }
}