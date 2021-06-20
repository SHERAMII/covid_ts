/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cts.controller;

import com.cts.daoimpl.PatientDaoImpl;
import com.cts.model.Patient;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MYPC
 */
public class PatientsController {
//

    public static boolean addPatient(String fullName, String address, int age, String contact, String photopath) throws SQLException {
        Patient patient = new Patient();
        patient.setAddress(address);
        patient.setAge(age);
        patient.setContact(contact);
        patient.setFullName(fullName);
        patient.setPhotoPath(photopath);
        return new PatientDaoImpl().addPatient(patient);
    }

    public static boolean updatePatient(String fullName, String address, int age, String contact, String photopath, int id) throws SQLException {
        Patient patient = new Patient();
        patient.setAddress(address);
        patient.setAge(age);
        patient.setContact(contact);
        patient.setFullName(fullName);
        patient.setPhotoPath(photopath);
        patient.setId(id);
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

}
