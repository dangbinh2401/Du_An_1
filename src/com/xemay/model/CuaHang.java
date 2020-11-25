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
public class CuaHang {

    private String MaCh;
    private String TenCuaHang;
    private String DiaChi;
    private String Sdt;
    private String Email;

    public CuaHang(String MaCh, String TenCuaHang, String DiaChi, String Sdt, String Email) {
        this.MaCh = MaCh;
        this.TenCuaHang = TenCuaHang;
        this.DiaChi = DiaChi;
        this.Sdt = Sdt;
        this.Email = Email;
    }

    public CuaHang() {
    }

    public String getMaCh() {
        return MaCh;
    }

    public void setMaCh(String MaCh) {
        this.MaCh = MaCh;
    }

    public String getTenCuaHang() {
        return TenCuaHang;
    }

    public void setTenCuaHang(String TenCuaHang) {
        this.TenCuaHang = TenCuaHang;
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

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

}
