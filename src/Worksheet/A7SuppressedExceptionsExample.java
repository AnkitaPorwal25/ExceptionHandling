package Worksheet;
class CustomResourceOne implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("Closing CustomResourceOne");
        throw new Exception("Exception from CustomResourceOne");
    }
}

class CustomResourceTwo implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("Closing CustomResourceTwo");
        throw new Exception("Exception from CustomResourceTwo");
    }
}

public class A7SuppressedExceptionsExample {
    public static void main(String[] args) {
        try (CustomResourceOne res1 = new CustomResourceOne();
             CustomResourceTwo res2 = new CustomResourceTwo()) {

            System.out.println("Using both resources");

        } catch (Exception e) {
            System.out.println("Caught primary exception: " + e.getMessage());

            // Print suppressed exceptions
            for (Throwable suppressed : e.getSuppressed()) {
                System.out.println("Suppressed: " + suppressed.getMessage());
            }
        }
    }
}
