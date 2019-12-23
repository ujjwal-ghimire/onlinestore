
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
        return "" + product_id +" : \t" +  name + "\t Rs." + price + " " + discount + "% discount available :-> " + stock + "" + unit;
    }

    public int getProduct_id() {
        return product_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public int getDiscount() {
        return discount;
    }

    public String getUnit() {
        return unit;
    }

    public int getStock() {
        return stock;
    }
    
    
    
}
