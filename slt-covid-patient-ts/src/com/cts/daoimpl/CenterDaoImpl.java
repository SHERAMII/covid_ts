/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cts.daoimpl;

import com.cts.connection.DatabaseConnection;
import com.cts.dao.CovidCenterDao;
import com.cts.model.CovidCenter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CenterDaoImpl implements CovidCenterDao {

    private String selectQuery = "select id, latitude, longitude, centre_location from quarantine_centres";

    @Override
    public boolean add(CovidCenter covidCenter) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("insert into quarantine_centres(latitude, longitude, centre_location) values (?,?,?)");
        ps.setBigDecimal(1, covidCenter.getLatitude());
        ps.setBigDecimal(2, covidCenter.getLongitude());
        ps.setString(3, covidCenter.getCenterName());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean update(CovidCenter covidCenter) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("update quarantine_centres set latitude=?, longitude=?, centre_location=? where id=?");
        ps.setBigDecimal(1, covidCenter.getLatitude());
        ps.setBigDecimal(2, covidCenter.getLongitude());
        ps.setString(3, covidCenter.getCenterName());
        ps.setInt(4, covidCenter.getId());
        ps.executeUpdate();
        ps.close();
        return true;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        Connection con = DatabaseConnection.getDatabaseConnection();
        PreparedStatement ps = con.prepareStatement("delete from quarantine_centres where id=?");
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
    public ResultSet getResultByOneAttribute(String attribute, String condition, String value) throws SQLException {
        return new CommonDaoImpl().getResultByAttribute(selectQuery, attribute, condition, value);
    }

}
