package Worksheet;
import java.io.File;
// Custom checked exception
class FileValidationException extends Exception {
    public FileValidationException(String message) {
        super(message);
    }
}

// Custom unchecked (runtime) exception
class CriticalSystemException extends RuntimeException {
    public CriticalSystemException(String message) {
        super(message);
    }
}

public class A6ExceptionTypeDemo {

    // Checked exception: caller must handle or declare
    public static void validateFile(String filePath) throws FileValidationException {
        File file = new File(filePath);
        if (!file.exists() || !file.getName().endsWith(".txt")) {
            throw new FileValidationException("File must exist and be a .txt file: " + filePath);
        }
        System.out.println("File is valid: " + filePath);
    }

    // Unchecked exception: used for system-critical failures
    public static void checkSystemHealth() {
        boolean systemCorrupted = true;  // simulate system failure
        if (systemCorrupted) {
            throw new CriticalSystemException("Critical system corruption detected!");
        }
        System.out.println("System health is OK.");
    }

    public static void main(String[] args) {
        // Demonstrating checked exception
        try {
            validateFile("invalid_file.pdf");  // Will throw FileValidationException
        } catch (FileValidationException e) {
            System.err.println("Caught checked exception: " + e.getMessage());
        }

        // Demonstrating unchecked exception
        // This will terminate the program unless caught
        checkSystemHealth();  // Throws CriticalSystemException
    }
}

//
//        Custom checked vs unchecked exceptions
//        Define a custom checked exception (FileValidationException) and a
//        runtime exception (CriticalSystemException).
//        Write code that shows where and why each type makes sense.