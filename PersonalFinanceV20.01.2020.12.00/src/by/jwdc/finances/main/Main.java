package by.jwdc.finances.main;

import by.jwdc.finances.controller.Controller;

public class Main {

    public static void main(String[] args) {

        Controller controller = new Controller();

        String request = "Show_all_finance_operations";
        String response;

        response = controller.executeRequest(request);
        System.out.println(response);

        request = "add_finance_operation time=20-01-2020-10:30 type=home_staff value=45.55";
        response = controller.executeRequest(request);
        System.out.println(response);
    }
}
