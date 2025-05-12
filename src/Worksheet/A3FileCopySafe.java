package Worksheet;
import java.io.*;

public class A3FileCopySafe {

    public static void main(String[] args) {
        String inputPath = "src/Documents/input.txt";
        String outputPath = "src/Documents/output.txt";

        try (
                BufferedReader reader = new BufferedReader(new FileReader(inputPath));
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.out.println("Error during file processing: " + e.getMessage());
        }
    }
}

//
//Exception-safe resource handling with multiple
//        resources
//Write a program that opens two files (BufferedReader and
//BufferedWriter), reads from one, and writes to the other.
//Use try-with-resources to ensure both are closed safely, even if
//exceptions occur in the middle.