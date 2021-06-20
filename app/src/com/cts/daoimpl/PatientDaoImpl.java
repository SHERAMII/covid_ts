/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cts.daoimpl;

import com.cts.connection.DatabaseConnection;
import com.cts.dao.PatientDao;
import com.cts.model.Patient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MYPC
 */
public class PatientDaoImpl implements PatientDao {

    private String selectQuery = "select id, fullname, address, age, mobile, photo from patients";

    @Override
    public boolean addPatient(Patient patient) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into patients "
                + "(fullname, address, age, mobile, photo) values (?,?,?,?,?)");
        ps.setString(1, patient.getFullName());
        ps.setString(2, patient.getAddress());
        ps.setInt(3, patient.getAge());
        ps.setString(4, patient.getContact());
        ps.setString(5, patient.getPhotoPath());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean updatePatient(Patient patient) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update patients set fullname=?, address=?, "
                + "age=?, mobile=?, photo=? where id=?");
        ps.setString(1, patient.getFullName());
        ps.setString(2, patient.getAddress());
        ps.setInt(3, patient.getAge());
        ps.setString(4, patient.getContact());
        ps.setString(5, patient.getPhotoPath());
        ps.setInt(6, patient.getId());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean deletePatient(int patientId) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("delete from patients where id=?");
        ps.setInt(1, patientId);
        ps.executeUpdate();
        return true;
    }

    @Override
    public ResultSet getAll() throws SQLException {
        return new CommonDaoImpl().getAllRecords(selectQuery);
    }

    @Override
    public ResultSet getByOneAttribute(String attribute, String condition, String value) throws SQLException {
      return new CommonDaoImpl().getResultByAttribute(selectQuery, attribute, condition, value);
    }

}
