/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nccs.onlinestore.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import nccs.onlinestore.model.Customer;
import nccs.onlinestore.repository.CartRepository;
import nccs.onlinestore.model.Product;
import nccs.onlinestore.repository.ProductRepository;

/**
 *
 * @author spectre
 */
public class CartController {

    List<Product> selectedProducts = new ArrayList<>();

    public boolean addToCart(int productId, Customer customer) throws SQLException {

        Product product = ProductRepository.getProduct(productId);
        if (product != null && product.getStock() > 0) {
            CartRepository.addToCart(customer.getCustomerId(), product.getProduct_id(), 1);
            return true;
        }
        return false;
    }
}
