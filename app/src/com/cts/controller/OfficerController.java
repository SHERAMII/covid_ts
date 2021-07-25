/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cts.controller;

import com.cts.daoimpl.OfficerDaoImpl;
import com.cts.model.Officer;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author root_user
 */
public class OfficerController {

    public static boolean add(String name, String address, String center,
            String email, String mobile, String password) throws SQLException {
        Officer officer = new Officer();
        officer.setAddress(address);
        officer.setCenter(center);
        officer.setName(name);
        officer.setEmail(email);
        officer.setPassword(password);
        officer.setMobile(mobile);
        return new OfficerDaoImpl().add(officer);
    }

    public static boolean update(String name, String address, String center,
            String email, String mobile, String password, int id) throws SQLException {
        Officer officer = new Officer();
        officer.setAddress(address);
        officer.setCenter(center);
        officer.setName(name);
        officer.setEmail(email);
        officer.setPassword(password);
        officer.setMobile(mobile);
        officer.setId(id);
        return new OfficerDaoImpl().update(officer);
    }
    
    public static ResultSet getAll()throws SQLException{
        return new OfficerDaoImpl().getAll();
    }

    public static ResultSet getByOneAttribute(String attribute, String condition, String value)throws SQLException{
        return new OfficerDaoImpl().getByAttribute(attribute, condition, value);
    }
    
    public static boolean delete(int id)throws SQLException{
        return new OfficerDaoImpl().delete(id);
    }
    
}
