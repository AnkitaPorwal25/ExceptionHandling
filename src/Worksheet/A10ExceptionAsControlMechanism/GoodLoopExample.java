package Worksheet.A10ExceptionAsControlMechanism;
public class GoodLoopExample {
    public static void main(String[] args) {
        String[] data = {"one", "two", "stop", "three"};

        for (String item : data) {
            if ("stop".equals(item)) {
                System.out.println("Stop signal found, breaking loop.");
                break;
            }
            System.out.println("Processing: " + item);
        }
    }
}
