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
public class ChiTietHdx {

    private int SoLuong;
    private String MaHDX;
    private String MaXe;
    private String TenXe;
    private String GiaTienBan;

    public String getMaHDX() {
        return MaHDX;
    }

    public void setMaHDX(String MaHDX) {
        this.MaHDX = MaHDX;
    }

    public String getMaXe() {
        return MaXe;
    }

    public void setMaXe(String MaXe) {
        this.MaXe = MaXe;
    }

    public String getTenXe() {
        return TenXe;
    }

    public void setTenXe(String TenXe) {
        this.TenXe = TenXe;
    }

    public String getGiaTienBan() {
        return GiaTienBan;
    }

    public void setGiaTienBan(String GiaTienBan) {
        this.GiaTienBan = GiaTienBan;
    }
    
    public ChiTietHdx(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public ChiTietHdx() {
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

}
