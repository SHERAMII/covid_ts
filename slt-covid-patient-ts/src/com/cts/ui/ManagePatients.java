/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cts.ui;

import com.cts.controller.CommonController;
import com.cts.controller.PatientsController;
import com.cts.core.Validations;
import com.cts.daoimpl.CenterDaoImpl;
import com.cts.model.Patient;
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
public class ManagePatients extends javax.swing.JFrame {

    int patientId = 0;

    /**
     * Creates new form ManagePatients
     */
    public ManagePatients() {
        initComponents();
        loaddataToTable();
        loadCentersToCombo();
    }

    private void loadCentersToCombo() {
        try {
            ResultSet rset = new CenterDaoImpl().getAll();
            CommonController.loadDataToComboBox(comboCenterName, rset, "centre_location");
        } catch (SQLException ex) {
            Logger.getLogger(ManagePatients.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loaddataToTable() {
        try {
            ResultSet rset = PatientsController.getAll();
            String[] columnList = {"id", "fullname", "address", "age", "mobile", "center_name"};
            CommonController.loadDataToTable(tblData, rset, columnList);
        } catch (SQLException ex) {
            Logger.getLogger(ManagePatients.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addOrUpdateData() {

        if (txtName.getText().trim() == null || txtName.getText().trim().equalsIgnoreCase(null)) {
            JOptionPane.showMessageDialog(this, "Please enter name !", "Warning", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (txtAddress.getText().trim() == null || txtAddress.getText().trim().equalsIgnoreCase(null)) {
            JOptionPane.showMessageDialog(this, "Please enter address !", "Warning", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (txtAge.getText().trim() == null || txtAge.getText().trim().equalsIgnoreCase(null)) {
            JOptionPane.showMessageDialog(this, "Please enter age !", "Warning", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (txtContact.getText().trim() == null || txtContact.getText().trim().equalsIgnoreCase(null)) {
            JOptionPane.showMessageDialog(this, "Please enter contact no. !", "Warning", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            if (patientId == 0) {
                PatientsController.addPatient(txtName.getText().trim(), txtAddress.getText().trim(),
                        Validations.getIntOrZeroFromString(txtAge.getText().trim()),
                        txtContact.getText().trim(), "", comboCenterName.getSelectedItem().toString());
            } else if (patientId != 0) {
                PatientsController.updatePatient(txtName.getText().trim(), txtAddress.getText().trim(),
                        Validations.getIntOrZeroFromString(txtAge.getText().trim()),
                        txtContact.getText().trim(), "", patientId, comboCenterName.getSelectedItem().toString());
            }

        } catch (SQLException ex) {
            Logger.getLogger(ManagePatients.class.getName()).log(Level.SEVERE, null, ex);
        }
        loaddataToTable();
        clearAll();
        patientId = 0;
    }

    private void setEditdata() {
        DefaultTableModel dtm = (DefaultTableModel) tblData.getModel();
        int selectedRaw = tblData.getSelectedRow();
        if (selectedRaw != -1) {
            try {
                patientId = Validations.getIntOrZeroFromString(dtm.getValueAt(selectedRaw, 0).toString());
                Patient patient = PatientsController.getPatientById(patientId);
                txtAddress.setText(patient.getAddress());
                txtAge.setText(Integer.toString(patient.getAge()));
                txtContact.setText(patient.getContact());
                txtName.setText(patient.getFullName());
                comboCenterName.setSelectedItem(patient.getCenterName());
            } catch (SQLException ex) {
                Logger.getLogger(ManagePatients.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void delete() {
        DefaultTableModel dtm = (DefaultTableModel) tblData.getModel();
        int selectedRaw = tblData.getSelectedRow();
        if (selectedRaw != -1) {
            try {
                int patientId = Validations.getIntOrZeroFromString(dtm.getValueAt(selectedRaw, 0).toString());
                PatientsController.deletePatient(patientId);
            } catch (SQLException ex) {
                Logger.getLogger(ManagePatients.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void clearAll() {
        txtAddress.setText("");
        txtAge.setText("");
        txtName.setText("");
        txtContact.setText("");
        txtSearch.setText("");
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
        txtName = new org.jdesktop.swingx.JXTextField();
        txtAddress = new org.jdesktop.swingx.JXTextField();
        txtAge = new org.jdesktop.swingx.JXTextField();
        txtContact = new org.jdesktop.swingx.JXTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtSearch = new org.jdesktop.swingx.JXTextField();
        jButton4 = new javax.swing.JButton();
        comboCenterName = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Manage Patients");

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Patient Name", "Address", "Age", "Contact", "Center"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
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
            tblData.getColumnModel().getColumn(1).setMinWidth(250);
            tblData.getColumnModel().getColumn(1).setPreferredWidth(250);
            tblData.getColumnModel().getColumn(1).setMaxWidth(250);
            tblData.getColumnModel().getColumn(3).setResizable(false);
            tblData.getColumnModel().getColumn(4).setResizable(false);
            tblData.getColumnModel().getColumn(5).setResizable(false);
        }

        txtName.setToolTipText("Patient Name");
        txtName.setPrompt("Patient Name");
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        txtAddress.setPrompt("Patient Address");

        txtAge.setPrompt("Age (Years)");

        txtContact.setToolTipText("Contact");
        txtContact.setPrompt("Contact");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cts/images/saveIcon.png"))); // NOI18N
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

        txtSearch.setPrompt("Search Patient");
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/cts/images/searchIcon.png"))); // NOI18N

        comboCenterName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Covid Center");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(comboCenterName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 471, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboCenterName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
        loaddataToTable();
        clearAll();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        delete();
        loaddataToTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setEditdata();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        try {
            PatientsController.searchByName(txtSearch.getText().trim(), tblData);
        } catch (SQLException ex) {
            Logger.getLogger(ManagePatients.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_txtSearchKeyTyped

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
            java.util.logging.Logger.getLogger(ManagePatients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManagePatients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManagePatients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManagePatients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManagePatients().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboCenterName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblData;
    private org.jdesktop.swingx.JXTextField txtAddress;
    private org.jdesktop.swingx.JXTextField txtAge;
    private org.jdesktop.swingx.JXTextField txtContact;
    private org.jdesktop.swingx.JXTextField txtName;
    private org.jdesktop.swingx.JXTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
