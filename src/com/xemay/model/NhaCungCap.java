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
public class NhaCungCap {

    private String MaNcc;
    private String TenNcc;
    private String DiaChi;
    private String Sdt;
    private String Email;

    public NhaCungCap(String MaNcc, String TenNcc, String DiaChi, String Sdt, String Email) {
        this.MaNcc = MaNcc;
        this.TenNcc = TenNcc;
        this.DiaChi = DiaChi;
        this.Sdt = Sdt;
        this.Email = Email;
    }

    public NhaCungCap() {
    }

    public String getMaNcc() {
        return MaNcc;
    }

    public void setMaNcc(String MaNcc) {
        this.MaNcc = MaNcc;
    }

    public String getTenNcc() {
        return TenNcc;
    }

    public void setTenNcc(String TenNcc) {
        this.TenNcc = TenNcc;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
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

}
