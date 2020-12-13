/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.dao;

import com.xemay.helper.JdbcHelper;
import com.xemay.model.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class NhanVienDAO {
    public void insert(NhanVien model) {
        String sql = "INSERT INTO NhanVien (MaNV,MaCH, HoTen, SoDienThoai, Email, GioiTinh, DiaChi, MaTK, kt) VALUES (?, ?, ?, ?, ?, ?, ?, ?,1)";
        JdbcHelper.executeUpdate(sql,model.getMaNV() ,model.getMaCH(), model.getHoTen(), model.getSdt(), model.getEmail(),model.getGioiTinh(),model.getDiaChi(),model.getMaTK());
    }
    public void update(NhanVien model){
        String sql = "UPDATE NhanVien SET MaCH=?, HoTen=?, SoDienThoai=?, Email=?, GioiTinh=?, DiaChi=?, MaTK=? WHERE MaNV=?";
        JdbcHelper.executeUpdate(sql,model.getMaCH(),model.getHoTen(), model.getSdt(), model.getEmail(),model.getGioiTinh(),model.getDiaChi(),model.getMaTK(),model.getMaNV());
    }
    public List<NhanVien> select() {
        String sql = "SELECT * FROM NhanVien where Kt=1";
        return selectt(sql);
    }
    public List<NhanVien> select(String MaCH) {
        String sql = "SELECT * FROM NhanVien a inner join CuaHang b on a.MaCH = b.MaCH where a.Kt=1 and b.MaCH = ?";
        return select(sql,MaCH);
    }
    public List<NhanVien> selectMaCH(String MaCH) {
        String sql = "SELECT * FROM NhanVien where MaCH='"+MaCH+"'";
        return select(sql);
    }
    public List<NhanVien> selectMaNV(String MaNV) {
        String sql = "SELECT * FROM NhanVien where MaNV='"+MaNV+"'";
        return select(sql);
    }
    public List<NhanVien> selectMaNV(String MaNV, String MaCH) {
        String sql = "SELECT * FROM NhanVien a inner join CuaHang b on a.MaCH = b.MaCH where a.MaNV=? and b.MaCH = ?";
        return select(sql,MaNV,MaCH);
    }
    public List<NhanVien> findName(String key){
        String sql = "select * from NhanVien where HoTen like N'%"+key+"%' and Kt=1";
        return select(sql);
    }
    public List<NhanVien> findName(String key,String MaCH){
        String sql = "SELECT * FROM NhanVien a inner join CuaHang b on a.MaCH = b.MaCH where a.HoTen like N'%"+key+"%' and a.Kt=1 and b.MaCH=?";
        return select(sql,MaCH);
    }
    public List<NhanVien> findMaNV(String key){
        String sql = "select * from NhanVien where MaNV like N'%"+key+"%' and Kt=1";
        return select(sql);
    }
    public List<NhanVien> findMaNV(String key,String MaCH){
        String sql = "SELECT * FROM NhanVien a inner join CuaHang b on a.MaCH = b.MaCH where a.MaNV like N'%"+key+"%' and a.Kt=1 and b.MaCH=?";
        return select(sql,MaCH);
    }
    public void delete(String maTK) {
        try {
            String sql = "{ call Sp_UpdateNhanVien(?)}";
            JdbcHelper.executeUpdate(sql, maTK);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private List<NhanVien> select(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    NhanVien model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
        private List<NhanVien> selectt(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    NhanVien model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }
    private NhanVien readFromResultSet(ResultSet rs) throws SQLException {
        NhanVien model = new NhanVien();
        model.setMaNV(rs.getString("MaNV"));
        model.setMaCH(rs.getString("MaCH"));
        model.setHoTen(rs.getString("HoTen"));
        model.setSdt(rs.getString("SoDienThoai"));
        model.setEmail(rs.getString("Email"));
        model.setGioiTinh(rs.getBoolean("GioiTinh"));
        model.setDiaChi(rs.getString("DiaChi"));
        model.setMaTK(rs.getString("MaTK"));
        return model;
    }
}
