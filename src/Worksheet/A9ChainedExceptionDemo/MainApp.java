package Worksheet.A9ChainedExceptionDemo;

import Worksheet.A9ChainedExceptionDemo.Controller.UserController;

public class MainApp {
    public static void main(String[] args) {
        UserController controller = new UserController();
        controller.handleRequest(101); // you can change the ID as needed
    }
}

//
//Chained exceptions across layers
//Simulate a layered app:
//         Repository throws SQLException.
//         Service layer catches it, wraps it in a ServiceLayerException.
//         Controller layer catches ServiceLayerException and logs it.
//Write code demonstrating this multi-layer exception wrapping.