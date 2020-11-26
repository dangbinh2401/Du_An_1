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
public class KhachHang {

    private String MaKh;
    private String HoTen;
    private String Sdt;
    private String Email;
    private Boolean GioiTinh;
    private String DiaChi;
    private String MaTK;
    
    public KhachHang(String MaKh, String HoTen, String Sdt, String Email, Boolean GioiTinh, String DiaChi) {
        this.MaKh = MaKh;
        this.HoTen = HoTen;
        this.Sdt = Sdt;
        this.Email = Email;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
    }

    public String getMaTK() {
        return MaTK;
    }

    public void setMaTK(String MaTK) {
        this.MaTK = MaTK;
    }

    public KhachHang() {
    }

    public String getMaKh() {
        return MaKh;
    }

    public void setMaKh(String MaKh) {
        this.MaKh = MaKh;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Boolean getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(Boolean GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

}
