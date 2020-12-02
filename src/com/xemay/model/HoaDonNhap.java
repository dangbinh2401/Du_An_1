
package com.xemay.model;

import java.util.Date;

/**
 *
 * @author PC
 */
public class HoaDonNhap {

    private String MaHDN;
    private String MaNV;
    private String TenNV;
    private String MaNCC;
    private String TenNCC;
    private Date NgayNhap;

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getMaNCC() {
        return MaNCC;
    }

    public void setMaNCC(String MaNCC) {
        this.MaNCC = MaNCC;
    }

    public String getTenNCC() {
        return TenNCC;
    }

    public void setTenNCC(String TenNCC) {
        this.TenNCC = TenNCC;
    }

    public HoaDonNhap(String MaHdh, Date NgayNhap) {
        this.MaHDN = MaHdh;
        this.NgayNhap = NgayNhap;
    }

    public HoaDonNhap() {
    }

    public String getMaHDN() {
        return MaHDN;
    }

    public void setMaHDN(String MaHdh) {
        this.MaHDN = MaHdh;
    }

    public Date getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(Date NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

}
