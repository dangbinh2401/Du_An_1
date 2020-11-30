package com.xemay.dao;

import com.xemay.helper.JdbcHelper;
import com.xemay.model.HoaDonXuat;
import com.xemay.model.TaiKhoan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class HoaDonXuatDAO {

    public void insert(HoaDonXuat model) {
        String sql = "INSERT INTO HoaDonXuat (MaHDX, MaNV, NgayXuat, MaKH) VALUES (?, ?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql, model.getMaHdx(), model.getMaNV(), model.getNgayXuat(), model.getMaKH());
    }

    public void update(HoaDonXuat model) {
        String sql = "UPDATE HoaDonXuat  SET MaNV=?, NgayXuat=?, MaKH=? WHERE  MaHDX=?";
        JdbcHelper.executeUpdate(sql, model.getMaNV(), model.getNgayXuat(), model.getMaKH(), model.getMaHdx());
    }

    public List<HoaDonXuat> selectAll() {
        String sql = "select a.MaHDX, a.MaNV,c.HoTen as 'TenNV', a.NgayXuat,a.MaKH,b.HoTen as 'TenKH',b.SoDienThoai as 'SDT' from HoaDonXuat a inner join KhachHang b on a.MaKH=b.MaKH inner join NhanVien c on a.MaNV = c.MaNV";
        return select(sql);
    }
    
    public List<HoaDonXuat> findTenKH(String TenKH){
        String sql = "select a.MaHDX, a.MaNV,c.HoTen as 'TenNV', a.NgayXuat,a.MaKH,b.HoTen as 'TenKH',b.SoDienThoai as 'SDT' from HoaDonXuat a inner join KhachHang b on a.MaKH=b.MaKH inner join NhanVien c on a.MaNV = c.MaNV where b.HoTen like N'%"+TenKH+"%'";
        return select(sql);
    }
    public List<HoaDonXuat> findTenNV(String TenNV){
        String sql = "select a.MaHDX, a.MaNV,c.HoTen as 'TenNV', a.NgayXuat,a.MaKH,b.HoTen as 'TenKH',b.SoDienThoai as 'SDT' from HoaDonXuat a inner join KhachHang b on a.MaKH=b.MaKH inner join NhanVien c on a.MaNV = c.MaNV where c.HoTen like N'%"+TenNV+"%'";
        return select(sql);
    }
    private List<HoaDonXuat> select(String sql, Object... args) {
        List<HoaDonXuat> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    HoaDonXuat model = readFromResultSet(rs);
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

    private HoaDonXuat readFromResultSet(ResultSet rs) throws SQLException {
        HoaDonXuat model = new HoaDonXuat();
        model.setMaHdx(rs.getString("MaHDX"));
        model.setMaNV(rs.getString("MaNV"));
        model.setNgayXuat(rs.getDate("NgayXuat"));
        model.setMaKH(rs.getString("MaKH"));
        model.setHoTenKH(rs.getString("TenKH"));
        model.setHoTenNhanVien(rs.getString("TenNV"));
        model.setSoDienThoai(rs.getString("SDT"));
        return model;
    }

}
