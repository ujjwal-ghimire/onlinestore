/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nccs.onlinestore.model;

/**
 *
 * @author spectre
 */
public class Category {
    
    int category_id;
    String name;

    public Category(int category_id, String name) {
        this.category_id = category_id;
        this.name = name;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
