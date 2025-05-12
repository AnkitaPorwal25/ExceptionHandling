package Worksheet;
public class A12GlobalExceptionHandlerExample {

    public static void main(String[] args) {
        // Set global default uncaught exception handler
        Thread.setDefaultUncaughtExceptionHandler((thread, exception) -> {
            System.out.println("Global handler caught exception in thread: " + thread.getName());
            System.out.println("Exception: " + exception.getClass().getSimpleName());
            System.out.println("Message: " + exception.getMessage());
        });

        // Create two threads that throw exceptions
        Thread t1 = new Thread(() -> {
            System.out.println("Thread 1 running...");
            throw new RuntimeException("Unexpected error in Thread 1");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread 2 running...");
            throw new NullPointerException("Null reference in Thread 2");
        });

        t1.start();
        t2.start();

        System.out.println("Main thread finished setup.");
    }
}

//
//
//Global exception handler
//Write a Java application where all uncaught exceptions are logged by setting a
//global exception handler (using
//                                  Thread.setDefaultUncaughtExceptionHandler()).