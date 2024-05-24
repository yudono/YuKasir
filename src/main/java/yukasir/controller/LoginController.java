/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package yukasir.controller;

import java.sql.*;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import org.mindrot.jbcrypt.BCrypt;
import yukasir.model.User;

/**
 *
 * @author Paideia
 */
public class LoginController extends BaseController{
    
    public LoginController(){
        super();
    }
    
     public User login(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ?";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String hashedPassword = rs.getString("password");
                // Verify the password using BCrypt
                boolean isValid = BCrypt.checkpw(password, hashedPassword);
                if(isValid){
                    User user = new User();
                    user.fromResult(rs);
                    return user;
                }
            }
        } catch (SQLException e) {
            String errorMessage = e.getClass().getName() + ": " + e.getMessage();
            System.out.println(errorMessage);
            showMessageDialog(null,errorMessage,"Error", ERROR_MESSAGE);
        }
        return null;
    }
    
}
