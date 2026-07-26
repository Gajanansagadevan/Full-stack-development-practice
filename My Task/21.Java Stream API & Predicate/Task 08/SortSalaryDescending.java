import java.util.*;

public class SortSalaryDescending {

    public static void main(String[] args) {


        List<Employee> employees = Arrays.asList(

                new Employee(101, "John", 28, 55000, "IT"),
                new Employee(102, "Alice", 35, 75000, "HR"),
                new Employee(103, "David", 40, 95000, "IT")

        );


        System.out.println("Employees sorted by salary:");

        employees.stream()

                .sorted(Comparator.comparing(Employee::getSalary).reversed())

                .forEach(System.out::println);

    }
}