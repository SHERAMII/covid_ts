/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cts.model;

import java.math.BigDecimal;

/**
 *
 * @author root_user
 */
public class CovidCenter {
    private int id;
    private String centerName;
    private BigDecimal latitude;
    private BigDecimal longitude;
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the centerName
     */
    public String getCenterName() {
        return centerName;
    }

    /**
     * @param centerName the centerName to set
     */
    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    /**
     * @return the latitude
     */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public BigDecimal getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }
    
}
