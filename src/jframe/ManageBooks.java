/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
/**
 *
 * @author ANOKYE
 */
public class ManageBooks extends javax.swing.JFrame {

    /**
     * Creates new form ManageBooks
     */
    //Connection conn = DBConnection.getConnect();
    PreparedStatement pst = null;
    ResultSet rs = null;
    DefaultTableModel model;
    
    
    
    public ManageBooks() {
        initComponents();
        setBookDetailsToTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
     public void setBookDetailsToTable(){
       
           int book_id ;
           String book_name;
           String author;
           int quantity;
           
       try{
          
           Connection conn = DBConnection.getConnect();
           String sql = "SELECT * FROM book_details";
           pst = conn.prepareStatement(sql);
           rs = pst.executeQuery();
           
           while(rs.next()){
             book_id = rs.getInt("book_id");
             book_name = rs.getString("book_name");
             author = rs.getString("author");
             quantity = rs.getInt("quantity");
             
             Object[] obj = {book_id,book_name,author,quantity};
             model = (DefaultTableModel)tblmanagebooks.getModel();
             model.addRow(obj);
           }
       
       }catch(Exception ex){
         ex.printStackTrace();
       }    
    
    
    }
     //Add Book to book_details
     public boolean addBook(){
          
          boolean isAdded = false;
          int bookId = Integer.parseInt(txtbook_id.getText());
          String bookName = txtbook_name.getText();
          String author  = txtauthor.getText();
          int quantity = Integer.parseInt(txtquantity.getText());
         
          
          try{
              
             Connection conn = null;
             conn = DBConnection.getConnect();
             String sql = "INSERT INTO book_details(book_id,book_name,author,quantity) VALUES (?,?,?,?)";
             pst = conn.prepareStatement(sql);
             
             pst.setInt(1, bookId);
             pst.setString(2, bookName);
             pst.setString(3, author);
             pst.setInt(4, quantity);
             
             int rowCount = pst.executeUpdate();
             if(rowCount > 0){
                 JOptionPane.showMessageDialog(this, "Record Added Successfully");
                 isAdded = true;
             }
             else{
                 JOptionPane.showMessageDialog(this, "Fail to Add Record");
                 isAdded = false;
                 
              }
          
          }catch(Exception ex){
             ex.printStackTrace();
          }
            return isAdded;
     }
     //update Book details
     public boolean updateBook(){
       boolean isUpdated = false;
          int bookId = Integer.parseInt(txtbook_id.getText());
          String bookName = txtbook_name.getText();
          String author  = txtauthor.getText();
          int quantity = Integer.parseInt(txtquantity.getText());
          
       try{
             Connection conn = null;
             conn = DBConnection.getConnect();
             String sql = "UPDATE book_details SET book_name = ?, author = ?, quantity = ? WHERE book_id = ?";
             pst = conn.prepareStatement(sql);
             
             pst.setString(1, bookName);
             pst.setString(2, author);
             pst.setInt(3, quantity);
             pst.setInt(4, bookId);
             
             int rowCount = pst.executeUpdate();
             if(rowCount > 0){
                
                 isUpdated = true;
             }
             else{
                 isUpdated = false;
             }
       
       
       }catch(Exception ex){
          ex.printStackTrace();
          
       }
     
       return isUpdated;
     }
     
     public boolean deleteBook(){
         boolean isDeleted = false;
       
         int bookId = Integer.parseInt(txtbook_id.getText());
       
       try{
           Connection conn = DBConnection.getConnect();
           pst = conn.prepareStatement("DELETE FROM book_details WHERE book_id = ?");
           pst.setInt(1, bookId);
           
           
           int rowCount = pst.executeUpdate();
           if(rowCount > 0){
              JOptionPane.showMessageDialog(this, "Record Deleted Successfully");
              isDeleted = true;
              
           }
           else{
                JOptionPane.showMessageDialog(this, "Record Deleted Successfully");
                isDeleted = false;
           }
           
           
       }catch(Exception ex){
          ex.printStackTrace();
       }
     
       return isDeleted;
     
     }
    // public boolean validateBook(){
     
     
     
     
     
     
     //}
     //method to clear table for manage books
     public void clearTable(){
         DefaultTableModel model = (DefaultTableModel)tblmanagebooks.getModel();
         model.setRowCount(0);
     
     
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtbook_id = new app.bolivia.swing.JCTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtbook_name = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtauthor = new app.bolivia.swing.JCTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtquantity = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        btndelete = new rojerusan.RSMaterialButtonCircle();
        btnadd = new rojerusan.RSMaterialButtonCircle();
        btnupdate = new rojerusan.RSMaterialButtonCircle();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblmanagebooks = new rojeru_san.complementos.RSTableMetro();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Rockwell", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 50));

        jLabel5.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Enter Book Id");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 100, -1));

        txtbook_id.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 255)));
        txtbook_id.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        txtbook_id.setPlaceholder("Enter Book Id");
        txtbook_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtbook_idFocusLost(evt);
            }
        });
        jPanel1.add(txtbook_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 260, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 40, 60));

        jLabel6.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Enter Book Name");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 120, -1));

        txtbook_name.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 255)));
        txtbook_name.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        txtbook_name.setPlaceholder("Enter Book name");
        txtbook_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtbook_nameFocusLost(evt);
            }
        });
        jPanel1.add(txtbook_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 260, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, 60));

        jLabel7.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Author Name");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 100, -1));

        txtauthor.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 255)));
        txtauthor.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        txtauthor.setPlaceholder("Enter Author name");
        txtauthor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtauthorFocusLost(evt);
            }
        });
        jPanel1.add(txtauthor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 260, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, 60));

        jLabel11.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Quantity");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 100, -1));

        txtquantity.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(255, 255, 255)));
        txtquantity.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        txtquantity.setPlaceholder("Enter Quantity");
        txtquantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtquantityFocusLost(evt);
            }
        });
        jPanel1.add(txtquantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 260, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, -1, 50));

        btndelete.setBackground(new java.awt.Color(255, 51, 51));
        btndelete.setText("DELETE");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 100, 60));

        btnadd.setBackground(new java.awt.Color(255, 51, 51));
        btnadd.setText("ADD");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        jPanel1.add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 100, 60));

        btnupdate.setBackground(new java.awt.Color(255, 51, 51));
        btnupdate.setText("UPDATE");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 100, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 520));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("x");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 70, 30));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 90, 50));

        tblmanagebooks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", "Name", "Author", "Quantity"
            }
        ));
        tblmanagebooks.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tblmanagebooks.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tblmanagebooks.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tblmanagebooks.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblmanagebooks.setRowHeight(40);
        tblmanagebooks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblmanagebooksMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblmanagebooks);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 500, 210));

        jLabel3.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel3.setText("  Manage Books");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 230, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 600, 520));

        setSize(new java.awt.Dimension(950, 520));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        HomePage hPage = new HomePage();
        hPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txtbook_idFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtbook_idFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbook_idFocusLost

    private void txtbook_nameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtbook_nameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbook_nameFocusLost

    private void txtauthorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtauthorFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtauthorFocusLost

    private void txtquantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtquantityFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtquantityFocusLost

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void tblmanagebooksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblmanagebooksMouseClicked
        // TODO add your handling code here:
        int rowNo = tblmanagebooks.getSelectedRow();
        TableModel model = tblmanagebooks.getModel();
        
        txtbook_id.setText(model.getValueAt(rowNo, 0).toString());
        txtbook_name.setText(model.getValueAt(rowNo, 1).toString());
        txtauthor.setText(model.getValueAt(rowNo, 2).toString());
        txtquantity.setText(model.getValueAt(rowNo, 3).toString());
         
    }//GEN-LAST:event_tblmanagebooksMouseClicked

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
         if(addBook()){
            JOptionPane.showMessageDialog(this, "Record Add Successfully");
            clearTable();
            setBookDetailsToTable();
            
            txtbook_id.setText("");
            txtbook_name.setText("");
            txtauthor.setText("");
            txtquantity.setText("");
         } 
         else{
            JOptionPane.showMessageDialog(this, "Failed to Add redcord");          
         }
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        if(updateBook()){
            JOptionPane.showMessageDialog(this, "Update Successfull");
            clearTable();
            setBookDetailsToTable();
        }
        else{
            JOptionPane.showMessageDialog(this, "Update failed");
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        if(deleteBook()){
           JOptionPane.showMessageDialog(this, "Record Deleted");
           clearTable(); 
           setBookDetailsToTable();
        }
        else{
            JOptionPane.showMessageDialog(this, "Record Deletion Fail");
        }
    }//GEN-LAST:event_btndeleteActionPerformed

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
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle btnadd;
    private rojerusan.RSMaterialButtonCircle btndelete;
    private rojerusan.RSMaterialButtonCircle btnupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private rojeru_san.complementos.RSTableMetro tblmanagebooks;
    private app.bolivia.swing.JCTextField txtauthor;
    private app.bolivia.swing.JCTextField txtbook_id;
    private app.bolivia.swing.JCTextField txtbook_name;
    private app.bolivia.swing.JCTextField txtquantity;
    // End of variables declaration//GEN-END:variables
}
