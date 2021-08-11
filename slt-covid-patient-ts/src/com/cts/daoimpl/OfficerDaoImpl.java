/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cts.daoimpl;

import com.cts.connection.DatabaseConnection;
import com.cts.dao.OfficerDao;
import com.cts.model.Officer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MYPC
 */
public class OfficerDaoImpl implements OfficerDao {

    private String selectQuery = "select id, username, address, centre, mobile, email, password from officers";

    @Override
    public boolean add(Officer officer) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into officers(username, "
                + "address, centre, mobile, email, password) values(?,?,?,?,?,?)");
        ps.setString(1, officer.getName());
        ps.setString(2, officer.getAddress());
        ps.setString(3, officer.getCenter());
        ps.setString(4, officer.getMobile());
        ps.setString(5, officer.getEmail());
        ps.setString(6, officer.getPassword());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean update(Officer officer) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update officers set username=?, "
                + "address=?, centre=?, mobile=?, email=?, password=? where id=?");
        ps.setString(1, officer.getName());
        ps.setString(2, officer.getAddress());
        ps.setString(3, officer.getCenter());
        ps.setString(4, officer.getMobile());
        ps.setString(5, officer.getEmail());
        ps.setString(6, officer.getPassword());
        ps.setInt(7, officer.getId());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("delete from officers where id=?");
        ps.setInt(1, id);
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public ResultSet getAll() throws SQLException {
        return new CommonDaoImpl().getAllRecords(selectQuery);
    }

    @Override
    public ResultSet getByAttribute(String attribute, String condition, String value) throws SQLException {
        return new CommonDaoImpl().getResultByAttribute(selectQuery, attribute, condition, value);
    }

}
