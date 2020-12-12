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

/**
 *
 * @author PC
 */
public class KhachHangDao {

    public void insert(KhachHang model) {
        String sql = "INSERT INTO KhachHang (MaTK, MaKH, HoTen, SoDienThoai, GioiTinh, DiaChi, Email, Kt) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql, model.getMaTk(), model.getMaKh(), model.getHoTen(), model.getSdt(), model.getGioiTinh(), model.getDiaChi(), model.getEmail(), 1);
    }

    public void update(KhachHang model) {
        String sql = "UPDATE KhachHang  SET MaTK=?, HoTen=?, SoDienThoai=?, GioiTinh=?, DiaChi=?, Email=? WHERE  MaKH=?";
        JdbcHelper.executeUpdate(sql, model.getMaTk(), model.getHoTen(), model.getSdt(), model.getGioiTinh(), model.getDiaChi(), model.getEmail(), model.getMaKh());
    }

    public void delete(String maTK) {
        try {
            String sql = "{ call Sp_UpdateKhachHang(?)}";
            JdbcHelper.executeUpdate(sql, maTK);
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
        String sql = "SELECT * FROM KhachHang where Kt=1";
        return select(sql);
    }
    public List<KhachHang> selectt() {
        String sql = "SELECT * FROM KhachHang";
        return select(sql);
    }
     public List<KhachHang> findHoTen(String HoTen) {
        String sql = "select * from KhachHang where HoTen like N'%"+HoTen+"%' and Kt=1";
        return select(sql);
    }

    public List<KhachHang> find(String key) {
        String sql = "select * from KhachHang where MaKH like N'%"+key+"%' and Kt=1";
        return select(sql);
    }

    public KhachHang selectByMa(String ma) {
        String sql = "select * from KhachHang where MaKH= ?";
        List<KhachHang> list = this.select(sql, ma);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    private KhachHang readFromResultSet(ResultSet rs) throws SQLException {
        KhachHang model = new KhachHang();
        model.setMaTk(rs.getString("MaTK"));
        model.setMaKh(rs.getString("MaKH"));
        model.setHoTen(rs.getString("HoTen"));
        model.setSdt(rs.getString("SoDienThoai"));
        model.setGioiTinh(rs.getBoolean("GioiTinh"));
        model.setDiaChi(rs.getString("DiaChi"));
        model.setEmail(rs.getString("Email"));
        return model;
    }

}
