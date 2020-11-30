/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.dao;

import com.xemay.helper.JdbcHelper;
import com.xemay.model.KhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.text.html.parser.DTDConstants;

/**
 *
 * @author PC
 */
public class KhachHangDao {

    public void insert(KhachHang model) {
        String sql = "INSERT INTO KhachHang (MaTK, MaKH, HoTen, SoDienThoai, GioiTinh, DiaChi, Email) VALUES (?, ?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql, model.getMaTk(), model.getMaKh(), model.getHoTen(), model.getSdt(), model.getGioiTinh(), model.getDiaChi(), model.getEmail());
    }

    public void update(KhachHang model) {
        String sql = "UPDATE KhachHang  SET MaTK=?, HoTen=?, SoDienThoai=? GioiTinh=? DiaChi=? Email=? WHERE  MaKH=?";
        JdbcHelper.executeUpdate(sql, model.getMaTk(), model.getHoTen(), model.getSdt(), model.getGioiTinh(), model.getDiaChi(), model.getEmail(), model.getMaKh());
    }

    public void delete(String makh) {
        try {
            String sql = "UPDATE KhachHang  SET Kt= 0 where MaKH=? ";
            JdbcHelper.executeUpdate(sql, makh);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<KhachHang> select(String sql, Object... args) {
        List<KhachHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    KhachHang model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {

                //rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

    public List<KhachHang> select() {
        String sql = "SELECT * FROM KhachHang where kt=1";
        return select(sql);
    }
    public List<KhachHang> find(String key){
        String sql = "select * from KhachHang where HoTen like N'%"+key+"%'";
        return select(sql);
    }private KhachHang readFromResultSet(ResultSet rs) throws SQLException {
        KhachHang model = new KhachHang();
        model.setMaTk(rs.getString("MaTK"));
        model.setMaKh(rs.getString("MaKH"));
        model.setHoTen(rs.getString("HoTen"));
        model.setSdt(rs.getString("SoDienThoai"));
        model.setGioiTinh(rs.getBoolean("GioiTinh") ? "Nam" : "Nữ");
        model.setDiaChi(rs.getString("DiaChi"));
        model.setEmail(rs.getString("Email"));
        return model;
    }

}
