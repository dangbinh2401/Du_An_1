/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.dao;

import com.xemay.helper.JdbcHelper;
import com.xemay.model.ThongKeXeNV;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class ThongKeXBRDAO {
    public List<ThongKeXeNV> getXeBanRa() {
        String sql = "{call Sp_ThongKeXeBanRa}";
        return select(sql);
    }

    public List<ThongKeXeNV> Select(String maCH) {
        String sql = "{call Sp_ThongKeXeBR(?)}";
        return select(sql, maCH);
    }

    public List<ThongKeXeNV> SelectThang(String month) {
        String sql = "{call Sp_ThongKeXeBRTheoThang(?)}";
        return select(sql, month);
    }
    public List<ThongKeXeNV> select(String sql, Object... args) {
        List<ThongKeXeNV> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    ThongKeXeNV model = readFromResultSet(rs);
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

    private ThongKeXeNV readFromResultSet(ResultSet rs) throws SQLException {
        ThongKeXeNV model = new ThongKeXeNV();
        model.setTenCH(rs.getString("TenCuaHang"));
        model.setTenXe(rs.getString("TenXe"));
        model.setSoLuong(rs.getInt("SoLuong"));
        model.setGiaTien(rs.getFloat("GiaTien"));
        model.setTongTien(rs.getFloat("TongTien"));
        return model;
    }
    
}
