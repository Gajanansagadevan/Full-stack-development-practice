import java.util.*;

public class HighestSalaryEmployee {

    public static void main(String[] args) {


        List<Employee> employees = Arrays.asList(

                new Employee(101, "John", 28, 55000, "IT"),
                new Employee(102, "Alice", 35, 75000, "HR"),
                new Employee(103, "David", 40, 95000, "IT")

        );


        Employee highestPaidEmployee = employees.stream()

                .max(Comparator.comparing(Employee::getSalary))

                .get();


        System.out.println("Highest Paid Employee:");

        System.out.println(highestPaidEmployee);

    }
}