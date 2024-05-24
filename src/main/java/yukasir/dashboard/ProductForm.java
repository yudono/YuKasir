/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package yukasir.dashboard;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.filechooser.FileNameExtensionFilter;
import yukasir.Dashboard;
import yukasir.controller.CategoryController;
import yukasir.controller.ProductController;
import yukasir.model.Category;
import yukasir.model.Product;

/**
 *
 * @author Paideia
 */
public class ProductForm extends Page {

    int id = 0;
    ProductController controller;
    CategoryController categorycontroller;
    Dashboard context;
    List<Category> categories;
    int category = 0;
    String categoryName = "";
    String pathName;
    
    /**
     * Creates new form ProductForm
     */
    public ProductForm(Dashboard context) {
        initComponents();
        this.context = context;
        controller = new ProductController();
        categorycontroller = new CategoryController();
        
        try {
            categories = categorycontroller.getAll();
            for (Category category : categories) {
                categorySelect.addItem(category.getName());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductForm.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public void bind(String data){
        if(data != null){
            try {
                // get from binding
                Product product = controller.findById(Integer.parseInt(data));
                id = product.getId();
                name.setText(product.getName());
                stock.setText(Integer.toString(product.getStock()));
                price.setText(Integer.toString(product.getPrice()));
                categorySelect.setSelectedItem(product.getCategory());
                ImageIcon img = new ImageIcon(product.path);
                ImageIcon preview = new ImageIcon(img.getImage().getScaledInstance(240,240, Image.SCALE_SMOOTH));
                thumbnail.setIcon(preview);
            } catch (SQLException ex) {
                Logger.getLogger(CategoryForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        revalidate();
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filePicker = new javax.swing.JFileChooser();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        stock = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        thumbnail = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        categorySelect = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.CardLayout(24, 24));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(300, 32767));
        jPanel3.setMinimumSize(new java.awt.Dimension(300, 62));
        jPanel3.setPreferredSize(new java.awt.Dimension(300, 891));

        jLabel6.setText("Nama");

        price.setMaximumSize(new java.awt.Dimension(500, 40));
        price.setMinimumSize(new java.awt.Dimension(300, 40));
        price.setName(""); // NOI18N
        price.setPreferredSize(new java.awt.Dimension(200, 40));

        jLabel7.setText("Kategori");

        jLabel8.setText("Harga");

        name.setMaximumSize(new java.awt.Dimension(200, 40));
        name.setMinimumSize(new java.awt.Dimension(200, 40));
        name.setPreferredSize(new java.awt.Dimension(200, 40));

        jLabel9.setText("Stok");

        stock.setMaximumSize(new java.awt.Dimension(200, 40));
        stock.setMinimumSize(new java.awt.Dimension(200, 40));
        stock.setPreferredSize(new java.awt.Dimension(200, 40));

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(102, 102, 102));
        jButton5.setText("Cancel");
        jButton5.setBorderPainted(false);
        jButton5.setFocusPainted(false);
        jButton5.setMaximumSize(new java.awt.Dimension(100, 24));
        jButton5.setMinimumSize(new java.awt.Dimension(120, 30));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 102, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Submit");
        jButton4.setBorderPainted(false);
        jButton4.setFocusPainted(false);
        jButton4.setMaximumSize(new java.awt.Dimension(100, 24));
        jButton4.setMinimumSize(new java.awt.Dimension(120, 30));
        jButton4.setOpaque(true);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel10.setText("Foto Produk");

        thumbnail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        thumbnail.setMaximumSize(new java.awt.Dimension(240, 240));
        thumbnail.setMinimumSize(new java.awt.Dimension(240, 240));
        thumbnail.setPreferredSize(new java.awt.Dimension(240, 240));

        jButton3.setText("Choose File");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        categorySelect.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                categorySelectItemStateChanged(evt);
            }
        });
        categorySelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categorySelectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel7)
                    .addComponent(price, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(categorySelect, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(jLabel10)
                    .addComponent(thumbnail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(159, 159, 159))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jLabel7))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categorySelect, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(12, 12, 12)
                        .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(thumbnail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(532, Short.MAX_VALUE))
        );

        add(jPanel3, "card3");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        context.redirect("/product");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        filePicker.addChoosableFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png", "tif"));
        int result = filePicker.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            File file = filePicker.getSelectedFile();
            pathName = file.getAbsolutePath();
            ImageIcon img = new ImageIcon(pathName);
            ImageIcon preview = new ImageIcon(img.getImage().getScaledInstance(240,240, Image.SCALE_SMOOTH));
            thumbnail.setIcon(preview);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void categorySelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categorySelectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categorySelectActionPerformed

    private void categorySelectItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_categorySelectItemStateChanged
        // TODO add your handling code here:
        category = categories.get(categorySelect.getSelectedIndex()).getId();
        categoryName = categories.get(categorySelect.getSelectedIndex()).getName();
    }//GEN-LAST:event_categorySelectItemStateChanged

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String nama = name.getText();
        int harga = Integer.parseInt(price.getText());
        int stok = Integer.parseInt(stock.getText());
        
        try {
            if(id == 0){
                Product product = new Product(0,pathName, nama, harga, stok, categoryName);
                controller.create(product, category);
                showMessageDialog(null,"Success to create product","Success", INFORMATION_MESSAGE);
            }else{
                Product product = new Product(id,pathName, nama, harga, stok, categoryName);
                controller.update(product);
                showMessageDialog(null,"Success to update product","Success", INFORMATION_MESSAGE);
            }
            context.redirect("/product");
        } catch (SQLException ex) {
            showMessageDialog(null,"Failed to create product","Error", ERROR_MESSAGE);
            Logger.getLogger(ProductForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> categorySelect;
    private javax.swing.JFileChooser filePicker;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField name;
    private javax.swing.JTextField price;
    private javax.swing.JTextField stock;
    private javax.swing.JLabel thumbnail;
    // End of variables declaration//GEN-END:variables
}
