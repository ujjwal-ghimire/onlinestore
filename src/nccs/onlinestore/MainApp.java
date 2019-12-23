package nccs.onlinestore;

import nccs.onlinestore.controller.CustomerController;
import nccs.onlinestore.model.Customer;
import nccs.onlinestore.view.ClientView;

public class MainApp {

    public static void main(String[] args) throws Exception {

         ClientView clientView = new ClientView();
         
        CustomerController customerController = new CustomerController();
        Customer currentCustomer = customerController.login(clientView.logIn());
        System.out.println("Welcome " + currentCustomer.getFirstName());
        clientView.mainPage(currentCustomer);
    }

}
