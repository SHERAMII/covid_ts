/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cts.dao;

import com.cts.model.Patient;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MYPC
 */
public interface PatientDao {

    public boolean addPatient(Patient patient) throws SQLException;

    public boolean updatePatient(Patient patient) throws SQLException;

    public boolean deletePatient(int patientId) throws SQLException;

    public ResultSet getAll() throws SQLException;

    public ResultSet getByOneAttribute(String attribute, String condition, String value) throws SQLException;

}
