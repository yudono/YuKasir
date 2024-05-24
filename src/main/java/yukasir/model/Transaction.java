package yukasir.model;

import java.sql.Timestamp;

public class Transaction {
    private int id;
    private String invoice;
    private int productid;
    private String productName;
    private int quantity;
    private double total;
    private double change;
    private Timestamp timestamp;

    public Transaction(int id, String invoice,int productid, int quantity, double total, double change, Timestamp timestamp) {
        this.id = id;
        this.invoice = invoice;
        this.productid = productid;
        this.quantity = quantity;
        this.total = total;
        this.change = change;
        this.timestamp = timestamp;
    }
    
    public Transaction(int id, String invoice,String productName, int quantity, double total, double change, Timestamp timestamp) {
        this.id = id;
        this.invoice = invoice;
        this.productName = productName;
        this.quantity = quantity;
        this.total = total;
        this.change = change;
        this.timestamp = timestamp;
    }

    // Getters
    public int getId() {
        return id;
    }
    
    public String getInvoice() {
        return invoice;
    }
    

    public int getProductid() {
        return productid;
    }
    
    public String getProductname() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotal() {
        return total;
    }

    public double getChange() {
        return change;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
