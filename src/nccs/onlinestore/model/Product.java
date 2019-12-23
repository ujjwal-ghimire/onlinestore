
package nccs.onlinestore.model;

public class Product {
    
    int product_id;
    int category_id;
    String name;
    float price;
    int discount;
    String unit;
    int stock;

    public Product(int product_id, int category_id, String name, float price, int discount, String unit, int stock) {
        this.product_id = product_id;
        this.category_id = category_id;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.unit = unit;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" + "product_id=" + product_id + ", category_id=" + category_id + ", name=" + name + ", price=" + price + ", discount=" + discount + ", unit=" + unit + ", stock=" + stock + '}';
    }
    
    
    
}
