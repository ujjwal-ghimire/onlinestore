/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author spectre
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "root", "root");
        Statement statement=connection.createStatement();  
        ResultSet resultSet=statement.executeQuery("select * from doctor");
        System.out.println("name\t\tphone");
        while(resultSet.next())  
            System.out.println(resultSet.getString(2)+"\t"+resultSet.getString(3));  
        connection.close();  
    }
    
}
