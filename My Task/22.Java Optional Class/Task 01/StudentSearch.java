import java.util.*;

class Student {

    private int id;
    private String name;
    private int age;


    public Student(int id, String name, int age) {

        this.id = id;
        this.name = name;
        this.age = age;

    }


    public int getId() {

        return id;

    }


    public String getName() {

        return name;

    }


    @Override
    public String toString() {

        return "ID: " + id +
                ", Name: " + name +
                ", Age: " + age;

    }

}


public class StudentSearch {


    public static Optional<Student> findStudentById(int id) {


        List<Student> students = Arrays.asList(

                new Student(101, "John", 20),
                new Student(102, "Alice", 21),
                new Student(103, "David", 22)

        );


        return students.stream()

                .filter(student -> student.getId() == id)

                .findFirst();

    }



    public static void main(String[] args) {


        Optional<Student> student = findStudentById(102);



        if (student.isPresent()) {


            System.out.println("Student Found:");

            System.out.println("Name: " 
                    + student.get().getName());


        } else {


            System.out.println("Student not found");


        }


    }

}