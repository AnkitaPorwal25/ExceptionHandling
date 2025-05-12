package Worksheet;
public class A11ThreadExceptionExample {
    public static void main(String[] args) {
        // Create a thread
        Thread thread = new Thread(() -> {
            System.out.println("Child thread running...");
            throw new RuntimeException("Something went wrong in child thread");
        });

        // Set uncaught exception handler for this thread
        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("Caught exception from thread: " + t.getName());
            System.out.println("Exception message: " + e.getMessage());
        });

        thread.start();

        System.out.println("Main thread continues...");
    }
}
