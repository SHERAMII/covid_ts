/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cts.controller;

import com.cts.core.CommonConstants;
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

    public static ResultSet getAll() throws SQLException {
        return new OfficerDaoImpl().getAll();
    }

    public static ResultSet getByOneAttribute(String attribute, String condition, String value) throws SQLException {
        return new OfficerDaoImpl().getByAttribute(attribute, condition, value);
    }

    public static boolean delete(int id) throws SQLException {
        return new OfficerDaoImpl().delete(id);
    }

    public static Officer getOfficerById(int id) throws SQLException {
        ResultSet rset = getByOneAttribute("id", CommonConstants.sql.EQUAL, Integer.toString(id));
        Officer officer = null;
        while (rset.next()) {
            officer = new Officer();
            officer.setId(rset.getInt("id"));
            officer.setName(rset.getString("username"));
            officer.setAddress(rset.getString("address"));
            officer.setCenter(rset.getString("centre"));
            officer.setMobile(rset.getString("mobile"));
            officer.setEmail(rset.getString("email"));
            officer.setPassword(rset.getString("password"));
        }
        return officer;
    }

}
