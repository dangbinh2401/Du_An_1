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
    private String TenXe;
    private int NamSx;
    private int DungTich;
    private String SoKhung;
    private float GiaTienBan;
    private int SoLuong;
    private int ThoiGianBh;
    private String Hinh;

    public Xe(String MaXe, String TenXe, int NamSx, int DungTich, String SoKhung, float GiaTienBan, int SoLuong, int ThoiGianBh, String Hinh) {
        this.MaXe = MaXe;
        this.TenXe = TenXe;
        this.NamSx = NamSx;
        this.DungTich = DungTich;
        this.SoKhung = SoKhung;
        this.GiaTienBan = GiaTienBan;
        this.SoLuong = SoLuong;
        this.ThoiGianBh = ThoiGianBh;
        this.Hinh = Hinh;
    }

    public Xe() {
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

    public String getSoKhung() {
        return SoKhung;
    }

    public void setSoKhung(String SoKhung) {
        this.SoKhung = SoKhung;
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

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

}
