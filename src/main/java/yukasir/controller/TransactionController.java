package yukasir.controller;

import yukasir.model.Transaction;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import yukasir.model.Transaction;

public class TransactionController extends BaseController{

    public TransactionController() {
        super();
    }

    public List<Transaction> getAll() throws SQLException {
        List<Transaction> transactions = new ArrayList<>();
        String query = "SELECT t.id,t.invoice,p.name as product,t.quantity,t.total,t.change,t.timestamp  FROM transactions t JOIN product p ON t.productid = p.id";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Transaction transaction = new Transaction(
                    rs.getInt("id"),
                    rs.getString("invoice"),
                    rs.getString("product"),
                    rs.getInt("quantity"),
                    rs.getDouble("total"),
                    rs.getDouble("change"),
                    rs.getTimestamp("timestamp")
                );
                transactions.add(transaction);
            }
        }
        return transactions;
    }

    public void create(String invoice,int productid, int quantity, double total, double change) throws SQLException {
        String query = "INSERT INTO transactions (invoice, productid, quantity, total, change) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, invoice);
            pstmt.setInt(2, productid);
            pstmt.setInt(3, quantity);
            pstmt.setDouble(4, total);
            pstmt.setDouble(5, change);
            pstmt.executeUpdate();
        }
    }
}
