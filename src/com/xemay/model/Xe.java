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
public class Xe {

    private String maCH;
    private String MaXe;
    private String TenXe;
    private String TenLx;
    private String SoKhung;
    private int DungTich;
    private float GiaTienBan;
    private int SoLuong;
    private int NamSx;
    private int ThoiGianBh;
    private String Hinh;
     private String MaLx;
    public Xe() {
    }

    public Xe(String maCH, String TenXe, String TenLx, String SoKhung, int DungTich, float GiaTienBan, int SoLuong, int NamSx, int ThoiGianBh, String Hinh, String MaLx) {
        this.maCH = maCH;
        this.TenXe = TenXe;
        this.TenLx = TenLx;
        this.SoKhung = SoKhung;
        this.DungTich = DungTich;
        this.GiaTienBan = GiaTienBan;
        this.SoLuong = SoLuong;
        this.NamSx = NamSx;
        this.ThoiGianBh = ThoiGianBh;
        this.Hinh = Hinh;
        this.MaLx = MaLx;
    }

    public String getMaCH() {
        return maCH;
    }

    public void setMaCH(String maCH) {
        this.maCH = maCH;
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

    public String getTenLx() {
        return TenLx;
    }

    public void setTenLx(String TenLx) {
        this.TenLx = TenLx;
    }

    public String getSoKhung() {
        return SoKhung;
    }

    public void setSoKhung(String SoKhung) {
        this.SoKhung = SoKhung;
    }

    public int getDungTich() {
        return DungTich;
    }

    public void setDungTich(int DungTich) {
        this.DungTich = DungTich;
    }

    public float getGiaTienBan() {
        return GiaTienBan;
    }

    public void setGiaTienBan(float GiaTienBan) {
        this.GiaTienBan = GiaTienBan;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getNamSx() {
        return NamSx;
    }

    public void setNamSx(int NamSx) {
        this.NamSx = NamSx;
    }

    public int getThoiGianBh() {
        return ThoiGianBh;
    }

    public void setThoiGianBh(int ThoiGianBh) {
        this.ThoiGianBh = ThoiGianBh;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

    public String getMaLx() {
        return MaLx;
    }

    public void setMaLx(String MaLx) {
        this.MaLx = MaLx;
    }

}
