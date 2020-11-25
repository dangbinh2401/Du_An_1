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
public class ChiTietHdh {

    private int SoLuong;
    private float GiaTienNhap;

    public ChiTietHdh(int SoLuong, float GiaTienNhap) {
        this.SoLuong = SoLuong;
        this.GiaTienNhap = GiaTienNhap;
    }

    public ChiTietHdh() {
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public float getGiaTienNhap() {
        return GiaTienNhap;
    }

    public void setGiaTienNhap(float GiaTienNhap) {
        this.GiaTienNhap = GiaTienNhap;
    }

}
