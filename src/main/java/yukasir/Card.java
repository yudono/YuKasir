/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package yukasir;

import yukasir.model.Product;
import java.awt.Color;
import java.awt.Image;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.ImageIcon;

/**
 *
 * @author Paideia
 */
public class Card extends javax.swing.JPanel {

    /**
     * Creates new form Card
     */
    public Card() {
        initComponents();
    }
    
    public void setProduct(Product product){
        URL resource = getClass().getResource(product.path);
        if (resource != null) {
            ImageIcon img = new ImageIcon(resource);
            ImageIcon preview = new ImageIcon(img.getImage().getScaledInstance(300,300, Image.SCALE_DEFAULT));
            thumbnail.setIcon(preview);
        }else{
            ImageIcon img = new ImageIcon(product.path);
            ImageIcon preview = new ImageIcon(img.getImage().getScaledInstance(300,300, Image.SCALE_DEFAULT));
            thumbnail.setIcon(preview);
        }
        productName.setText(product.name);
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.GERMANY);
        hrg.setText("Rp"+numberFormat.format(product.price));
    }
    
    public void setEmpty(){
        thumbnail.setIcon(null);
        productName.setText("");
        hrg.setText("");
        jPanel1.setBackground(new java.awt.Color(204, 225, 221));
        jPanel2.setBackground(new java.awt.Color(204, 225, 221));
        jPanel3.setBackground(new java.awt.Color(204, 225, 221));
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
        jPanel3 = new javax.swing.JPanel();
        thumbnail = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        productName = new javax.swing.JLabel();
        hrg = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 225, 221));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new java.awt.CardLayout(12, 12));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        thumbnail.setBackground(new java.awt.Color(255, 255, 255));
        thumbnail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image-1.jpg"))); // NOI18N
        thumbnail.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        thumbnail.setPreferredSize(new java.awt.Dimension(200, 200));
        jPanel3.add(thumbnail);

        jPanel1.add(jPanel3);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        jPanel2.setMaximumSize(new java.awt.Dimension(600, 49));

        productName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        productName.setText("Chicken Katsu");
        productName.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        hrg.setText("Rp 0");
        hrg.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(productName)
            .addComponent(hrg)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(productName)
                .addGap(0, 0, 0)
                .addComponent(hrg))
        );

        jPanel1.add(jPanel2);

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hrg;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel productName;
    private javax.swing.JLabel thumbnail;
    // End of variables declaration//GEN-END:variables
}
