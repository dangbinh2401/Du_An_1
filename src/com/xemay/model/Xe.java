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

    private String MaXe;
    private String maCH;
    private String TenXe;
    private String maLX;
    private int NamSx;
    private int DungTich;
    private float GiaTienBan;
    private int SoLuong;
    private int ThoiGianBh;
    private String SoKhung;
    private String Hinh;

    public Xe() {
    }

    public Xe(String MaXe, String maCH, String TenXe, String maLX, int NamSx, int DungTich, float GiaTienBan, int SoLuong, int ThoiGianBh, String SoKhung, String Hinh) {
        this.MaXe = MaXe;
        this.maCH = maCH;
        this.TenXe = TenXe;
        this.maLX = maLX;
        this.NamSx = NamSx;
        this.DungTich = DungTich;
        this.GiaTienBan = GiaTienBan;
        this.SoLuong = SoLuong;
        this.ThoiGianBh = ThoiGianBh;
        this.SoKhung = SoKhung;
        this.Hinh = Hinh;
    }

    public String getMaXe() {
        return MaXe;
    }

    public void setMaXe(String MaXe) {
        this.MaXe = MaXe;
    }

    public String getMaCH() {
        return maCH;
    }

    public void setMaCH(String maCH) {
        this.maCH = maCH;
    }

    public String getTenXe() {
        return TenXe;
    }

    public void setTenXe(String TenXe) {
        this.TenXe = TenXe;
    }

    public String getMaLX() {
        return maLX;
    }

    public void setMaLX(String maLX) {
        this.maLX = maLX;
    }

    public int getNamSx() {
        return NamSx;
    }

    public void setNamSx(int NamSx) {
        this.NamSx = NamSx;
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

    public int getThoiGianBh() {
        return ThoiGianBh;
    }

    public void setThoiGianBh(int ThoiGianBh) {
        this.ThoiGianBh = ThoiGianBh;
    }

    public String getSoKhung() {
        return SoKhung;
    }

    public void setSoKhung(String SoKhung) {
        this.SoKhung = SoKhung;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }
    
}
