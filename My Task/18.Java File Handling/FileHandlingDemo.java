import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileHandlingDemo {

    public static void main(String[] args) {

        // Create Folder
        File folder = new File("MyFolder");

        if (folder.mkdir()) {
            System.out.println("Folder created successfully.");
        } else {
            System.out.println("Folder already exists.");
        }

        // Create File
        File file = new File("MyFolder/sample.txt");

        try {

            if (file.createNewFile()) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }

            // Write to File
            FileWriter writer = new FileWriter(file);

            writer.write("Welcome to Java File Handling.\n");
            writer.write("This is a sample text file.\n");
            writer.write("Java makes file operations easy.");

            writer.close();

            System.out.println("Data written successfully.");

            // Read File
            Scanner reader = new Scanner(file);

            System.out.println("\nFile Content:");

            while (reader.hasNextLine()) {
                System.out.println(reader.nextLine());
            }

            reader.close();

            // Delete File
            if (file.delete()) {
                System.out.println("\nFile deleted successfully.");
            } else {
                System.out.println("\nFailed to delete the file.");
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}