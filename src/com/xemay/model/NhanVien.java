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
public class NhanVien {

    private String MaNV;
    private String HoTen;
    private String Sdt;
    private String Email;
    private Boolean GioiTinh;
    private String DiaChi;

    public NhanVien(String MaNV, String HoTen, String Sdt, String Email, Boolean GioiTinh, String DiaChi) {
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.Sdt = Sdt;
        this.Email = Email;
        this.GioiTinh = GioiTinh;
        this.DiaChi = DiaChi;
    }

    public NhanVien() {
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
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
