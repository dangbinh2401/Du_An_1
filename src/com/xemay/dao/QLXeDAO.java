package com.xemay.dao;

import com.xemay.helper.JdbcHelper;
import com.xemay.model.Xe;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class QLXeDAO {
    public void insert(Xe model){
        String sql = "INSERT INTO Xe(MaXe, MaCH, TenXe, MaLX, NamSX, DungTich, GiaTienBan, SoLuong, ThoiGianBH, SoKhung, Anh) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql,model.getMaXe(),model.getMaCH(),
                model.getTenXe(),model.getMaLX(),model.getNamSx(),model.getDungTich(),
                model.getGiaTienBan(),model.getSoLuong(),model.getThoiGianBh(),model.getSoKhung(),model.getHinh());
    }
    
    public void update(Xe model){
        String sql = "UPDATE Xe SET MaCH = ?, TenXe = ?, MaLX = ?, NamSX = ?, DungTich = ?, GiaTienBan = ?, SoLuong = ?, ThoiGianBH = ?, SoKhung = ?, Anh = ? WHERE MaXe = ?";
        JdbcHelper.executeUpdate(sql,model.getMaCH(),
                model.getTenXe(),model.getMaLX(),model.getNamSx(),model.getDungTich(),
                model.getGiaTienBan(),model.getSoLuong(),model.getThoiGianBh(),model.getSoKhung(),model.getHinh(),model.getMaXe());
    }
    
    public void delete(String ma){
        String sql = "DELETE FROM Xe WHERE MaXe = ?";
        try {
            JdbcHelper.executeUpdate(sql,ma);
        } catch (Exception e) {
            System.out.println("Lỗi");
        }
    }
    
    public List<Xe> selectBySql(String sql, Object... args){
        List<Xe> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {                
                Xe xe = new Xe();
                xe.setMaXe(rs.getString(1));
                xe.setMaCH(rs.getString(2));
                xe.setTenXe(rs.getString(3));
                xe.setMaLX(rs.getString(4));
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
    
    public List<Xe> selectAll() {
        String sql = "SELECT * FROM Xe";
        return this.selectBySql(sql);
    }
    
    public List<Xe> selectByKeyWord(String keyWord){
        String sql = "SELECT * FROM NhaCungCap WHERE TenXe LIKE ?";
        return this.selectBySql(sql,"%"+keyWord+"%");
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
