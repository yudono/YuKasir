/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yukasir.controller;

import java.io.File;
import java.sql.*;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import org.mindrot.jbcrypt.BCrypt;
import yukasir.model.Category;
import yukasir.model.Product;

/**
 *
 * @author Paideia
 */
public class BaseController {
    
    protected static Connection conn = null;
    protected static Statement stmt = null;
    protected final static String dbUrl = "yukasir-1.0.db";
   
    
    Product[] products = {
        new Product(0,"/image-1.jpg","Kepiting Saus Padang", 12000,100,"Makanan"),
        new Product(1,"/image-2.jpg","Nasi Kuning",15000,100,"Makanan"),
        new Product(2,"/image-3.jpg","Bakso",10000,100,"Makanan"),
        new Product(3,"/image-4.jpg","Sate Ayam",14000,100,"Makanan"),
        new Product(4,"/image-5.jpg","Chicken Katsu",16000,100,"Makanan"),
        new Product(5,"/image-1.jpg","Kepiting Saus Padang", 12000,100,"Makanan"),
        new Product(6,"/image-2.jpg","Nasi Kuning",15000,100,"Makanan"),
        new Product(7,"/image-3.jpg","Bakso",10000,100,"Makanan"),
        new Product(8,"/image-4.jpg","Sate Ayam",14000,100,"Makanan"),
        new Product(9,"/image-5.jpg","Chicken Katsu",16000,100,"Makanan"),
    };
    
    Category[] categories = {
        new Category(0, "Makanan"),
        new Category(1, "Minuman"),
    };
    
    public BaseController(){
        try {
            connect();
        
            stmt = conn.createStatement();
            String sqlUser = "CREATE TABLE IF NOT EXISTS users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "email TEXT NOT NULL UNIQUE," +
                "password TEXT NOT NULL," +
                "role TEXT CHECK (role IN ('user', 'admin','manager')) NOT NULL" +
                ")";
            
            String sqlCategory = "CREATE TABLE IF NOT EXISTS category (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL" +
                ")";
            
            String sqlProduct = "CREATE TABLE IF NOT EXISTS product (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "price REAL NOT NULL," +
                "path TEXT," +
                "stock INT NOT NULL," +
                "category INT," +
                "FOREIGN KEY (category) REFERENCES category(id)" +
                ")";
            
            String sqlTransaction = "CREATE TABLE IF NOT EXISTS transactions (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "invoice TEXT NOT NULL," +
                "productid INTEGER NOT NULL," +
                "quantity INTEGER NOT NULL," +
                "total REAL NOT NULL," +
                "change REAL NOT NULL," +
                "timestamp DATETIME DEFAULT CURRENT_TIMESTAMP," +
                "FOREIGN KEY (productid) REFERENCES product(id)" +
                ")";
            
            stmt.executeUpdate(sqlUser);
            stmt.executeUpdate(sqlCategory);
            stmt.executeUpdate(sqlProduct);
            stmt.executeUpdate(sqlTransaction);
            
            seederDB();
            
            stmt.close();
//            conn.close();
        } catch ( Exception e ) {
            String errorMessage = e.getClass().getName() + ": " + e.getMessage();
            System.err.println( errorMessage );
            showMessageDialog(null,errorMessage,"Error", ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    public static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:"+dbUrl);
        } catch ( Exception e ) {
            String errorMessage = e.getClass().getName() + ": " + e.getMessage();
            System.err.println( errorMessage );
            showMessageDialog(null,errorMessage,"Error", ERROR_MESSAGE);
            System.exit(0);
        }
//        showMessageDialog(null,"Opened database successfully","Info", INFORMATION_MESSAGE);
//        System.out.println("Opened database successfully");
    }
    
    public void seederDB() {
        String sql = "INSERT INTO users (id, name, email, password, role) VALUES (?, ?, ?, ?, ?)";
        String rawSql = "SELECT password FROM users WHERE email = ?";
        
        try(PreparedStatement pstmtS = conn.prepareStatement(rawSql)){
            pstmtS.setString(1, "user@gmail.com");
            ResultSet rs = pstmtS.executeQuery();
            if(rs.next()){
                return;
            }
        } catch (SQLException e) {
            String errorMessage = e.getClass().getName() + ": " + e.getMessage();
            System.out.println(errorMessage);
            showMessageDialog(null,errorMessage,"Error", ERROR_MESSAGE);
        }
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Insert user
            pstmt.setInt(1, 1);
            pstmt.setString(2, "user");
            pstmt.setString(3, "user@gmail.com");
            pstmt.setString(4, BCrypt.hashpw("12345", BCrypt.gensalt())); // Hash the password
            pstmt.setString(5, "user");
            pstmt.executeUpdate();

            // Insert admin
            pstmt.setInt(1, 2);
            pstmt.setString(2, "admin");
            pstmt.setString(3, "admin@gmail.com");
            pstmt.setString(4, BCrypt.hashpw("12345", BCrypt.gensalt())); // Hash the password
            pstmt.setString(5, "admin");
            pstmt.executeUpdate();
            
             // Insert admin
            pstmt.setInt(1, 3);
            pstmt.setString(2, "manager");
            pstmt.setString(3, "manager@gmail.com");
            pstmt.setString(4, BCrypt.hashpw("12345", BCrypt.gensalt())); // Hash the password
            pstmt.setString(5, "manager");
            pstmt.executeUpdate();
            
            // seeder category
            CategoryController categoryCon = new CategoryController();
            for(int i = 0;i<categories.length;i++){
                categoryCon.create(categories[i]);
            }
            
            // seeder product
            ProductController productCon = new ProductController();
            for(int j = 0;j<products.length;j++){
                productCon.create(products[j], 0);
            }

        } catch (SQLException e) {
            String errorMessage = e.getClass().getName() + ": " + e.getMessage();
            System.out.println(errorMessage);
            showMessageDialog(null,errorMessage,"Error", ERROR_MESSAGE);
        }
    }
    
}
