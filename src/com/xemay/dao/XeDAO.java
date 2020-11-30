/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.dao;

import com.xemay.helper.JdbcHelper;
import com.xemay.model.Xe;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class XeDAO {
    public void insert(Xe model) {
        String sql = "INSERT INTO Xe (MaXe, MaCH, TenXe, MaLX, NamSX, DungTich, GiaTienBan,SoLuong,ThoiGianBH, Sokhung,Anh) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql, model.getMaXe(), model.getMaCH(), model.getTenXe(), model.getMaLX(), model.getNamSx(),model.getDungTich(),model.getGiaTienBan(),model.getSoLuong(),model.getThoiGianBh(),model.getSoKhung(),model.getHinh());
    }

    public void update(Xe model) {
        String sql = "UPDATE Xe  SET MaCH=?,TenXe=?, MaLX=?, NamSX=?, DungTich=?, GiaTienBan=?,SoLuong=?,ThoiGianBH=?, Sokhung=?,Anh=? WHERE  MaXe=?";
        JdbcHelper.executeUpdate(sql, model.getMaCH(), model.getTenXe(), model.getMaLX(), model.getNamSx(),model.getDungTich(),model.getGiaTienBan(),model.getSoLuong(),model.getThoiGianBh(),model.getSoKhung(),model.getHinh(), model.getMaXe());
    }

    public List<Xe> selectAll() {
        String sql = "select * from Xe";
        return select(sql);
    }
    public List<Xe> findTenXe(String TenXe) {
        String sql = "select * from Xe where TenXe like N'%"+TenXe+"%'";
        return select(sql);
    }
    private List<Xe> select(String sql, Object... args) {
        List<Xe> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    Xe model = readFromResultSet(rs);
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

    private Xe readFromResultSet(ResultSet rs) throws SQLException {
        Xe model = new Xe();
        model.setMaXe(rs.getString("MaXe"));
        model.setMaCH(rs.getString("MaCH"));
        model.setTenXe(rs.getString("TenXe"));
        model.setMaLX(rs.getString("MaLX"));
        model.setNamSx(rs.getInt("NamSX"));
        model.setDungTich(rs.getInt("DungTich"));
        model.setGiaTienBan(rs.getFloat("GiaTienBan"));
        model.setSoLuong(rs.getInt("SoLuong"));
        model.setThoiGianBh(rs.getInt("ThoiGianBH"));
        model.setSoKhung(rs.getString("SoKhung"));
        model.setHinh(rs.getString("Anh"));
        return model;
    }
}
