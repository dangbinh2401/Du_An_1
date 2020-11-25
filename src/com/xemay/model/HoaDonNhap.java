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
public class HoaDonNhap {

    private String MaHdh;
    private Date NgayNhap;

    public HoaDonNhap(String MaHdh, Date NgayNhap) {
        this.MaHdh = MaHdh;
        this.NgayNhap = NgayNhap;
    }

    public HoaDonNhap() {
    }

    public String getMaHdh() {
        return MaHdh;
    }

    public void setMaHdh(String MaHdh) {
        this.MaHdh = MaHdh;
    }

    public Date getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(Date NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

}
