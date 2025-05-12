package Worksheet.A10ExceptionAsControlMechanism;
public class BadLoopExmple {
    public static void main(String[] args) {
        String[] data = {"one", "two", "stop", "three"};

        for (String item : data) {
            try {
                if ("stop".equals(item)) {
                    throw new Exception("Stop signal found");
                }
                System.out.println("Processing: " + item);
            } catch (Exception e) {
                System.out.println("Breaking loop with exception: " + e.getMessage());
                break;
            }
        }
    }
}
