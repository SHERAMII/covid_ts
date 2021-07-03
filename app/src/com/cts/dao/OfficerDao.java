/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cts.dao;

import com.cts.model.Officer;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MYPC
 */
public interface OfficerDao {
    
    public boolean add(Officer officer)throws SQLException;
    
    public boolean update(Officer officer) throws SQLException;
    
    public boolean  delete(int id)throws SQLException;
    
    public ResultSet getAll()throws SQLException;
    
    public ResultSet getByAttribute(String attribute, String condition, String value)throws SQLException;
    
}
