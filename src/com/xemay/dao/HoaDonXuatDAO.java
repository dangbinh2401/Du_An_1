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
        String sql = "INSERT INTO HoaDonXuat (MaHDX, MaNV, NgayXuat, MaKH) VALUES (?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql, model.getMaHdx(), model.getMaNV(), model.getNgayXuat(), model.getMaKH());
    }

    public void update(HoaDonXuat model) {
        String sql = "UPDATE HoaDonXuat  SET MaNV=?, NgayXuat=?, MaKH=? WHERE  MaHDX=?";
        JdbcHelper.executeUpdate(sql, model.getMaNV(), model.getNgayXuat(), model.getMaKH(), model.getMaHdx());
    }
    
    public void delete(String MaHDX){
        String sql = "DELETE FROM HoaDonXuat WHERE MaHDX=?";
        JdbcHelper.executeUpdate(sql, MaHDX);
    }

    public List<HoaDonXuat> selectAll() {
        String sql = "select a.MaHDX, a.MaNV,c.HoTen as 'TenNV', a.NgayXuat,a.MaKH,b.HoTen as 'TenKH',b.SoDienThoai as 'SDT' from HoaDonXuat a inner join KhachHang b on a.MaKH=b.MaKH inner join NhanVien c on a.MaNV = c.MaNV";
        return select(sql);
    }
    public List<HoaDonXuat> selectQuanLy(String MaCH) {
        String sql = "select a.MaHDX, a.MaNV,c.HoTen as 'TenNV', a.NgayXuat,a.MaKH,b.HoTen as 'TenKH',b.SoDienThoai as 'SDT',d.MaCH from HoaDonXuat a inner join KhachHang b on a.MaKH=b.MaKH inner join NhanVien c on a.MaNV = c.MaNV inner join CuaHang d on c.MaCH = d.MaCH where d.MaCH=?";
        return select(sql,MaCH);
    }
    public List<HoaDonXuat> selectNV(String MaCH,String MaNV) {
        String sql = "select a.MaHDX, a.MaNV,c.HoTen as 'TenNV', a.NgayXuat,a.MaKH,b.HoTen as 'TenKH',b.SoDienThoai as 'SDT',d.MaCH from HoaDonXuat a inner join KhachHang b on a.MaKH=b.MaKH inner join NhanVien c on a.MaNV = c.MaNV inner join CuaHang d on c.MaCH = d.MaCH where d.MaCH=? and c.MaNV=?";
        return select(sql,MaCH,MaNV);
    }
    public List<HoaDonXuat> findTenKH(String TenKH){
        String sql = "select a.MaHDX, a.MaNV,c.HoTen as 'TenNV', a.NgayXuat,a.MaKH,b.HoTen as 'TenKH',b.SoDienThoai as 'SDT' from HoaDonXuat a inner join KhachHang b on a.MaKH=b.MaKH inner join NhanVien c on a.MaNV = c.MaNV where b.HoTen like N'%"+TenKH+"%'";
        return select(sql);
    }
    public List<HoaDonXuat> findTenKH(String TenKH,String MaCH){
        String sql = "select a.MaHDX, a.MaNV,c.HoTen as 'TenNV', a.NgayXuat,a.MaKH,b.HoTen as 'TenKH',b.SoDienThoai as 'SDT' from HoaDonXuat a inner join KhachHang b on a.MaKH=b.MaKH inner join NhanVien c on a.MaNV = c.MaNV inner join CuaHang d on c.MaCH = d.MaCH where b.HoTen like N'%"+TenKH+"%' and d.MaCH=?";
        return select(sql,MaCH);
    }
    public List<HoaDonXuat> selectMaKH(String MaKH){
        String sql = "select a.MaHDX, a.MaNV,c.HoTen as 'TenNV', a.NgayXuat,a.MaKH,b.HoTen as 'TenKH',b.SoDienThoai as 'SDT' from HoaDonXuat a inner join KhachHang b on a.MaKH=b.MaKH inner join NhanVien c on a.MaNV = c.MaNV inner join CuaHang d on c.MaCH = d.MaCH where b.MaKH =?";
        return select(sql,MaKH);
    }
    public List<HoaDonXuat> findTenKH(String TenKH,String MaCH,String MaNV){
        String sql = "select a.MaHDX, a.MaNV,c.HoTen as 'TenNV', a.NgayXuat,a.MaKH,b.HoTen as 'TenKH',b.SoDienThoai as 'SDT' from HoaDonXuat a inner join KhachHang b on a.MaKH=b.MaKH inner join NhanVien c on a.MaNV = c.MaNV inner join CuaHang d on c.MaCH = d.MaCH where b.HoTen like N'%"+TenKH+"%' and d.MaCH=? and c.MaNV=?";
        return select(sql,MaCH,MaNV);
    }
    public List<HoaDonXuat> findTenNV(String TenNV){
        String sql = "select a.MaHDX, a.MaNV,c.HoTen as 'TenNV', a.NgayXuat,a.MaKH,b.HoTen as 'TenKH',b.SoDienThoai as 'SDT' from HoaDonXuat a inner join KhachHang b on a.MaKH=b.MaKH inner join NhanVien c on a.MaNV = c.MaNV where c.HoTen like N'%"+TenNV+"%'";
        return select(sql);
    }
    public List<HoaDonXuat> findTenNV(String TenNV,String MaCH){
        String sql = "select a.MaHDX, a.MaNV,c.HoTen as 'TenNV', a.NgayXuat,a.MaKH,b.HoTen as 'TenKH',b.SoDienThoai as 'SDT' from HoaDonXuat a inner join KhachHang b on a.MaKH=b.MaKH inner join NhanVien c on a.MaNV = c.MaNV inner join CuaHang d on c.MaCH = d.MaCH where c.HoTen like N'%"+TenNV+"%' and d.MaCH=?";
        return select(sql,MaCH);
    }
    public List<HoaDonXuat> findTenNV(String TenNV,String MaCH,String MaNV){
        String sql = "select a.MaHDX, a.MaNV,c.HoTen as 'TenNV', a.NgayXuat,a.MaKH,b.HoTen as 'TenKH',b.SoDienThoai as 'SDT' from HoaDonXuat a inner join KhachHang b on a.MaKH=b.MaKH inner join NhanVien c on a.MaNV = c.MaNV inner join CuaHang d on c.MaCH = d.MaCH where c.HoTen like N'%"+TenNV+"%' and d.MaCH=? and c.MaNV=?";
        return select(sql,MaCH,MaNV);
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
