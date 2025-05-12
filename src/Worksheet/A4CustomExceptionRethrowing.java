package Worksheet;

import java.io.IOException;

class CustomException extends Exception {
    public CustomException(String message, Throwable cause) {
        super(message, cause);  // Preserve original stack trace
    }
}
public class A4CustomExceptionRethrowing {

    public static void riskyOperation() throws IOException {
        // Simulate an I/O error
        throw new IOException("Simulated IO failure");
    }

    public static void handleAndWrapException() throws CustomException {
        try {
            riskyOperation();
        } catch (IOException e) {
            // Wrap and re-throw with a custom message and the original cause
            throw new CustomException("Failed during riskyOperation", e);
        }
    }

    public static void main(String[] args) {
        try {
            handleAndWrapException();
        } catch (CustomException e) {
            System.err.println("Caught custom exception: " + e.getMessage());
            e.printStackTrace();  // Shows full stack trace including the original cause
        }
    }
}
