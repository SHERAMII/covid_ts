/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cts.controller;

import com.cts.core.CommonConstants;
import com.cts.core.Validations;
import com.cts.daoimpl.CenterDaoImpl;
import com.cts.model.CovidCenter;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CovidCenterController {

    public static boolean add(String centerName, String longitude, String latitude) throws SQLException {
        CovidCenter covidCenter = new CovidCenter();
        covidCenter.setCenterName(centerName);
        covidCenter.setLatitude(Validations.getBigDecimalOrZeroFromString(latitude));
        covidCenter.setLongitude(Validations.getBigDecimalOrZeroFromString(longitude));
        return new CenterDaoImpl().add(covidCenter);
    }

    public static boolean update(String centerName, String longitude, String latitude, int id) throws SQLException {
        CovidCenter covidCenter = new CovidCenter();
        covidCenter.setCenterName(centerName);
        covidCenter.setLatitude(Validations.getBigDecimalOrZeroFromString(latitude));
        covidCenter.setLongitude(Validations.getBigDecimalOrZeroFromString(longitude));
        covidCenter.setId(id);
        return new CenterDaoImpl().update(covidCenter);
    }

    public static boolean delete(int id) throws SQLException {
        return new CenterDaoImpl().delete(id);
    }

    public static CovidCenter getCenterById(int id) throws SQLException {
        ResultSet rset = new CenterDaoImpl().getResultByOneAttribute("id", CommonConstants.sql.EQUAL, Integer.toString(id));
        CovidCenter covidCenter = null;
        while (rset.next()) {
            covidCenter = new CovidCenter();
            covidCenter.setId(rset.getInt("id"));
            covidCenter.setCenterName(rset.getString("centre_location"));
            covidCenter.setLatitude(rset.getBigDecimal("latitude"));
            covidCenter.setLongitude(rset.getBigDecimal("longitude"));
        }
        return covidCenter;
    }
}
