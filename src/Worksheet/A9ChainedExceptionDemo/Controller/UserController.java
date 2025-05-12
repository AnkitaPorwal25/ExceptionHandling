package Worksheet.A9ChainedExceptionDemo.Controller;

import Worksheet.A9ChainedExceptionDemo.Exception.ServiceLayerException;
import Worksheet.A9ChainedExceptionDemo.Service.UserService;

public class UserController {
    private final UserService service = new UserService();

    public void handleRequest(int userId) {
        try {
            String user = service.getUser(userId);
            System.out.println("User found: " + user);
        } catch (ServiceLayerException e) {
            System.out.println("Controller Error: " + e.getMessage());
            System.out.println("Caused by: " + e.getCause().getMessage());
        }
    }
}
