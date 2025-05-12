package Worksheet;

import java.util.Random;

// Step 1: Define the custom exception
class ServiceUnavailableException extends Exception {
    public ServiceUnavailableException(String message) {
        super(message);
    }
}

// Step 2: Simulate a flaky service that fails randomly
class FlakyService {
    private final Random random = new Random();

    public String getData() throws Exception {
        if (random.nextInt(10) < 7) { // 70% chance to fail
            throw new Exception("Flaky service failure");
        }
        return "Data from flaky service";
    }
}

// Step 3: Implement retry mechanism
public class A8RetryServiceCaller {

    public static String callServiceWithRetry(FlakyService service, int maxAttempts) throws ServiceUnavailableException {
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            try {
                System.out.println("Attempt " + attempt + "...");
                return service.getData(); // Success: return immediately
            } catch (Exception e) {
                System.out.println("Attempt " + attempt + " failed: " + e.getMessage());
                if (attempt == maxAttempts) {
                    throw new ServiceUnavailableException("Service failed after " + maxAttempts + " attempts");
                }
            }
        }
        return null; // unreachable, but required
    }

    public static void main(String[] args) {
        FlakyService service = new FlakyService();

        try {
            String result = callServiceWithRetry(service, 3);
            System.out.println("SUCCESS: " + result);
        } catch (ServiceUnavailableException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}

//
//        Programmatic exception handling policy
//        Implement a retry mechanism: write a method that attempts to read from a flaky
//        service 3 times. If it fails all 3 times, it throws a
//        ServiceUnavailableException.