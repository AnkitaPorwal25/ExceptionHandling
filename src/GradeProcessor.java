import java.io.*;
import java.util.*;

class InvalidGradeException extends Exception {
    public InvalidGradeException(String message) {
        super(message);
    }
}

public class GradeProcessor {

    public static void main(String[] args) {
        String filePath = "src/Documents/grades.txt";

        List<String> validStudents = new ArrayList<>();
        List<String> failingStudents = new ArrayList<>();
        int total = 0;
        int count = 0;

        BufferedReader br = null;
        PrintWriter pw = null;

        try {
            br = new BufferedReader(new FileReader(filePath));
            pw = new PrintWriter("src/Documents/results.txt");

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length != 2) {
                    System.out.println("Skipping malformed line: " + line);
                    continue;
                }

                String name = parts[0];
                try {
                    int grade = Integer.parseInt(parts[1]);
                    if (grade < 0 || grade > 100) {
                        throw new InvalidGradeException("Grade out of range: " + grade);
                    }

                    validStudents.add(name + " " + grade);
                    total += grade;
                    count++;

                    if (grade < 40) {
                        failingStudents.add(name);
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Warning: Non-numeric grade for " + name + ": " + parts[1]);
                } catch (InvalidGradeException e) {
                    System.out.println("Warning: " + e.getMessage());
                }
            }

            pw.println("Valid Students:");
            for (String student : validStudents) {
                pw.println(student);
            }

            pw.println("\nFailing Students:");
            for (String student : failingStudents) {
                pw.println(student);
            }

            if (count > 0) {
                double average = (double) total / count;
                pw.println("\nAverage Grade: " + average);
            } else {
                pw.println("\nNo valid grades to calculate average.");
            }

            System.out.println("Processing complete. Results saved to results.txt.");

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + filePath);
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        } finally {
            try {
                if (br != null) br.close();
                if (pw != null) pw.close();
            } catch (IOException e) {
                System.out.println("Error closing file streams: " + e.getMessage());
            }
        }
    }
}

//
//
//Java Exception Handling Hands-On Exercise Worksheet
//Exercise Title: Student Grades Processor
//Objective:
//Build a Java program that reads student names and grades from a file, processes the data, and handles
//exceptions properly.
//        ------------------------------------------------------------
//Background
//In this exercise, you will:
//        - Read data from a file.
//- Parse and validate numeric input.
//- Calculate the average grade.
//        - Identify failing students.
//- Apply Java exception handling concepts: try-catch, finally, custom exceptions.
//        ------------------------------------------------------------
//Tasks
//Step 1: Set Up the Project
//- Create a Java class called StudentGradesProcessor.
//        - Create a text file named grades.txt with sample data:
//Alice 85
//Bob 72
//Charlie 38
//Diana 95
//Edward seventy
//Step 2: Read and Parse File
//- Use BufferedReader or Scanner to read each line.
//        - Split each line into two parts: student name and grade.
//        - Convert the grade to an integer (Integer.parseInt()).
//Step 3: Validate Data
//- Check that the grade is between 0 and 100.
//        - If invalid (non-numeric or out of range), skip the line and log a warning.
//Step 4: Calculate Results
//- Calculate the average grade of valid entries.
//- Identify and list students with failing grades (< 40).
//        - Handle cases where no valid grades exist (avoid division by zero).
//Step 5: Handle Exceptions
//- Use try-catch-finally blocks to:
//        - Catch FileNotFoundException when opening the file.
//        - Catch NumberFormatException when parsing grades.
//- Create and throw a custom exception InvalidGradeException for out-of-range grades.
//        - Ensure the file stream closes properly in a finally block.
//        Step 6: Output Results
//- Print:
//        - Valid student names and grades.
//- List of failing students.
//        - Average grade.
//Bonus (Optional)
//- Allow the user to input the file path at runtime.
//        - Write the results to an output file (results.txt).
//        - Use try-with-resources for automatic resource management.
//------------------------------------------------------------
//Key Concepts to Apply
//- Checked vs. Unchecked Exceptions
//- Multiple Catch Blocks
//- Finally Block
//- Throwing Custom Exceptions
//- Defensive Programming
//------------------------------------------------------------
//Reflection Questions
//1. What are the advantages of using specific exception types instead of a general Exception catch?
//        2. Why is it important to close resources even when an exception occurs?
//        3. How does creating a custom exception improve the clarity of your code?
//        4. What would happen if you forgot to handle the FileNotFoundException?
//        ------------------------------------------------------------
//Notes
//- Write clean, well-commented code.
//        - Think about how users might break your program and defend against it.
//        - Ask for help if you get stuck - this is a learning exercise!
//Deliverables: Submit your .java file(s) and the grades.txt input file.