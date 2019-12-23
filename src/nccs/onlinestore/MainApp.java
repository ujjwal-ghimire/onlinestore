package nccs.onlinestore;

import nccs.onlinestore.dao.ProductRepository;
import nccs.onlinestore.model.Product;
import java.util.List;

public class MainApp {

    public static void main(String[] args) throws Exception {
        
        ProductRepository productRepository = new ProductRepository();
        
        List<Product> products = productRepository.getAllProducts();
        
        System.out.println("All Products:");
        for(Product product : products) {
            System.out.println(product);
        }   
        
    }
    
}
