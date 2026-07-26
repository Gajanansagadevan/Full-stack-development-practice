import java.util.*;
import java.util.function.Predicate;

public class ITEmployeeFilter {

    public static void main(String[] args) {


        List<Employee> employees = Arrays.asList(

                new Employee(101, "John", 28, 55000, "IT"),
                new Employee(102, "Alice", 35, 75000, "HR"),
                new Employee(103, "David", 40, 95000, "IT"),
                new Employee(104, "Mark", 32, 65000, "Finance")

        );


        Predicate<Employee> itDepartment =
                employee -> employee.getDepartment().equals("IT");


        Predicate<Employee> ageGreaterThan30 =
                employee -> employee.getAge() > 30;


        System.out.println("Employees in IT department and age above 30:");

        employees.stream()
                .filter(itDepartment.and(ageGreaterThan30))
                .forEach(System.out::println);

    }
}