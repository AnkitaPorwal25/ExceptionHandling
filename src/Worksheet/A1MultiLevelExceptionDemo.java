package Worksheet;
import java.io.*;

// Custom exception class
class DataProcessingException extends Exception {
    public DataProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class A1MultiLevelExceptionDemo {

    // Now actually reads from a file
    public static void readData() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/Documents/data.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println("Read line: " + line);
        }
        br.close();
    }

    public static void processData() throws DataProcessingException {
        try {
            readData();
        } catch (IOException e) {
            System.out.println("IOException caught in processData()");
            throw new DataProcessingException("Error processing data", e);
        }
    }

    public static void main(String[] args) {
        try {
            processData();
        } catch (DataProcessingException e) {
            System.out.println("DataProcessingException caught in main(): " + e.getMessage());
            e.printStackTrace();
        }
    }
}


//        Multi-level exception propagation
//        Write a program with three methods: readData(), processData(), and
//main().
//         readData() reads from a file and throws IOException.
//         processData() calls readData() and catches IOException,
//        then throws a DataProcessingException (custom).
//         main() catches DataProcessingException and logs it.
//        Simulate this flow and explain how exceptions travel across layers.