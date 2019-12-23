/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nccs.onlinestore.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import nccs.onlinestore.DBConnection;

/**
 *
 * @author spectre
 */
public class CartRepository {
    
    public static void addToCart(int customerId, int productId, int quantity) throws SQLException {
        
        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate("INSERT INTO carts values(" + customerId + ", " + productId + ", " + quantity + ")");       
    }
}
