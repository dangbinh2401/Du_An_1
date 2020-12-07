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
public class ThongKeXeNV {
    String TenCH;
    String TenXe;
    int SoLuong;
    float GiaTien;
    float TongTien;

    public ThongKeXeNV() {
    }

    public ThongKeXeNV(String TenCH, String TenXe, int SoLuong, float GiaTien, float TongTien) {
        this.TenCH = TenCH;
        this.TenXe = TenXe;
        this.SoLuong = SoLuong;
        this.GiaTien = GiaTien;
        this.TongTien = TongTien;
    }

    public String getTenCH() {
        return TenCH;
    }

    public void setTenCH(String TenCH) {
        this.TenCH = TenCH;
    }

    public String getTenXe() {
        return TenXe;
    }

    public void setTenXe(String TenXe) {
        this.TenXe = TenXe;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(float GiaTien) {
        this.GiaTien = GiaTien;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }
    
}
