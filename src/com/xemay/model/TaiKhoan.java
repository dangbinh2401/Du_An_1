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
public class TaiKhoan {

    private String MaTk;
    private String MatKhau;
    private String VaiTro;
    private String HoTen;
    private String Email;
    private String TenCH;
    private String DiaChiCH;
    private String MaCH;
    private String MaNV;
    public TaiKhoan(String MaTk, String MatKhau, String VaiTro) {
        this.MaTk = MaTk;
        this.MatKhau = MatKhau;
        this.VaiTro = VaiTro;
    }

    public String getMaCH() {
        return MaCH;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }
    

    public void setMaCH(String MaCH) {
        this.MaCH = MaCH;
    }

    public String getTenCH() {
        return TenCH;
    }

    public void setTenCH(String TenCH) {
        this.TenCH = TenCH;
    }

    public String getDiaChiCH() {
        return DiaChiCH;
    }

    public void setDiaChiCH(String DiaChiCH) {
        this.DiaChiCH = DiaChiCH;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }
    
    public TaiKhoan() {
    }

    public String getMaTk() {
        return MaTk;
    }

    public void setMaTk(String MaTk) {
        this.MaTk = MaTk;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getVaiTro() {
        return VaiTro;
    }

    public void setVaiTro(String VaiTro) {
        this.VaiTro = VaiTro;
    }

}
