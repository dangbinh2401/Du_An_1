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
    private float TongNhap;
    private float DoanhThu;

    public DoanhThu() {
    }

    public DoanhThu(float TongNhap, float DoanhThu) {
        this.TongNhap = TongNhap;
        this.DoanhThu = DoanhThu;
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
