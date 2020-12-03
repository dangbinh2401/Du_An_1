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
public class ChiTietHDN {

    private int SoLuong;
    private float GiaTienNhap;
    private String MaHDN;
    private String MaXe;
    private String TenXe;
    public String getTenXe() {
        return TenXe;
    }

    public void setTenXe(String TenXe) {
        this.TenXe = TenXe;
    }
    
    public String getMaHDN() {
        return MaHDN;
    }

    public void setMaHDN(String MaHDN) {
        this.MaHDN = MaHDN;
    }

    public String getMaXe() {
        return MaXe;
    }

    public void setMaXe(String MaXe) {
        this.MaXe = MaXe;
    }
    
    public ChiTietHDN(int SoLuong, float GiaTienNhap) {
        this.SoLuong = SoLuong;
        this.GiaTienNhap = GiaTienNhap;
    }

    public ChiTietHDN() {
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getGiaTienNhap() {
        return GiaTienNhap;
    }

    public void setGiaTienNhap(float GiaTienNhap) {
        this.GiaTienNhap = GiaTienNhap;
    }

}
