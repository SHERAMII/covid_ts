/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cts.controller;

import com.cts.core.CommonConstants;
import com.cts.daoimpl.PatientDaoImpl;
import com.cts.model.Patient;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;

/**
 *
 * @author MYPC
 */
public class PatientsController {
//

    public static boolean addPatient(String fullName, String address, int age,
            String contact, String photopath, String centerName) throws SQLException {
        Patient patient = new Patient();
        patient.setAddress(address);
        patient.setAge(age);
        patient.setContact(contact);
        patient.setFullName(fullName);
        patient.setPhotoPath(photopath);
        patient.setCenterName(centerName);
        return new PatientDaoImpl().addPatient(patient);
    }

    public static boolean updatePatient(String fullName, String address, int age,
            String contact, String photopath, int id, String centerName) throws SQLException {
        Patient patient = new Patient();
        patient.setAddress(address);
        patient.setAge(age);
        patient.setContact(contact);
        patient.setFullName(fullName);
        patient.setPhotoPath(photopath);
        patient.setId(id);
        patient.setCenterName(centerName);
        return new PatientDaoImpl().updatePatient(patient);
    }

    public static ResultSet getAll() throws SQLException {
        return new PatientDaoImpl().getAll();
    }

    public static boolean deletePatient(int id) throws SQLException {
        return new PatientDaoImpl().deletePatient(id);
    }

    public static ResultSet getByOneAttribute(String attribute, String condition, String value) throws SQLException {
        return new PatientDaoImpl().getByOneAttribute(attribute, condition, value);
    }

    public static Patient getPatientById(int id) throws SQLException {
        Patient patient = null;
        ResultSet rset = getByOneAttribute("id", CommonConstants.sql.EQUAL, Integer.toString(id));
        while (rset.next()) {
            patient = new Patient();
            patient.setId(rset.getInt("id"));
            patient.setAddress(rset.getString("address"));
            patient.setAge(rset.getInt("age"));
            patient.setContact(rset.getString("mobile"));
            patient.setFullName(rset.getString("fullname"));
            patient.setPhotoPath(rset.getString("photo"));
        }
        return patient;
    }

    public static void searchByName(String patientName, JTable tblData) throws SQLException {
        ResultSet rset = getByOneAttribute("fullname", CommonConstants.sql.LIKE, "%" + patientName + "%");
        String[] columnList = {"id", "fullname", "address", "age", "mobile"};
        CommonController.loadDataToTable(tblData, rset, columnList);
    }

}
