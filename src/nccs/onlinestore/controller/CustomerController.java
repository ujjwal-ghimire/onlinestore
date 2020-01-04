/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nccs.onlinestore.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import nccs.onlinestore.repository.CustomerRepository;
import nccs.onlinestore.model.Customer;

/**
 *
 * @author spectre
 */
public class CustomerController {
    
    private Customer currentUser = null;
    
    public Customer getCurrentUser() {
        return currentUser;
    }
    public boolean login(String email) throws SQLException {
        
        CustomerRepository customerRepository = new CustomerRepository();
        List<Customer> customers = customerRepository.getCustomers();
        
        for ( Customer customer: customers) {
            if ( customer.getEmail().equals(email)) {
                currentUser = customer;
            }
        }
        return currentUser != null;
    }
    
}
