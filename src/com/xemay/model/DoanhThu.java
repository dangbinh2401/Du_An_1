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
public class DoanhThu {

    private String TenCH;
    private float TongNhap;
    private float DoanhThu;

    public DoanhThu() {
    }

    public DoanhThu(String TenCH, float TongNhap, float DoanhThu) {
        this.TenCH = TenCH;
        this.TongNhap = TongNhap;
        this.DoanhThu = DoanhThu;
    }

    public String getTenCH() {
        return TenCH;
    }

    public void setTenCH(String TenCH) {
        this.TenCH = TenCH;
    }

    public float getTongNhap() {
        return TongNhap;
    }

    public void setTongNhap(float TongNhap) {
        this.TongNhap = TongNhap;
    }

    public float getDoanhThu() {
        return DoanhThu;
    }

    public void setDoanhThu(float DoanhThu) {
        this.DoanhThu = DoanhThu;
    }

}
