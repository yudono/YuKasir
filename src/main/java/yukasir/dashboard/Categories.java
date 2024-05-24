/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package yukasir.dashboard;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import yukasir.Dashboard;
import yukasir.controller.CategoryController;
import yukasir.model.Category;
/**
 *
 * @author Paideia
 */
public class Categories extends Page {

    Dashboard context;
    DefaultTableModel model;
    CategoryController controller;
    /**
     * Creates new form Category
     */
    public Categories(Dashboard context) {
        initComponents();
        this.context = context;
        
        String[] columnNames = {"No", "Name", "Edit", "Delete"};
        model = new DefaultTableModel(columnNames, 0);
        table.setModel(model);
        table.getColumnModel().getColumn(2).setCellRenderer((table, value, isSelected, hasFocus, row, column) -> {
            JButton button = new JButton("Edit");
            button.setFocusPainted(false);
            return button;
        });
        table.getColumnModel().getColumn(3).setCellRenderer((table, value, isSelected, hasFocus, row, column) -> {
            JButton button = new JButton("Delete");
            return button;
        });
        table.getColumnModel().getColumn(2).setMaxWidth(80);
        table.getColumnModel().getColumn(3).setMaxWidth(80);
        table.setCellSelectionEnabled(false);
        
        populateTable();
    }
    
    public void bind(String data){
        revalidate();
        repaint();
    }
    
    private void populateTable() {
        model.setRowCount(0);
        try {
            controller = new CategoryController();
            List<Category> categories = controller.getAll();
            
            int no = 1;
            for (Category category : categories) {
                model.addRow(new Object[]{no, category.getName()});
                no++;
            }
            
            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent evt){
                    int row = table.rowAtPoint(evt.getPoint());
                    int col = table.columnAtPoint(evt.getPoint());
                    if (row >= 0 && col >= 0) {
                        if(col == 2){
                            // tombol edit
                            context.redirect("/category/form", Integer.toString(categories.get(row).getId()));
                        }else if(col == 3){
                            // tombol hapus
                            int dialogResult = JOptionPane.showConfirmDialog (null, "Want to delete this category?","Confirmation",YES_NO_OPTION);
                            if(dialogResult == 0){
                                try {
                                    controller.delete(categories.get(row).getId());
                                    populateTable();
                                } catch (SQLException ex) {
                                    showMessageDialog(null,"Failed to delete category","Error", ERROR_MESSAGE);
                                }
                            }
                        }
                    }
                }
            });
            
        } catch (SQLException ex) {
            // Handle SQL exception
            ex.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        refresh = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.CardLayout(48, 48));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        refresh.setText("refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        jPanel2.add(refresh);

        jButton1.setText("Tambah Kategori");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        jPanel1.add(jPanel2);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        table.setEnabled(false);
        table.setRowHeight(40);
        table.setRowMargin(12);
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1);

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        context.redirect("/category/form");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
        populateTable();
    }//GEN-LAST:event_refreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refresh;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

}