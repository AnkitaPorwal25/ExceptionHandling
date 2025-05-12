package Worksheet.A9ChainedExceptionDemo;

import Worksheet.A9ChainedExceptionDemo.Controller.UserController;

public class MainApp {
    public static void main(String[] args) {
        UserController controller = new UserController();
        controller.handleRequest(101); // you can change the ID as needed
    }
}
