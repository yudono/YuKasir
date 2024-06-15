/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lib;

/**
 *
 * @author Paideia
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomTableRenderer extends JPanel {
    private JTable table;

    public CustomTableRenderer(String[] columns, List<String[]> data) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Create table model
        DefaultTableModel model = new DefaultTableModel(data.toArray(new Object[0][0]), columns);

        // Create JTable with the created model
        table = new JTable(model);
        table.setBackground(Color.WHITE);
        table.setGridColor(new Color(255, 255, 255)); // Adjust grid color to match jPanel3 border color

        // Customize table rendering if needed (alignment, font, etc.)
        customizeTableRendering();

        // Set up JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBackground(Color.WHITE);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(1, 24, 1, 24));
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        add(scrollPane, BorderLayout.CENTER);
    }

    private void customizeTableRendering() {
        // Example customization:
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        table.getTableHeader().setBackground(Color.WHITE);
        table.getTableHeader().setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(244, 244, 244)));

        // Adjust row height if needed
        table.setRowHeight(30);

        // Adjust alignment of data in cells
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.LEFT); // Adjust alignment as per your needs
        table.getColumnModel().getColumn(0).setCellRenderer(renderer); // Adjust column index as per your data
    }

}
