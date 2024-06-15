/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package yukasir;

import com.google.gson.Gson;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import yukasir.dashboard.Categories;
import yukasir.dashboard.CategoryForm;
import yukasir.dashboard.Home;
import yukasir.dashboard.Page;
import yukasir.dashboard.ProductForm;
import yukasir.dashboard.Products;
import yukasir.dashboard.Transactions;
import yukasir.model.User;

/**
 *
 * @author Paideia
 */
public class Dashboard extends javax.swing.JFrame {

    Gson gson = new Gson();
    
    public String data;
    
    Page home = new Home(this);
    Page product = new Products(this);
    Page productForm = new ProductForm(this);
    Page category = new Categories(this);
    Page categoryForm = new CategoryForm(this);
    Page transaction = new Transactions(this);
    
    
   HashMap<String, Page> panelsMap = new HashMap<>(){{
        put("/dashboard", home);
        put("/product", product);
        put("/product/form", productForm);
        put("/category", category);
        put("/category/form", categoryForm);
        put("/transaction",transaction);
    }};
    
    /**
     * Creates new form Dashboard
     */
    public Dashboard() {
        initComponents();
        
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        
        var auth = LocalStorage.getData("auth");
        if(auth != null){
            User user = gson.fromJson(auth, User.class);
            userName.setText(user.getName());
            userRole.setText(user.getRole());
            if("admin".equals(user.getRole())){
                productBtn.setVisible(true);
                categoryBtn.setVisible(true);
                usersBtn.setVisible(false);
                reportBtn.setVisible(false);
            } else if("manager".equals(user.getRole())){
                productBtn.setVisible(false);
                categoryBtn.setVisible(false);
                usersBtn.setVisible(true);
                reportBtn.setVisible(true);
            }
        }
        
//        wrapper.getVerticalScrollBar().setUI(new CustomScrollBarUI(10));
//        wrapper.getHorizontalScrollBar().setUI(new CustomScrollBarUI(10));
        
        addMouseListenerToButton(dashboardBtn,"/dashboard");
        addMouseListenerToButton(productBtn,"/product");
        addMouseListenerToButton(categoryBtn,"/category");
        addMouseListenerToButton(transactionBtn,"/transaction");
        addMouseListenerToButton(usersBtn,"/users");
        addMouseListenerToButton(reportBtn,"/report");
        addMouseListenerToButton(logoutBtn,"/logout");
        
        redirect("/dashboard");
    }
    
     private void addMouseListenerToButton(JPanel panel,String path) {
        panel.addMouseListener(new MouseAdapter() {
            
            @Override
            public void mousePressed(MouseEvent e) {
                
                if(path.equals("/logout")){
                    LocalStorage.removeData("auth");
                    
                    Login login = new Login();
                    login.setVisible(true);
                    
                    setVisible(false);
                    dispose();
                }
                
                redirect(path);
            }
            
            @Override
            public void mouseEntered(MouseEvent e) {
                mouseHoverSideMenu(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseExitSideMenu(e);
            }
        });
    }
    
    public void redirect(String path, String data){        
        Page panel = panelsMap.get(path);
        if(panel != null){
            panel.bind(data);
            container.removeAll();
            container.add(panel);
            container.revalidate();
            container.repaint();
        }
    }
     
    public void redirect(String path){        
        Page panel = panelsMap.get(path);
        if(panel != null){
            container.removeAll();
            container.add(panel);
            container.revalidate();
            container.repaint();
        }
    }
    
    private void mouseHoverSideMenu(MouseEvent evt){
        evt.getComponent().setBackground(new java.awt.Color(235,235,235));
    }
    
    private void mouseExitSideMenu(MouseEvent evt){
        evt.getComponent().setBackground(new java.awt.Color(255,255,255));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidebar = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dashboardBtn = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        productBtn = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        categoryBtn = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        transactionBtn = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        usersBtn = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        reportBtn = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        navbar = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        userName = new javax.swing.JLabel();
        userRole = new javax.swing.JLabel();
        container = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.X_AXIS));

