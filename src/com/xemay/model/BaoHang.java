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

    private String MaBh;
    private Date NgayBaoHanh = DateHelper.now();
    private String NoidungBh;

    public BaoHang() {
    }

    public BaoHang(String MaBh, String NoidungBh) {
        this.MaBh = MaBh;
        this.NoidungBh = NoidungBh;
    }

    public String getMaBh() {
        return MaBh;
    }

    public Date getNgayBaoHanh() {
        return NgayBaoHanh;
    }

    public void setNgayBaoHanh(Date NgayBaoHanh) {
        this.NgayBaoHanh = NgayBaoHanh;
    }

    public String getNoidungBh() {
        return NoidungBh;
    }

    public void setNoidungBh(String NoidungBh) {
        this.NoidungBh = NoidungBh;
    }

}
