import java.util.*;

class Book {

    private int id;
    private String title;
    private String author;


    public Book(int id, String title, String author) {

        this.id = id;
        this.title = title;
        this.author = author;

    }


    public String getTitle() {

        return title;

    }


    @Override
    public String toString() {

        return "ID: " + id +
                ", Title: " + title +
                ", Author: " + author;

    }

}



public class BookLibrary {


    public static Optional<Book> searchBookByTitle(String title) {


        List<Book> books = Arrays.asList(

                new Book(1, "Java Programming", "James"),
                new Book(2, "Python Basics", "Robert"),
                new Book(3, "Database System", "John")

        );


        return books.stream()

                .filter(book -> 
                        book.getTitle().equalsIgnoreCase(title))

                .findFirst();

    }



    public static void main(String[] args) {


        Optional<Book> book =
                searchBookByTitle("Java Programming");



        book.ifPresent(foundBook -> {


            System.out.println("Book Found:");

            System.out.println(foundBook);


        });


    }

}