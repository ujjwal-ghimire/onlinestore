/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nccs.onlinestore.view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import nccs.onlinestore.dao.CartRepository;
import nccs.onlinestore.dao.CategoryRepository;
import nccs.onlinestore.dao.ProductRepository;
import nccs.onlinestore.model.Category;
import nccs.onlinestore.model.Customer;
import nccs.onlinestore.model.Product;

/**
 *
 * @author spectre
 */
public class ClientView {

    public void categories() throws SQLException {
        CategoryRepository categoryRepository = new CategoryRepository();

        List<Category> categories = categoryRepository.getCategory();

        System.out.println("Category ID : Category Name");
        for (Category category : categories) {
            System.out.println(category.getCategory_id() + "\t" + category.getName());
        }

    }
    
    public void Products(int categoryId) throws SQLException {
         ProductRepository productRepository = new ProductRepository();
            List<Product> products = productRepository.getProductsByCategoryId(categoryId);
            System.out.println("ID : Product");
            for (Product product : products) {
                System.out.println(product.toString());
            }
    }

    public void mainPage(Customer customer) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        int categoryId;
        do {
            categories();
            System.out.println("Select a category or 0 to exit :");

            categoryId = scanner.nextInt();
            if ( categoryId == 0 ) {
                return;
            }

            Products(categoryId);
            System.out.println("Select a product to add to cart or 0 to cancel :");
            int productId = scanner.nextInt();
            
            if ( productId != 0 ) {
                CartRepository.addToCart(customer.getCustomerId(), productId, 1);
            }

        } while (true);
    }

    public String logIn() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please login by your email: ");
        return scanner.next();
    }
}
