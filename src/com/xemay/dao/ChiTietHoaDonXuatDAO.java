
package com.xemay.dao;

import com.xemay.helper.JdbcHelper;
import com.xemay.model.ChiTietHdx;
import com.xemay.model.HoaDonXuat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ChiTietHoaDonXuatDAO {
    public void insert(ChiTietHdx model) {
        String sql = "INSERT INTO ChiTietHDX (MaHDX, MaXe, SoLuong) VALUES (?, ?, ?)";
        JdbcHelper.executeUpdate(sql, model.getMaHDX(), model.getMaXe(), model.getSoLuong());
    }

    public void update(ChiTietHdx model) {
        String sql = "UPDATE ChiTietHDX  SET  SoLuong=? WHERE  MaHDX=? and MaXE=?";
        JdbcHelper.executeUpdate(sql, model.getSoLuong(), model.getMaHDX(),model.getMaXe());
    }

    public List<ChiTietHdx> selectAll(String MaHDX) {
        String sql = "select MaHDX,a.MaXe,TenXe,b.GiaTienBan,b.SoLuong from ChiTietHDX a inner join Xe b on a.MaXe = b.MaXe  where MaHDX = '"+MaHDX+"'";
        return select(sql);
    }
    public List<ChiTietHdx> findTenXe(String TenXe) {
        String sql = "select MaHDX,a.MaXe,TenXe,b.GiaTienBan,b.SoLuong from ChiTietHDX a inner join Xe b on a.MaXe = b.MaXe  where TenXe like N'%"+TenXe+"%'";
        return select(sql);
    }
        private List<ChiTietHdx> select(String sql, Object... args) {
        List<ChiTietHdx> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    ChiTietHdx model = readFromResultSet(rs);
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

    private ChiTietHdx readFromResultSet(ResultSet rs) throws SQLException {
        ChiTietHdx model = new ChiTietHdx();
        model.setMaHDX(rs.getString("MaHDX"));
        model.setMaXe(rs.getString("MaXe"));
        model.setTenXe(rs.getString("TenXe"));
        model.setGiaTienBan(rs.getString("GiaTienBan"));
        model.setSoLuong(rs.getInt("SoLuong"));
        return model;
    }
}