        sidebar.setBackground(new java.awt.Color(255, 255, 255));
        sidebar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 1, new java.awt.Color(242, 242, 242)));
        sidebar.setForeground(new java.awt.Color(51, 51, 51));
        sidebar.setMaximumSize(new java.awt.Dimension(300, 32767));
        sidebar.setPreferredSize(new java.awt.Dimension(300, 525));
        sidebar.setLayout(new java.awt.CardLayout(24, 24));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.Y_AXIS));

        jPanel5.setMaximumSize(new java.awt.Dimension(32767, 56));
        jPanel5.setOpaque(false);
        jPanel5.setPreferredSize(new java.awt.Dimension(252, 56));

        logo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo-75x.png"))); // NOI18N
        logo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        logo.setIconTextGap(0);
        logo.setMaximumSize(new java.awt.Dimension(300, 60));
        logo.setMinimumSize(new java.awt.Dimension(300, 60));
        logo.setPreferredSize(new java.awt.Dimension(300, 60));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Jualin POS");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(0, 109, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel5);

        dashboardBtn.setBackground(new java.awt.Color(255, 255, 255));
        dashboardBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dashboardBtn.setMaximumSize(new java.awt.Dimension(300, 48));
        dashboardBtn.setMinimumSize(new java.awt.Dimension(300, 48));
        dashboardBtn.setPreferredSize(new java.awt.Dimension(300, 48));
        dashboardBtn.setRequestFocusEnabled(false);
        dashboardBtn.setLayout(new java.awt.CardLayout(12, 12));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon-pack/png-24px/home-outline.png"))); // NOI18N
        jLabel11.setText("Dashboard");
        dashboardBtn.add(jLabel11, "card2");

        jPanel4.add(dashboardBtn);

        productBtn.setBackground(new java.awt.Color(255, 255, 255));
        productBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        productBtn.setMaximumSize(new java.awt.Dimension(300, 48));
        productBtn.setMinimumSize(new java.awt.Dimension(300, 48));
        productBtn.setPreferredSize(new java.awt.Dimension(300, 48));
        productBtn.setRequestFocusEnabled(false);
        productBtn.setLayout(new java.awt.CardLayout(12, 12));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon-pack/png-24px/folder.png"))); // NOI18N
        jLabel10.setText("Product");
        productBtn.add(jLabel10, "card2");

        jPanel4.add(productBtn);

        categoryBtn.setBackground(new java.awt.Color(255, 255, 255));
        categoryBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        categoryBtn.setMaximumSize(new java.awt.Dimension(300, 48));
        categoryBtn.setMinimumSize(new java.awt.Dimension(300, 48));
        categoryBtn.setPreferredSize(new java.awt.Dimension(300, 48));
        categoryBtn.setRequestFocusEnabled(false);
        categoryBtn.setLayout(new java.awt.CardLayout(12, 12));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon-pack/png-24px/tag.png"))); // NOI18N
        jLabel5.setText("Category");
        categoryBtn.add(jLabel5, "card2");

        jPanel4.add(categoryBtn);

        transactionBtn.setBackground(new java.awt.Color(255, 255, 255));
        transactionBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        transactionBtn.setMaximumSize(new java.awt.Dimension(300, 48));
        transactionBtn.setMinimumSize(new java.awt.Dimension(300, 48));
        transactionBtn.setPreferredSize(new java.awt.Dimension(300, 48));
        transactionBtn.setRequestFocusEnabled(false);
        transactionBtn.setLayout(new java.awt.CardLayout(12, 12));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon-pack/png-24px/shopping-cart.png"))); // NOI18N
        jLabel6.setText("Transaction");
        transactionBtn.add(jLabel6, "card2");

        jPanel4.add(transactionBtn);

        usersBtn.setBackground(new java.awt.Color(255, 255, 255));
        usersBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        usersBtn.setMaximumSize(new java.awt.Dimension(300, 48));
        usersBtn.setMinimumSize(new java.awt.Dimension(300, 48));
        usersBtn.setPreferredSize(new java.awt.Dimension(300, 48));
        usersBtn.setRequestFocusEnabled(false);
        usersBtn.setLayout(new java.awt.CardLayout(12, 12));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon-pack/png-24px/user-outline.png"))); // NOI18N
        jLabel8.setText("Users");
        usersBtn.add(jLabel8, "card2");

        jPanel4.add(usersBtn);

        reportBtn.setBackground(new java.awt.Color(255, 255, 255));
        reportBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reportBtn.setMaximumSize(new java.awt.Dimension(300, 48));
        reportBtn.setMinimumSize(new java.awt.Dimension(300, 48));
        reportBtn.setPreferredSize(new java.awt.Dimension(300, 48));
        reportBtn.setRequestFocusEnabled(false);
        reportBtn.setLayout(new java.awt.CardLayout(12, 12));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon-pack/png-24px/chart-bar-outline.png"))); // NOI18N
        jLabel9.setText("Report");
        reportBtn.add(jLabel9, "card2");

        jPanel4.add(reportBtn);

        logoutBtn.setBackground(new java.awt.Color(255, 255, 255));
        logoutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutBtn.setMaximumSize(new java.awt.Dimension(300, 48));
        logoutBtn.setMinimumSize(new java.awt.Dimension(300, 48));
        logoutBtn.setPreferredSize(new java.awt.Dimension(300, 48));
        logoutBtn.setRequestFocusEnabled(false);
        logoutBtn.setLayout(new java.awt.CardLayout(12, 12));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon-pack/png-24px/eject.png"))); // NOI18N
        jLabel7.setText("Logout");
        logoutBtn.add(jLabel7, "card2");

        jPanel4.add(logoutBtn);

        sidebar.add(jPanel4, "card2");

        getContentPane().add(sidebar);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        navbar.setBackground(new java.awt.Color(255, 255, 255));
        navbar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(242, 242, 242)));
        navbar.setMaximumSize(new java.awt.Dimension(32767, 60));
        navbar.setMinimumSize(new java.awt.Dimension(300, 0));
        navbar.setPreferredSize(new java.awt.Dimension(611, 60));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Dashboard");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/avatar.png"))); // NOI18N

        userName.setText("Yudono");

        userRole.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        userRole.setText("Admin");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userName)
                    .addComponent(userRole))
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userRole)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout navbarLayout = new javax.swing.GroupLayout(navbar);
        navbar.setLayout(navbarLayout);
        navbarLayout.setHorizontalGroup(
            navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, navbarLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 349, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        navbarLayout.setVerticalGroup(
            navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(navbarLayout.createSequentialGroup()
                .addGroup(navbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, navbarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, navbarLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(navbar);

        container.setBackground(new java.awt.Color(255, 255, 255));
        container.setLayout(new java.awt.CardLayout());
        jPanel3.add(container);

        getContentPane().add(jPanel3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseEntered

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Dashboard().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel categoryBtn;
    private javax.swing.JPanel container;
    private javax.swing.JPanel dashboardBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel logoutBtn;
    private javax.swing.JPanel navbar;
    private javax.swing.JPanel productBtn;
    private javax.swing.JPanel reportBtn;
    private javax.swing.JPanel sidebar;
    private javax.swing.JPanel transactionBtn;
    private javax.swing.JLabel userName;
    private javax.swing.JLabel userRole;
    private javax.swing.JPanel usersBtn;
    // End of variables declaration//GEN-END:variables
}
