/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.dao;

import com.xemay.helper.JdbcHelper;
import com.xemay.model.KhachHang;

/**
 *
 * @author ADMIN
 */
public class KhachHangDAO {
        public void insert(KhachHang model) {
        //String MaCh, String TenCuaHang, String DiaChi, String Sdt, String Email
        String sql = "INSERT INTO KhachHang (MaKH, HoTen, SoDienThoai, Email, GioiTinh, DiaChi, MaTK) VALUES (?, ?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql, model.getMaKh(), model.getHoTen(), model.getSdt(), model.getEmail(), model.getGioiTinh(), model.getDiaChi(), model.getMaTK());
    }
}
