/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yukasir.model;

/**
 *
 * @author Paideia
 */
public class Product {
    public int id;
    public String path;
    public String name;
    public int price;
    public int stock;
    public String category;
    
    public Product(int id, String path, String name, int price, int stock, String category) {
        this.id = id;
        this.path = path;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }

    public Product(int id,String path, String name,int price){
        this.id = id;
        this.path = path;
        this.name = name;
        this.price = price;
    }
   
     public int getId() {
        return id;
    }
    public String getPath() {
        return path;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public int getStock() {
        return stock;
    }
    public String getCategory() {
        return category;
    }
}
