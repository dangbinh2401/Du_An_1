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
        JdbcHelper.executeUpdate(sql, model.getMaXe(), model.getMaCH(), model.getTenXe(), model.getMaLx(), model.getNamSx(), model.getDungTich(), model.getGiaTienBan(), model.getSoLuong(), model.getThoiGianBh(), model.getSoKhung(), model.getHinh());
    }

    public void update(Xe model) {
        String sql = "UPDATE Xe  SET MaCH=?,TenXe=?, MaLX=?, NamSX=?, DungTich=?, GiaTienBan=?,SoLuong=?,ThoiGianBH=?, Sokhung=?,Anh=? WHERE  MaXe=?";
        JdbcHelper.executeUpdate(sql, model.getMaCH(), model.getTenXe(), model.getMaLx(), model.getNamSx(), model.getDungTich(), model.getGiaTienBan(), model.getSoLuong(), model.getThoiGianBh(), model.getSoKhung(), model.getHinh(), model.getMaXe());
    }

    public List<Xe> selectAll() {
        String sql = "select * from Xe";
        return select(sql);
    }
 public void delete(String maxe) {
        String sql = "Delete from Xe where MaXe=?";
        JdbcHelper.executeUpdate(sql, maxe);
    }

    public List<Xe> selectTong() {
        String sql = "SELECT A.MaCH, A.MaXe, A.TenXe, B.TenLX, A.SoKhung, A.DungTich, A.GiaTienBan , A.SoLuong, A.NamSX,  A.ThoiGianBH FROM Xe A, LoaiXe B where A.MaLX = B.MaLX ";
        return select(sql);
    }
    public List<Xe> selectTong(String MaCH) {
        String sql = "SELECT A.MaCH, A.MaXe, A.TenXe, B.TenLX, A.SoKhung, A.DungTich, A.GiaTienBan , A.SoLuong, A.NamSX,  A.ThoiGianBH FROM Xe A INNER JOIN CuaHang C on A.MaCH=C.MaCH, LoaiXe B where A.MaLX = B.MaLX and c.MaCH = ?";
        return select(sql,MaCH);
    }
    public List<Xe> findTenXe(String TenXe) {
        String sql = "SELECT A.MaCH, A.MaXe, A.TenXe, B.TenLX, A.SoKhung, A.DungTich, A.GiaTienBan , A.SoLuong, A.NamSX,  A.ThoiGianBH FROM Xe A, LoaiXe B where A.MaLX = B.MaLX and A.TenXe like N'%"+TenXe+"%'";
        return select(sql);
    }
    public List<Xe> findTenXe(String TenXe,String MaCH) {
        String sql = "SELECT A.MaCH, A.MaXe, A.TenXe, B.TenLX, A.SoKhung, A.DungTich, A.GiaTienBan , A.SoLuong, A.NamSX,  A.ThoiGianBH FROM Xe A  INNER JOIN CuaHang C on A.MaCH=C.MaCH, LoaiXe B  where A.MaLX = B.MaLX and A.TenXe like N'%"+TenXe+"%' and C.MaCH =?";
        return select(sql,MaCH);
    }

    public List<Xe> findMaNV(String MaXe){
        String sql = "SELECT A.MaCH, A.MaXe, A.TenXe, B.TenLX, A.SoKhung, A.DungTich, A.GiaTienBan , A.SoLuong, A.NamSX,  A.ThoiGianBH FROM Xe A, LoaiXe B where A.MaLX = B.MaLX and A.MaXe like N'%"+MaXe+"%'";
        return select(sql);
    }
     public List<Xe> findMaNV(String MaXe,String MaCH){
        String sql = "SELECT A.MaCH, A.MaXe, A.TenXe, B.TenLX, A.SoKhung, A.DungTich, A.GiaTienBan , A.SoLuong, A.NamSX,  A.ThoiGianBH FROM Xe A  INNER JOIN CuaHang C on A.MaCH=C.MaCH, LoaiXe B  where A.MaLX = B.MaLX and A.MaXe like N'%"+MaXe+"%' and C.MaCH =?";
        return select(sql,MaCH);
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
        model.setTenLx(rs.getString("TenLX"));
        model.setNamSx(rs.getInt("NamSX"));
        model.setDungTich(rs.getInt("DungTich"));
        model.setGiaTienBan(rs.getFloat("GiaTienBan"));
        model.setSoLuong(rs.getInt("SoLuong"));
        model.setThoiGianBh(rs.getInt("ThoiGianBH"));
        model.setSoKhung(rs.getString("SoKhung"));
   
        return model;
    }

    public List<Xe> selectBySql(String sql, Object... args) {
        List<Xe> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {
                Xe xe = new Xe();
                xe.setMaXe(rs.getString(1));
                xe.setMaCH(rs.getString(2));
                xe.setTenXe(rs.getString(3));
                xe.setTenLx(rs.getString(4));
                xe.setNamSx(rs.getInt(5));
                xe.setDungTich(rs.getInt(6));
                xe.setGiaTienBan(rs.getFloat(7));
                xe.setSoLuong(rs.getInt(8));
                xe.setThoiGianBh(rs.getInt(9));
                xe.setSoKhung(rs.getString(10));
                xe.setHinh(rs.getString(11));
                list.add(xe);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public List<Xe> selectByKeyWord(String keyWord) {
        String sql = "SELECT * FROM NhaCungCap WHERE TenXe LIKE ?";
        return this.selectBySql(sql, "%" + keyWord + "%");
    }

    public Xe selectByIdTimKiem(String ma) {
        String sql = "SELECT * FROM Xe WHERE MaXe = ?";
        List<Xe> list = this.selectBySql(sql, ma);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
