/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Login extends javax.swing.JFrame {
    
    
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tfUsername = new javax.swing.JTextField();
        tfPassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnSignIn = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnSignUP = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(null);

        jLabel2.setText("Password");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(150, 130, 80, 14);

        jLabel1.setText("UserName");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(150, 70, 90, 14);
        jPanel1.add(tfUsername);
        tfUsername.setBounds(110, 90, 140, 30);
        jPanel1.add(tfPassword);
        tfPassword.setBounds(110, 150, 140, 30);

        jLabel3.setFont(new java.awt.Font("Adobe Garamond Pro Bold", 0, 18)); // NOI18N
        jLabel3.setText("LOGIN");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(140, 20, 90, 30);

        jPanel2.setBackground(new java.awt.Color(51, 51, 255));
        jPanel2.setLayout(null);
        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 400, 60);

        btnSignIn.setText("SIGN IN");
        btnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInActionPerformed(evt);
            }
        });
        jPanel1.add(btnSignIn);
        btnSignIn.setBounds(223, 200, 80, 23);

        btnExit.setText("EXIT");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit);
        btnExit.setBounds(150, 200, 55, 23);

        btnSignUP.setText("SIGN UP");
        btnSignUP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUPActionPerformed(evt);
            }
        });
        jPanel1.add(btnSignUP);
        btnSignUP.setBounds(50, 200, 80, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 410, 260);

        setBounds(0, 0, 379, 297);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignUPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUPActionPerformed
        String username = tfUsername.getText();
        String password = tfPassword.getText();
        
        try{
            try(Statement statement = (Statement) file_koneksi.GetConnection().createStatement()){
                statement.executeUpdate("INSERT INTO tb_admin(username, password) VALUES('"+username+"','"+password+"');");
            }
            JOptionPane.showMessageDialog(null,"Selamat anda berhasil Sign Up");
        }catch (Exception t){
            JOptionPane.showMessageDialog(null,"Mohon maaf ulangi lagi prosedur");
        }
    }//GEN-LAST:event_btnSignUPActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed
        Connection connection;
        PreparedStatement ps;
        String user;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_utspbo", "root", "");
            ps = connection.prepareStatement("SELECT username, password FROM tb_admin WHERE username = ? AND password = ?");
            ps.setString(1, tfUsername.getText());
            ps.setString(2, tfPassword.getText());
            user = tfUsername.getText();
            ResultSet result = ps.executeQuery();
            if(result.next()){
                new frmMain(user).show();
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Salah!");
                tfPassword.setText("");
                tfUsername.requestFocus();
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(rootPane, "Gagal!");
        }
    }//GEN-LAST:event_btnSignInActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSignIn;
    private javax.swing.JButton btnSignUP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField tfPassword;
    private javax.swing.JTextField tfUsername;
    // End of variables declaration//GEN-END:variables
}
