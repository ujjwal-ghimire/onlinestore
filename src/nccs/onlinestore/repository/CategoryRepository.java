/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nccs.onlinestore.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import nccs.onlinestore.DBConnection;
import nccs.onlinestore.model.Category;

/**
 *
 * @author spectre
 */
public class CategoryRepository {

    public List<Category> getCategory() throws SQLException {

        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from categories");
        List<Category> categories = new ArrayList<>();

        while (resultSet.next()) {
            Category category = new Category(resultSet.getInt(1), resultSet.getString(2));
            categories.add(category);
        }

        DBConnection.closeConnection();
        return categories;
    }
}
