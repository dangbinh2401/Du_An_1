/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.model;

import com.xemay.helper.DateHelper;
import java.util.Date;

/**
 *
 * @author PC
 */
public class BaoHang {

    private String maBh;
    private String tenKhachHang;
    private String tenXe;
    private String maXe;
    private String maNv;
    private Date NgayBaoHanh = DateHelper.now();
    private String maKh;
    private String NoidungBh;

    public BaoHang() {
    }

    public BaoHang(String maBh, String tenKhachHang, String tenXe, String maXe, String maNv, String maKh, String NoidungBh) {
        this.maBh = maBh;
        this.tenKhachHang = tenKhachHang;
        this.tenXe = tenXe;
        this.maXe = maXe;
        this.maNv = maNv;
        this.maKh = maKh;
        this.NoidungBh = NoidungBh;
    }

    public String getMaBh() {
        return maBh;
    }

    public void setMaBh(String maBh) {
        this.maBh = maBh;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getTenXe() {
        return tenXe;
    }

    public void setTenXe(String tenXe) {
        this.tenXe = tenXe;
    }

    public String getMaXe() {
        return maXe;
    }

    public void setMaXe(String maXe) {
        this.maXe = maXe;
    }

    public String getMaNv() {
        return maNv;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public Date getNgayBaoHanh() {
        return NgayBaoHanh;
    }

    public void setNgayBaoHanh(Date NgayBaoHanh) {
        this.NgayBaoHanh = NgayBaoHanh;
    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public String getNoidungBh() {
        return NoidungBh;
    }

    public void setNoidungBh(String NoidungBh) {
        this.NoidungBh = NoidungBh;
    }
    
}
