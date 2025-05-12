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
