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
