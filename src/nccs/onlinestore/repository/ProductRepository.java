package nccs.onlinestore.repository;

import nccs.onlinestore.model.Product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import nccs.onlinestore.DBConnection;

public class ProductRepository {

    public static List<Product> getAllProducts() throws SQLException {

        Connection connection = DBConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from products");
        List<Product> products = new ArrayList<>();

        while (resultSet.next()) {
            Product product = new Product(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3), resultSet.getFloat(4), resultSet.getInt(5), resultSet.getString(6), resultSet.getInt(7));
            products.add(product);
        }

        DBConnection.closeConnection();
        return products;

    }

    public static Product getProduct(int productId) throws SQLException {
        List<Product> allProduct = getAllProducts();
        for (Product product : allProduct) {
            if (product.getProduct_id() == productId) {
                return product;
            }
        }
        return null;
    }

    public static List<Product> getProductsByCategoryId(int categoryId) throws SQLException {

        List<Product> allProducts = getAllProducts();
        List<Product> productByCategory = new ArrayList<>();
        for (Product product : allProducts) {
            if (product.getCategory_id() == categoryId) {
                productByCategory.add(product);
            }
        }
        return productByCategory;

    }

}
