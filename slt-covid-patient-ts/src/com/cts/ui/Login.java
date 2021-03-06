package com.cts.ui;

import com.cts.connection.DatabaseConnection;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class Login extends javax.swing.JFrame {

    private String Language;

    /**
     * Creates new form ActivationUI
     */
    public Login() {
        initComponents();
    }

    private void login() {
        try{
         Connection con = DatabaseConnection.getDatabaseConnection();
         String sql = "select * from officers where username=? and password=?";
            PreparedStatement pst = con.prepareStatement (sql);
            pst.setString(1, txtUserName.getText());
            pst.setString(2, txtPwField.getText());
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"username and password matched");
                new MainMenuV1().setVisible(true);
            }
             else{
                JOptionPane.showMessageDialog(null,"username and password not matched");
                txtUserName.setText("");
                txtPwField.setText("");
            }
            con.close();
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
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

        panel = new javax.swing.JPanel();
        panelLogin = new javax.swing.JPanel();
        txtUserName = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtPwField = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login ");
        setMaximumSize(new java.awt.Dimension(364, 498));
        setMinimumSize(new java.awt.Dimension(364, 498));
        setResizable(false);

        panel.setBackground(new java.awt.Color(0, 204, 204));
        panel.setFont(new java.awt.Font("Ubuntu", 0, 11)); // NOI18N
        panel.setMaximumSize(new java.awt.Dimension(325, 412));
        panel.setMinimumSize(new java.awt.Dimension(325, 412));
        panel.setPreferredSize(new java.awt.Dimension(325, 412));
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelLogin.setOpaque(false);

        txtUserName.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserNameActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Ubuntu Medium", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 102));
        jLabel12.setText("USER NAME ");

        lblLogin.setBackground(new java.awt.Color(0, 0, 102));
        lblLogin.setFont(new java.awt.Font("Ubuntu Medium", 1, 18)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(255, 255, 255));
        lblLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogin.setText("LOGIN");
        lblLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblLogin.setOpaque(true);
        lblLogin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lblLoginFocusGained(evt);
            }
        });
        lblLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLoginMouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Ubuntu Medium", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 102));
        jLabel13.setText("PASSWORD");

        txtPwField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPwFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtPwField, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                        .addComponent(txtUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel12)
                .addGap(9, 9, 9)
                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel13)
                .addGap(8, 8, 8)
                .addComponent(txtPwField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel.add(panelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 300, 280));

        jLabel2.setBackground(new java.awt.Color(0, 204, 204));
        jLabel2.setToolTipText("");
        panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserNameActionPerformed
        txtPwField.requestFocus();
    }//GEN-LAST:event_txtUserNameActionPerformed

    private void lblLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseClicked
        login();
    }//GEN-LAST:event_lblLoginMouseClicked

    private void txtPwFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPwFieldActionPerformed
//            txtReorderLevel.requestFocus();
        login();
    }//GEN-LAST:event_txtPwFieldActionPerformed

    private void lblLoginFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lblLoginFocusGained

    }//GEN-LAST:event_lblLoginFocusGained

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panelLogin;
    private javax.swing.JPasswordField txtPwField;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
