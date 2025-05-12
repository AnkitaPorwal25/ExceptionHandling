package Worksheet;
// Base custom exception class
class BankingException extends Exception {
    public BankingException(String message) {
        super(message);
    }
}

// Subclass for insufficient funds scenario
class InsufficientFundsException extends BankingException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// Subclass for invalid account scenario
class InvalidAccountException extends BankingException {
    public InvalidAccountException(String message) {
        super(message);
    }
}

public class A2CustomExceptionHierarchyDemo {

    // Method that simulates fund transfer and throws custom exceptions
    public static void transferFunds(double balance, double transferAmount, String account) throws BankingException {
        if (balance < transferAmount) {
            throw new InsufficientFundsException("Insufficient funds for transfer.");
        } else if (account == null || account.isEmpty()) {
            throw new InvalidAccountException("Invalid account details.");
        } else {
            System.out.println("Transfer successful!");
        }
    }

    public static void main(String[] args) {
        try {
            // Test case with insufficient funds
            transferFunds(500.0, 600.0, "Account123");
        } catch (InsufficientFundsException e) {
            System.out.println("Caught InsufficientFundsException: " + e.getMessage());
        } catch (InvalidAccountException e) {
            System.out.println("Caught InvalidAccountException: " + e.getMessage());
        } catch (BankingException e) {
            System.out.println("Caught BankingException: " + e.getMessage());
        }

        try {
            // Test case with invalid account
            transferFunds(500.0, 200.0, "");
        } catch (InsufficientFundsException e) {
            System.out.println("Caught InsufficientFundsException: " + e.getMessage());
        } catch (InvalidAccountException e) {
            System.out.println("Caught InvalidAccountException: " + e.getMessage());
        } catch (BankingException e) {
            System.out.println("Caught BankingException: " + e.getMessage());
        }

        try {
            // Test case with a successful transfer
            transferFunds(500.0, 200.0, "Account123");
        } catch (BankingException e) {
            System.out.println("Caught BankingException: " + e.getMessage());
        }
    }
}
