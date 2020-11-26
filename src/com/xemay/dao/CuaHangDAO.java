/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.dao;

import com.xemay.helper.JdbcHelper;
import com.xemay.model.CuaHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class CuaHangDAO {

    public void insert(CuaHang model) {
        //String MaCh, String TenCuaHang, String DiaChi, String Sdt, String Email
        String sql = "INSERT INTO CuaHang (MaCH, TenCuaHang, DiaChi, SoDienThoai, Email) VALUES (?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql, model.getMaCh(), model.getTenCuaHang(), model.getDiaChi(), model.getSdt(), model.getEmail());
    }

    public void update(CuaHang model) {
        String sql = "UPDATE CuaHang SET TenCuaHang=?, DiaChi=?, SoDienThoai=?, Email=? WHERE MaCH=?";
        JdbcHelper.executeUpdate(sql, model.getTenCuaHang(), model.getDiaChi(), model.getSdt(), model.getEmail(), model.getMaCh());
    }

    private List<CuaHang> select(String sql, Object... args) {
        List<CuaHang> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    CuaHang model = readFromResultSet(rs);
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

    public List<CuaHang> select() {
        String sql = "SELECT * FROM CuaHang";
        return select(sql);
    }
    public List<CuaHang> find(String key){
        String sql = "select * from CuaHang where TenCuaHang like N'%"+key+"%'";
        return select(sql);
    }

    private CuaHang readFromResultSet(ResultSet rs) throws SQLException {
        CuaHang model = new CuaHang();
        model.setMaCh(rs.getString("MaCH"));
        model.setTenCuaHang(rs.getString("TenCuaHang"));
        model.setDiaChi(rs.getString("DiaChi"));
        model.setSdt(rs.getString("SoDienThoai"));
        model.setEmail(rs.getString("Email"));
        return model;
    }
}
