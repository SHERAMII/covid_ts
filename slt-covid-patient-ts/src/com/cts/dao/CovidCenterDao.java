/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cts.dao;

import com.cts.model.CovidCenter;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author root_user
 */
public interface CovidCenterDao {

    public boolean add(CovidCenter covidCenter) throws SQLException;

    public boolean update(CovidCenter covidCenter) throws SQLException;

    public boolean delete(int id) throws SQLException;

    public ResultSet getAll() throws SQLException;

    public ResultSet getResultByOneAttribute(String attribute, String condition, String value) throws SQLException;

}
