package yukasir;

import yukasir.model.Product;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Paideia
 */
public class Transaction {
    
    public int id;
    public String path;
    public String name;
    public int pricePerUnit;
    public int quantity = 1;
    
    public Transaction(Product product){
        this.id = product.id;
        this.path = product.path;
        this.name = product.name;
        this.pricePerUnit = product.price;
    }
    
    public void incrementQuantity() {
        quantity++;
    }
    
    public void decrementQuantity() {
        if(quantity > 1){
            quantity--;
        }
    }
    
}
