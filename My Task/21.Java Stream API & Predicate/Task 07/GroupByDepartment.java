import java.util.*;
import java.util.stream.Collectors;

public class GroupByDepartment {

    public static void main(String[] args) {


        List<Employee> employees = Arrays.asList(

                new Employee(101, "John", 28, 55000, "IT"),
                new Employee(102, "Alice", 35, 75000, "HR"),
                new Employee(103, "David", 40, 95000, "IT"),
                new Employee(104, "Mark", 32, 65000, "Finance")

        );


        Map<String, List<Employee>> employeesByDepartment =

                employees.stream()

                .collect(Collectors.groupingBy(Employee::getDepartment));


        System.out.println("Employees Grouped By Department:");

        employeesByDepartment.forEach((department, employeeList) -> {

            System.out.println("\nDepartment: " + department);

            employeeList.forEach(System.out::println);

        });

    }
}