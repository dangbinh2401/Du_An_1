/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.dao;

import com.xemay.helper.JdbcHelper;
import com.xemay.model.LoaiXe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class LoaiXeDao {

    public List<LoaiXe> selectAll() {
        String sql = "select * from LoaiXe";
        return select(sql);
    }

    public List<LoaiXe> selectBySql(String sql, Object... args) {
        List<LoaiXe> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                LoaiXe xe = new LoaiXe();
                xe.setMaLx(rs.getString(1));
                xe.setTenLx(rs.getString(2));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    private List<LoaiXe> select(String sql, Object... args) {
        List<LoaiXe> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    LoaiXe model = readFromResultSet(rs);
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

    private LoaiXe readFromResultSet(ResultSet rs) throws SQLException {
        LoaiXe model = new LoaiXe();
        model.setMaLx(rs.getString("MaLX"));
        model.setTenLx(rs.getString("TenLX"));
        return model;
    }
}
