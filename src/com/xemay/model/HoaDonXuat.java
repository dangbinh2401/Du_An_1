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
    private  String MaNV;
    private String MaKH;
    private  String HoTenKH;
    private String HoTenNhanVien;
    private String SoDienThoai;

    public String getSoDienThoai() {
        return SoDienThoai;
    }

    public void setSoDienThoai(String SoDienThoai) {
        this.SoDienThoai = SoDienThoai;
    }
    
    public String getHoTenNhanVien() {
        return HoTenNhanVien;
    }

    public void setHoTenNhanVien(String HoTenNhanVien) {
        this.HoTenNhanVien = HoTenNhanVien;
    }
    
    public String getMaNV() {
        return MaNV;
    }

    public String getHoTenKH() {
        return HoTenKH;
    }

    public void setHoTenKH(String HoTenKH) {
        this.HoTenKH = HoTenKH;
    }
    
    public HoaDonXuat(String MaHdx, Date NgayXuat, String MaNV, String MaKH) {
        this.MaHdx = MaHdx;
        this.NgayXuat = NgayXuat;
        this.MaNV = MaNV;
        this.MaKH = MaKH;
    }

    
    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
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
