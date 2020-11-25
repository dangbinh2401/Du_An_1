/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.model;

/**
 *
 * @author PC
 */
public class LoaiXe {

    private String MaLx;
    private String TenLx;

    public LoaiXe(String MaLx, String TenLx) {
        this.MaLx = MaLx;
        this.TenLx = TenLx;
    }

    public LoaiXe() {
    }

    public String getMaLx() {
        return MaLx;
    }

    public void setMaLx(String MaLx) {
        this.MaLx = MaLx;
    }

    public String getTenLx() {
        return TenLx;
    }

    public void setTenLx(String TenLx) {
        this.TenLx = TenLx;
    }

}
