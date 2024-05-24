/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yukasir.controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import yukasir.model.Product;

/**
 *
 * @author Paideia
 */
public class ProductController  extends BaseController{


    public ProductController() {
        super();
    }

    public List<Product> getAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT p.*, c.name AS category_name, c.id AS category_id FROM product p LEFT JOIN category c ON p.category = c.id";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Product product = new Product(
                    rs.getInt("id"),
                    rs.getString("path"),
                    rs.getString("name"),
                    rs.getInt("price"),
                    rs.getInt("stock"),
                    rs.getString("category_name")
                );
                products.add(product);
            }
        }
        return products;
    }

    public Product findById(int id) throws SQLException {
        String query = "SELECT p.*, c.name AS category_name FROM product p LEFT JOIN category c ON p.category = c.id WHERE p.id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    Product product = new Product(
                        rs.getInt("id"),
                        rs.getString("path"),
                        rs.getString("name"),
                        rs.getInt("price"),
                        rs.getInt("stock"),
                        rs.getString("category_name")
                    );
                
                    return product;
                }
            }
        }
        return null;
    }

    public void create(Product product, int categoryId) throws SQLException {
        String query = "INSERT INTO product (id, path, name, price, stock, category) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setNull(1, 0);
            pstmt.setString(2, product.path);
            pstmt.setString(3, product.name);
            pstmt.setInt(4, product.price);
            pstmt.setInt(5, product.stock);
            pstmt.setInt(6, categoryId);
            pstmt.executeUpdate();
        }
    }

    public void update(Product product) throws SQLException {
        String query = "UPDATE product SET path = ?, name = ?, price = ?, stock = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, product.path);
            pstmt.setString(2, product.name);
            pstmt.setInt(3, product.price);
            pstmt.setInt(4, product.stock);
            pstmt.setInt(5, product.id);
            pstmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM product WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}