package Worksheet.A9ChainedExceptionDemo.Exception;
public class ServiceLayerException extends Exception {
    public ServiceLayerException(String message, Throwable cause) {
        super(message, cause);
    }
}
