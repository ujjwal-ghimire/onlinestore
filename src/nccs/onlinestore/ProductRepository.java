
package nccs.onlinestore;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    
    public List<Product> getAllProducts() throws SQLException {
        Connection connection = DBConnection.getConnection();
        Statement statement=connection.createStatement();  
        ResultSet resultSet=statement.executeQuery("select * from products");
        List<Product> products = new ArrayList<>();
        
        while ( resultSet.next()) {
            Product product = new Product(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3), resultSet.getFloat(4), resultSet.getInt(5), resultSet.getString(6), resultSet.getInt(7));
            products.add(product);
        }
        
        DBConnection.closeConnection();
        return products;
        
    }
    
}
