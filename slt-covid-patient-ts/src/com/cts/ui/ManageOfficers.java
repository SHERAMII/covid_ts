/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cts.ui;

import com.cts.controller.CommonController;
import com.cts.controller.OfficerController;
import com.cts.controller.PatientsController;
import com.cts.core.Validations;
import com.cts.daoimpl.CenterDaoImpl;
import com.cts.model.Officer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MYPC
 */
public class ManageOfficers extends javax.swing.JFrame {

    int officerId = 0;

    /**
     * Creates new form ManagePatients
     */
    public ManageOfficers() {
        initComponents();
        loadDataToTable();
        loadCentersToCombo();
    }

    private void loadCentersToCombo() {
        try {
            ResultSet rset = new CenterDaoImpl().getAll();
            CommonController.loadDataToComboBox(comboCenterName, rset, "centre_location");
        } catch (SQLException ex) {
            Logger.getLogger(ManageOfficers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadDataToTable() {
        try {
            ResultSet rset = OfficerController.getAll();
            String[] columnList = {"id", "username", "centre", "email", "address", "mobile", "password"};
            CommonController.loadDataToTable(tblData, rset, columnList);
        } catch (SQLException ex) {
            Logger.getLogger(ManageOfficers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    private void loadDataToTable() {
//        try {
//            ResultSet rset = new CenterDaoImpl().getAll();
//            String[] columnList = {"id", "centre_location", "latitude", "longitude"};
//            CommonController.loadDataToTable(tblData, rset, columnList);
//        } catch (SQLException ex) {
//            Logger.getLogger(ManageOfficers.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

    private void addOrUpdateData() {

        if (txtOfficerName.getText().trim() == null || txtOfficerName.getText().trim().equalsIgnoreCase(null)) {
            JOptionPane.showMessageDialog(this, "Please enter officer name !", "Warning", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (txtEmail.getText().trim() == null || txtEmail.getText().trim().equalsIgnoreCase(null)) {
            JOptionPane.showMessageDialog(this, "Please enter email !", "Warning", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (txtMobileNo.getText().trim() == null || txtMobileNo.getText().trim().equalsIgnoreCase(null)) {
            JOptionPane.showMessageDialog(this, "Please enter mobile number !", "Warning", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (txtAddress.getText().trim() == null || txtAddress.getText().trim().equalsIgnoreCase(null)) {
            JOptionPane.showMessageDialog(this, "Please enter address !", "Warning", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (txtPassword.getText().trim() == null || txtPassword.getText().trim().equalsIgnoreCase(null)) {
            JOptionPane.showMessageDialog(this, "Please enter password !", "Warning", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            if (officerId == 0) {
                OfficerController.add(txtOfficerName.getText().trim(), txtAddress.getText().trim(),
                        comboCenterName.getSelectedItem().toString(), txtEmail.getText().trim(),
                        txtMobileNo.getText().trim(), txtPassword.getText().trim());

            } else if (officerId != 0) {
                OfficerController.update(txtOfficerName.getText().trim(), txtAddress.getText().trim(),
                        comboCenterName.getSelectedItem().toString(), txtEmail.getText().trim(),
                        txtMobileNo.getText().trim(), txtPassword.getText().trim(), officerId);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ManageOfficers.class.getName()).log(Level.SEVERE, null, ex);
        }
        loadDataToTable();
        clearAll();
        officerId = 0;
    }

    private void setEditdata() {
        DefaultTableModel dtm = (DefaultTableModel) tblData.getModel();
        int selectedRaw = tblData.getSelectedRow();
        if (selectedRaw != -1) {
            try {
                officerId = Validations.getIntOrZeroFromString(dtm.getValueAt(selectedRaw, 0).toString());
                Officer officer = OfficerController.getOfficerById(officerId);
                comboCenterName.setSelectedItem(officer.getCenter());
                txtOfficerName.setText(officer.getName());
                txtEmail.setText(officer.getEmail());
                txtAddress.setText(officer.getAddress());
                txtPassword.setText(officer.getPassword());
                txtMobileNo.setText(officer.getMobile());
            } catch (SQLException ex) {
                Logger.getLogger(ManageOfficers.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void delete() {
        DefaultTableModel dtm = (DefaultTableModel) tblData.getModel();
        int selectedRaw = tblData.getSelectedRow();
        if (selectedRaw != -1) {
            try {
                int offId = Validations.getIntOrZeroFromString(dtm.getValueAt(selectedRaw, 0).toString());
                OfficerController.delete(offId);
            } catch (SQLException ex) {
                Logger.getLogger(ManageOfficers.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void clearAll() {
        txtOfficerName.setText("");
        txtAddress.setText("");
        txtPassword.setText("");
        txtMobileNo.setText("");
        txtEmail.setText("");
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();
        txtOfficerName = new org.jdesktop.swingx.JXTextField();
        txtAddress = new org.jdesktop.swingx.JXTextField();
        txtPassword = new org.jdesktop.swingx.JXTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        comboCenterName = new javax.swing.JComboBox<>();
        txtEmail = new org.jdesktop.swingx.JXTextField();
        txtMobileNo = new org.jdesktop.swingx.JXTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manage Officers");

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Center Name", "User Name", "Email", "Contact", "Address", "Password"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblData);
        if (tblData.getColumnModel().getColumnCount() > 0) {
            tblData.getColumnModel().getColumn(0).setMinWidth(0);
            tblData.getColumnModel().getColumn(0).setPreferredWidth(0);
            tblData.getColumnModel().getColumn(0).setMaxWidth(0);
            tblData.getColumnModel().getColumn(1).setMinWidth(150);
            tblData.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblData.getColumnModel().getColumn(1).setMaxWidth(150);
            tblData.getColumnModel().getColumn(2).setMinWidth(150);
            tblData.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblData.getColumnModel().getColumn(2).setMaxWidth(150);
            tblData.getColumnModel().getColumn(3).setMinWidth(150);
            tblData.getColumnModel().getColumn(3).setPreferredWidth(150);
            tblData.getColumnModel().getColumn(3).setMaxWidth(150);
            tblData.getColumnModel().getColumn(4).setMinWidth(150);
            tblData.getColumnModel().getColumn(4).setPreferredWidth(150);
            tblData.getColumnModel().getColumn(4).setMaxWidth(150);
            tblData.getColumnModel().getColumn(6).setMinWidth(0);
            tblData.getColumnModel().getColumn(6).setPreferredWidth(0);
            tblData.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        txtOfficerName.setPrompt("Officer Name");

        txtAddress.setName("Address"); // NOI18N
        txtAddress.setPrompt("Address");

        txtPassword.setPrompt("Password");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cts/images/saveIcon.png"))); // NOI18N
        jButton1.setToolTipText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cts/images/editIcon.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cts/images/deleteIcon.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        comboCenterName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtEmail.setToolTipText("Email");
        txtEmail.setPrompt("Email");

        txtMobileNo.setPrompt("Mobile No");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Covid Center");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 145, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtOfficerName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboCenterName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMobileNo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 852, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(comboCenterName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtOfficerName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMobileNo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtMobileNo.getAccessibleContext().setAccessibleDescription("Mobile No");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        addOrUpdateData();
        loadDataToTable();
        clearAll();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        delete();
        loadDataToTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setEditdata();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ManageOfficers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageOfficers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageOfficers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageOfficers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageOfficers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboCenterName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblData;
    private org.jdesktop.swingx.JXTextField txtAddress;
    private org.jdesktop.swingx.JXTextField txtEmail;
    private org.jdesktop.swingx.JXTextField txtMobileNo;
    private org.jdesktop.swingx.JXTextField txtOfficerName;
    private org.jdesktop.swingx.JXTextField txtPassword;
    // End of variables declaration//GEN-END:variables
}
