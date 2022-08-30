/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;


import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
/**
 *
 * @author ANOKYE
 */
public class SignupPage extends javax.swing.JFrame {

    /**
     * Creates new form SignupPage
     */
    public SignupPage() {
        initComponents();
    }
    
    //method to insert values into users table
    public void insertsignupdetail(){
      String username = txtusername.getText();
      String password = String.valueOf(txtpassword.getPassword());
      String email = txtemail.getText();
      String contact = txtcontact.getText();
      
      try{
           Connection conn = DBConnection.getConnect();
           PreparedStatement pst = null;
           String sql = "INSERT INTO users(name,password,email,contact) VALUES(?,?,?,?)";
           pst = conn.prepareStatement(sql);
           
           pst.setString(1, username);
           pst.setString(2, password);
           pst.setString(3, email);
           pst.setString(4, contact);
           
           int updatedRowCount =  pst.executeUpdate();
           
           if(updatedRowCount > 0){
               JOptionPane.showMessageDialog(this, "Record inserted Successfully");
           }
           else{
               JOptionPane.showMessageDialog(this, "Record insertion Failed");
           }
      
      }
      catch(Exception ex){
          ex.printStackTrace();
      }
    
    
    }
    //validation of signup
    public boolean validateSignup(){
       String username = txtusername.getText();
       String password  = String.valueOf(txtpassword.getPassword());
       String email = txtemail.getText();
       String contact = txtcontact.getText();
       
       if(username.equals("")){
          JOptionPane.showMessageDialog(this, "username cannot be empty");
          return false;
       }
       // validate password
       if(password.equals("")){
          JOptionPane.showMessageDialog(this, "password cannot be empty");
          return false;
       }
       //email validation
       if(email.equals("")){
          JOptionPane.showMessageDialog(this, "email cannot be empty");
          return false; 
       }  
        if(!email.matches("^[a-zA-Z0-9]{1,}[@][a-zA-Z]{3,}[.][a-zA-Z]$")){
          JOptionPane.showMessageDialog(this, "Enter a valid email");   
          return false;
        }  
       
       //validate contact
       
       if(contact.equals("")){
          JOptionPane.showMessageDialog(this, "cannot cannot be empty");
          return false;
       }
       if(!contact.matches("^[0-9]{3,}$")){
          JOptionPane.showMessageDialog(this, "Contact must be digit only");   
          return false;
        }  

       else{ 
           return true;
       }
    
    }
 
//check duplicate users
    public boolean checkDuplicateUser(){
      
        String username = txtusername.getText();
        boolean isExist = false;
        
        try{
        
            Connection conn = DBConnection.getConnect();
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM users WHERE name = ?");
            pst.setString(1, username);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
               isExist = true;
            }
            else{
                isExist = false;
            }
        
           
           
        }catch(Exception ex){
           ex.printStackTrace();
        }
    
         return isExist; 
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtusername = new app.bolivia.swing.JCTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtemail = new app.bolivia.swing.JCTextField();
        jLabel13 = new javax.swing.JLabel();
        txtcontact = new app.bolivia.swing.JCTextField();
        jLabel14 = new javax.swing.JLabel();
        btnlogin = new rojerusan.RSMaterialButtonCircle();
        btnsignup1 = new rojerusan.RSMaterialButtonCircle();
        txtpassword = new javax.swing.JPasswordField();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Yaw Warez");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, -1));

        jLabel2.setFont(new java.awt.Font("Rockwell Condensed", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 255));
        jLabel2.setText("Advance Library");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 150, -1));

        jLabel3.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setText("Welcome To");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 110, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/signup-library-icon.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 680, 460));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 600));

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Username");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 100, -1));

        jLabel6.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("X");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 60, -1));

        jLabel7.setFont(new java.awt.Font("Rockwell", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Create New Account");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 250, -1));

        txtusername.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 255)));
        txtusername.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        txtusername.setPlaceholder("Enter Username");
        txtusername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtusernameFocusLost(evt);
            }
        });
        jPanel2.add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 260, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 60));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons8_Secure_50px.png"))); // NOI18N
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 60));

        jLabel10.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Password");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 100, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons8_Secured_Letter_50px.png"))); // NOI18N
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, 60));

        jLabel12.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Email");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 100, -1));

        txtemail.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 255)));
        txtemail.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        txtemail.setPlaceholder("Enter Email");
        jPanel2.add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 260, 30));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons8_Google_Mobile_50px.png"))); // NOI18N
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, 60));

        txtcontact.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 255)));
        txtcontact.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        txtcontact.setPlaceholder("Enter  contact");
        jPanel2.add(txtcontact, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 260, 30));

        jLabel14.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Contact");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 100, -1));

        btnlogin.setBackground(new java.awt.Color(51, 0, 255));
        btnlogin.setText("LOGIN");
        btnlogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloginActionPerformed(evt);
            }
        });
        jPanel2.add(btnlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 520, 210, 60));

        btnsignup1.setBackground(new java.awt.Color(255, 51, 51));
        btnsignup1.setLabel("Signup");
        btnsignup1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsignup1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnsignup1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 210, 60));

        txtpassword.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 255)));
        jPanel2.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 260, 30));

        jLabel15.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Signup Page");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 150, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 0, 450, 600));

        setSize(new java.awt.Dimension(1103, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloginActionPerformed
        // TODO add your handling code here:
        LoginPage login = new LoginPage();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnloginActionPerformed

    private void btnsignup1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsignup1ActionPerformed
        // TODO add your handling code here:
       if(validateSignup()== true){
           if(checkDuplicateUser() == false){
             insertsignupdetail();
             LoginPage lPage = new LoginPage();
             lPage.setVisible(true);
             dispose();
           }
           else{
              JOptionPane.showMessageDialog(this, "username already exist");
           }
       } 
       
        
    }//GEN-LAST:event_btnsignup1ActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void txtusernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtusernameFocusLost
        // TODO add your handling code here:
        if(checkDuplicateUser() == true){
           JOptionPane.showMessageDialog(this, "Username already exist");
        }
    }//GEN-LAST:event_txtusernameFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignupPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignupPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle btnlogin;
    private rojerusan.RSMaterialButtonCircle btnsignup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private app.bolivia.swing.JCTextField txtcontact;
    private app.bolivia.swing.JCTextField txtemail;
    private javax.swing.JPasswordField txtpassword;
    private app.bolivia.swing.JCTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
