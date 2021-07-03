/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cts.daoimpl;

import com.cts.dao.OfficerDao;
import com.cts.model.Officer;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MYPC
 */
public class OfficerDaoImpl implements OfficerDao{
    
    private String selectQuery = "select id, username, address, centre, mobile, email, password from officers";

    @Override
    public boolean add(Officer officer) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Officer officer) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet getAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet getByAttribute(String attribute, String condition, String value) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
