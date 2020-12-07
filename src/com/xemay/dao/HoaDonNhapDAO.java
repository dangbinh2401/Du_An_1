package com.xemay.dao;

import com.xemay.helper.JdbcHelper;
import com.xemay.model.HoaDonNhap;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HoaDonNhapDAO {
        public void insert(HoaDonNhap model) {
        String sql = "INSERT INTO HoaDonNhap (MaHDN, MaNV, MaNCC, NgayNhap) VALUES (?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql, model.getMaHDN(), model.getMaNV(), model.getMaNCC(), model.getNgayNhap());
    }

    public void update(HoaDonNhap model) {
        String sql = "UPDATE HoaDonNhap  SET MaNV=?, MaNCC=?, NgayNhap=? WHERE  MaHDN=?";
        JdbcHelper.executeUpdate(sql,  model.getMaNV(), model.getMaNCC(), model.getNgayNhap(), model.getMaHDN());
    }
    
    public void delete(String MaHDN){
        String sql = "DELETE FROM HoaDonNhap WHERE MaHDN=?";
        JdbcHelper.executeUpdate(sql, MaHDN);
    }

    public List<HoaDonNhap> selectAll() {
        String sql = "select a.MaHDN , a.MaNV, a.MaNCC, a.NgayNhap , b.TenNCC, c.HoTen, b.SoDienThoai from HoaDonNhap a inner join NhaCungCap b on a.MaNCC = b.MaNCC inner join NhanVien c on a.MaNV = c.MaNV";
        return select(sql);
    }
    public List<HoaDonNhap> selectAll(String MaCH) {
        String sql = "select a.MaHDN , a.MaNV, a.MaNCC, a.NgayNhap , b.TenNCC, c.HoTen, b.SoDienThoai from HoaDonNhap a inner join NhaCungCap b on a.MaNCC = b.MaNCC inner join NhanVien c on a.MaNV = c.MaNV inner join  CuaHang d on c.MaCH = d.MaCH where d.MaCH=?";
        return select(sql,MaCH);
    }
    public List<HoaDonNhap> selectAll(String MaCH,String MaNV) {
        String sql = "select a.MaHDN , a.MaNV, a.MaNCC, a.NgayNhap , b.TenNCC, c.HoTen, b.SoDienThoai from HoaDonNhap a inner join NhaCungCap b on a.MaNCC = b.MaNCC inner join NhanVien c on a.MaNV = c.MaNV inner join  CuaHang d on c.MaCH = d.MaCH where d.MaCH=? and c.MaNV =?";
        return select(sql,MaCH,MaNV);
    }
    
    public List<HoaDonNhap> findTenNCC(String TenNCC){
        String sql = "select a.MaHDN , a.MaNV, a.MaNCC, a.NgayNhap , b.TenNCC, c.HoTen,b.SoDienThoai from HoaDonNhap a inner join NhaCungCap b on a.MaNCC = b.MaNCC inner join NhanVien c on a.MaNV = c.MaNV where b.TenNCC like N'%"+TenNCC+"%'";
        return select(sql);
    }
    public List<HoaDonNhap> findTenNCC(String TenNCC,String MaCH){
        String sql = "select a.MaHDN , a.MaNV, a.MaNCC, a.NgayNhap , b.TenNCC, c.HoTen, b.SoDienThoai from HoaDonNhap a inner join NhaCungCap b on a.MaNCC = b.MaNCC inner join NhanVien c on a.MaNV = c.MaNV inner join  CuaHang d on c.MaCH = d.MaCH where b.TenNCC like N'%"+TenNCC+"%' and d.MaCH=?";
        return select(sql,MaCH);
    }
    public List<HoaDonNhap> findTenNCC(String TenNCC,String MaCH,String MaNV){
        String sql = "select a.MaHDN , a.MaNV, a.MaNCC, a.NgayNhap , b.TenNCC, c.HoTen, b.SoDienThoai from HoaDonNhap a inner join NhaCungCap b on a.MaNCC = b.MaNCC inner join NhanVien c on a.MaNV = c.MaNV inner join  CuaHang d on c.MaCH = d.MaCH where b.TenNCC like N'%"+TenNCC+"%' and d.MaCH=? and c.MaNV =?";
        return select(sql,MaCH,MaNV);
    }
    public List<HoaDonNhap> findTenNV(String TenNV){
        String sql = "select a.MaHDN , a.MaNV, a.MaNCC, a.NgayNhap , b.TenNCC, c.HoTen,b.SoDienThoai from HoaDonNhap a inner join NhaCungCap b on a.MaNCC = b.MaNCC inner join NhanVien c on a.MaNV = c.MaNV where c.HoTen like N'%"+TenNV+"%'";
        return select(sql);
    }
    public List<HoaDonNhap> findTenNV(String TenNV,String CuaHang){
        String sql = "select a.MaHDN , a.MaNV, a.MaNCC, a.NgayNhap , b.TenNCC, c.HoTen,b.SoDienThoai from HoaDonNhap a inner join NhaCungCap b on a.MaNCC = b.MaNCC inner join NhanVien c on a.MaNV = c.MaNV inner join  CuaHang d on c.MaCH = d.MaCH where c.HoTen like N'%"+TenNV+"%' and d.MaCH=?";
        return select(sql,CuaHang);
    }
    private List<HoaDonNhap> select(String sql, Object... args) {
        List<HoaDonNhap> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    HoaDonNhap model = readFromResultSet(rs);
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

    private HoaDonNhap readFromResultSet(ResultSet rs) throws SQLException {
        HoaDonNhap model = new HoaDonNhap();
        model.setMaHDN(rs.getString("MaHDN"));
        model.setMaNV(rs.getString("MaNV"));
        model.setMaNCC(rs.getString("MaNCC"));
        model.setNgayNhap(rs.getDate("NgayNhap"));
        model.setTenNCC(rs.getString("TenNCC"));
        model.setTenNV(rs.getString("HoTen"));
        model.setSDT(rs.getString("SoDienThoai"));
        return model;
    }
}
