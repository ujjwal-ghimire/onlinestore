/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nccs.onlinestore.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import nccs.onlinestore.DBConnection;
import nccs.onlinestore.model.Category;
import nccs.onlinestore.model.Customer;

/**
 *
 * @author spectre
 */
public class CustomerRepository {
    
    public List<Customer> getCustomers() throws SQLException {
        Connection connection = DBConnection.getConnection();
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select * from customers");
        List<Customer> customers = new ArrayList<>();
        
        while ( resultSet.next()) {
            Customer customer = new Customer(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
            customers.add(customer);
        }
        
        DBConnection.closeConnection();
        return customers;
    }
}
