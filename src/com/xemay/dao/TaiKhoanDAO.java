/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.dao;

import com.xemay.helper.JdbcHelper;
import com.xemay.model.TaiKhoan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class TaiKhoanDAO {
    public void insert(TaiKhoan model) {
        //String MaCh, String TenCuaHang, String DiaChi, String Sdt, String Email
        String sql = "INSERT INTO TaiKhoan (MaTK, MatKhau, VaiTro) VALUES (?, ?, ?)";
        JdbcHelper.executeUpdate(sql, model.getMaTk(), model.getMatKhau(), model.getVaiTro());
    }
    public void update(TaiKhoan model) {
        String sql = "UPDATE TaiKhoan SET MatKhau=?, VaiTro=? WHERE MaTK=?";
        JdbcHelper.executeUpdate(sql, model.getMatKhau(), model.getVaiTro(), model.getMaTk());
    }
    public List<TaiKhoan> select() {
        String sql = "SELECT * FROM TaiKhoan";
        return select(sql);
    }
    public List<TaiKhoan> find(String key){
        String sql = "select * from TaiKhoan where MaTK like N'%"+key+"%'";
        return select(sql);
    }
    private List<TaiKhoan> select(String sql, Object... args) {
        List<TaiKhoan> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    TaiKhoan model = readFromResultSet(rs);
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
    private TaiKhoan readFromResultSet(ResultSet rs) throws SQLException {
        TaiKhoan model = new TaiKhoan();
        model.setMaTk(rs.getString("MaTK"));
        model.setMatKhau(rs.getString("MatKhau"));
        model.setVaiTro(rs.getString("VaiTro"));
        return model;
    }
}
