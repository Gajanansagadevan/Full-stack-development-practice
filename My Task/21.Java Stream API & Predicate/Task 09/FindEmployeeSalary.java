import java.util.*;
import java.util.function.Predicate;

public class FindEmployeeSalary {

    public static void main(String[] args) {


        List<Employee> employees = Arrays.asList(

                new Employee(101, "John", 28, 55000, "IT"),
                new Employee(102, "Alice", 35, 75000, "HR"),
                new Employee(103, "David", 40, 95000, "IT")

        );


        Predicate<Employee> salaryAbove80000 =

                employee -> employee.getSalary() > 80000;


        Employee employee = employees.stream()

                .filter(salaryAbove80000)

                .findFirst()

                .get();


        System.out.println("First employee with salary above 80000:");

        System.out.println(employee);

    }
}