/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.dao;

import com.xemay.helper.JdbcHelper;
import com.xemay.model.ChiTietHDN;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ChiTietHoaDonNhapDAO {
        public void insert(ChiTietHDN model) {
        String sql = "INSERT INTO ChiTietHDN (MaHDN, MaXe, SoLuong, GiaTienNhap) VALUES (?, ?, ?,?)";
        JdbcHelper.executeUpdate(sql, model.getMaHDN(), model.getMaXe(), model.getSoLuong(),model.getGiaTienNhap());
    }
    public void delete(String MAHDN,String MaXe) {
        String sql = "Delete from ChiTietHDN where MaHDN=? and MaXe=?";
        JdbcHelper.executeUpdate(sql, MAHDN, MaXe);
    }
    public void update(ChiTietHDN model) {
        String sql = "UPDATE ChiTietHDN  SET  SoLuong=?, GiaTienNhap=? WHERE  MaHDN=? and MaXE=?";
        JdbcHelper.executeUpdate(sql, model.getSoLuong(),model.getGiaTienNhap(), model.getMaHDN(),model.getMaXe());
    }

    public List<ChiTietHDN> selectAll(String MaHDN) {
        String sql = "select MaHDN,a.MaXe,TenXe,a.GiaTienNhap,a.SoLuong from ChiTietHDN a inner join Xe b on a.MaXe = b.MaXe  where MaHDN = ?";
        return select(sql,MaHDN);
    }
    public List<ChiTietHDN> findTenXe(String TenXe) {
        String sql = "select MaHDN,a.MaXe,TenXe,a.GiaTienNhap,a.SoLuong from ChiTietHDN a inner join Xe b on a.MaXe = b.MaXe  where TenXe Like N'%"+TenXe+"%'";
        return select(sql);
    }
    private List<ChiTietHDN> select(String sql, Object... args) {
        List<ChiTietHDN> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    ChiTietHDN model = readFromResultSet(rs);
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            throw new RuntimeException(ex);
        }
        return list;
    }

    private ChiTietHDN readFromResultSet(ResultSet rs) throws SQLException {
        ChiTietHDN model = new ChiTietHDN();
        model.setMaHDN(rs.getString("MaHDN"));
        model.setMaXe(rs.getString("MaXe"));
        model.setTenXe(rs.getString("TenXe"));
        model.setGiaTienNhap(rs.getFloat("GiaTienNhap"));
        model.setSoLuong(rs.getInt("SoLuong"));
        return model;
    }
}
