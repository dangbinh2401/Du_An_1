/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.dao;

import com.xemay.helper.JdbcHelper;
import com.xemay.model.DoanhThu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class DoanhThuDAO {
    
    public List<DoanhThu> getDoanhThuNV() {
        String sql = "Select Sum(SoLuong* GiaTienNhap) as 'TongTien',(Select Sum(SoLuong* GiaTien) FROM ChiTietHDX) as 'DoanhThu'  FROM ChiTietHDN";
        return (List<DoanhThu>) selectt(sql);
    }
    
    public List<DoanhThu> Select(String maCH) {
        String sql = "{call Sp_ThongKeDoanhThuCuaHang(?)}";
        return select(sql, maCH);
    }

    public List<DoanhThu> select(String sql, Object... args) {
        List<DoanhThu> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    DoanhThu model = readFromResultSet(rs);
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
    
    public List<DoanhThu> selectt(String sql, Object... args) {
        List<DoanhThu> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    DoanhThu model = readFromResultSet1(rs);
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
    
    private DoanhThu readFromResultSet(ResultSet rs) throws SQLException {
        DoanhThu model = new DoanhThu();
        model.setTenCH(rs.getString("TenCuaHang"));
        model.setTongNhap(rs.getFloat("TongTien"));
        model.setDoanhThu(rs.getFloat("DoanhThu"));
        return model;
    }
      private DoanhThu readFromResultSet1(ResultSet rs) throws SQLException {
        DoanhThu model = new DoanhThu();
        model.setTongNhap(rs.getFloat("TongTien"));
        model.setDoanhThu(rs.getFloat("DoanhThu"));
        return model;
    }
}
