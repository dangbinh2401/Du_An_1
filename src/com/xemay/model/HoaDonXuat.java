/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.model;

import java.util.Date;

/**
 *
 * @author PC
 */
public class HoaDonXuat {

    private String MaHdx;
    private Date NgayXuat;

    public HoaDonXuat(String MaHdx, Date NgayXuat) {
        this.MaHdx = MaHdx;
        this.NgayXuat = NgayXuat;
    }

    public HoaDonXuat() {
    }

    public String getMaHdx() {
        return MaHdx;
    }

    public void setMaHdx(String MaHdx) {
        this.MaHdx = MaHdx;
    }

    public Date getNgayXuat() {
        return NgayXuat;
    }

    public void setNgayXuat(Date NgayXuat) {
        this.NgayXuat = NgayXuat;
    }

}
