package Worksheet;
import java.util.HashMap;
import java.util.Map;

class InvalidAccountException1 extends Exception {
    public InvalidAccountException1(String message) {
        super(message);
    }
}

public class A5BankSystem {
    private Map<String, Integer> accounts = new HashMap<>();

    public A5BankSystem() {
        // Create two sample accounts
        accounts.put("Alice", 1000);
        accounts.put("Bob", 500);
        // Note: "Charlie" does not exist to simulate an invalid account
    }

    public void transferFunds(String from, String to, int amount) throws InvalidAccountException1 {
        System.out.println("Initiating transfer of $" + amount + " from " + from + " to " + to);

        if (!accounts.containsKey(from)) {
            throw new InvalidAccountException1("Source account does not exist: " + from);
        }

        if (accounts.get(from) < amount) {
            throw new IllegalArgumentException("Insufficient funds in account: " + from);
        }

        // Deduct from sender first
        accounts.put(from, accounts.get(from) - amount);

        try {
            if (!accounts.containsKey(to)) {
                throw new InvalidAccountException1("Target account does not exist: " + to);
            }

            // Credit to recipient
            accounts.put(to, accounts.get(to) + amount);
            System.out.println("Transfer successful.");

        } catch (Exception e) {
            // Rollback
            accounts.put(from, accounts.get(from) + amount);
            System.out.println("Transfer failed. Rolling back transaction.");
            throw e; // Re-throw for caller to handle/log
        }
    }

    public void printBalances() {
        System.out.println("Account Balances:");
        for (String name : accounts.keySet()) {
            System.out.println(name + ": $" + accounts.get(name));
        }
    }

    public static void main(String[] args) {
        A5BankSystem bank = new A5BankSystem();
        bank.printBalances();

        try {
            bank.transferFunds("Alice", "Charlie", 300); // Charlie doesn't exist
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        bank.printBalances();  // Ensure balance is unchanged
    }
}

//
//Partial transaction rollback on failure
//Simulate a simple in-memory bank transfer system where moving funds
//between accounts must rollback if an exception occurs mid-operation (e.g.,
//                                                                     invalid target account).
//Use try-catch to ensure that no partial transfer leaves accounts in an
//inconsistent state.