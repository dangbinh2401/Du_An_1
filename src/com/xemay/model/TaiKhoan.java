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

    private int MaTk;
    private String MatKhau;
    private String VaiTro;

    public TaiKhoan(int MaTk, String MatKhau, String VaiTro) {
        this.MaTk = MaTk;
        this.MatKhau = MatKhau;
        this.VaiTro = VaiTro;
    }

    public TaiKhoan() {
    }

    public int getMaTk() {
        return MaTk;
    }

    public void setMaTk(int MaTk) {
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
