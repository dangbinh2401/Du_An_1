/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.model;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class TinNhan {
    private String MaNguoiGui;
    private String MaNguoiNhan;
    private Date ThoiGian;
    private String NoiDung;

    public TinNhan(String MaNguoiGui, String MaNguoiNhan, Date ThoiGian, String NoiDung) {
        this.MaNguoiGui = MaNguoiGui;
        this.MaNguoiNhan = MaNguoiNhan;
        this.ThoiGian = ThoiGian;
        this.NoiDung = NoiDung;
    }

    public TinNhan() {
    }

    public String getMaNguoiGui() {
        return MaNguoiGui;
    }

    public void setMaNguoiGui(String MaNguoiGui) {
        this.MaNguoiGui = MaNguoiGui;
    }

    public String getMaNguoiNhan() {
        return MaNguoiNhan;
    }

    public void setMaNguoiNhan(String MaNguoiNhan) {
        this.MaNguoiNhan = MaNguoiNhan;
    }

    public Date getThoiGian() {
        return ThoiGian;
    }

    public void setThoiGian(Date ThoiGian) {
        this.ThoiGian = ThoiGian;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String NoiDung) {
        this.NoiDung = NoiDung;
    }
    
    
}
