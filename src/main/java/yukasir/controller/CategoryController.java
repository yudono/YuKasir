/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yukasir.controller;

/**
 *
 * @author Paideia
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import yukasir.model.Category;

public class CategoryController extends BaseController{

    public CategoryController() {
        super();
    }

    // Method to get all categories
    public List<Category> getAll() throws SQLException {
        List<Category> categories = new ArrayList<>();
        String query = "SELECT * FROM category";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Category category = new Category(
                    rs.getInt("id"),
                    rs.getString("name")
                );
                categories.add(category);
            }
        }
        return categories;
    }

    // Method to find a category by its id
    public Category findById(int id) throws SQLException {
        String query = "SELECT * FROM category WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Category(
                        rs.getInt("id"),
                        rs.getString("name")
                    );
                }
            }
        }
        return null;
    }

    // Method to create a new category
    public void create(Category category) throws SQLException {
        String query = "INSERT INTO category (id, name) VALUES (?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setNull(1, 0);
            pstmt.setString(2, category.getName());
            pstmt.executeUpdate();
        }
    }

    // Method to update an existing category
    public void update(Category category) throws SQLException {
        String query = "UPDATE category SET name = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, category.getName());
            pstmt.setInt(2, category.getId());
            pstmt.executeUpdate();
        }
    }

    // Method to delete a category by its id
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM category WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}