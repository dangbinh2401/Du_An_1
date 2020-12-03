package com.xemay.dao;
import com.xemay.helper.JdbcHelper;
import com.xemay.model.BaoHang;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class BaoHanhDAO {
    public void insert(BaoHang model){
        String sql = "INSERT INTO BaoHanh (MaBH, MaXe, MaNV, NgayBH, MaKH, NoiDungBH) VALUES (?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql,model.getMaBh(),model.getMaXe(),model.getMaNv(),model.getNgayBaoHanh(),model.getMaKh(),model.getNoidungBh());
    }
    
    public void update(BaoHang model){
        String sql = "UPDATE BaoHanh SET MaXe =?, MaNV =?, NgayBH =?, MaKH =?, NoiDungBH =? WHERE MaBH =?";
        JdbcHelper.executeUpdate(sql,model.getMaXe(),model.getMaNv(),model.getNgayBaoHanh(),model.getMaKh(),model.getNoidungBh(),model.getMaBh());
    }
    
    public void delete(String ma){
        String sql = "DELETE FROM BaoHanh WHERE MaBH =?";
        try {
            JdbcHelper.executeUpdate(sql,ma);
        } catch (Exception e) {
            System.out.println("Lỗi");
        }
    }
    
    public List<BaoHang> selectBySql(String sql, Object... args){
        List<BaoHang> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {                
                BaoHang baoHang = new BaoHang();
                baoHang.setMaBh(rs.getString(1));
                baoHang.setMaXe(rs.getString(2));
                baoHang.setMaNv(rs.getString(3));
                baoHang.setNgayBaoHanh(rs.getDate(4));
                baoHang.setMaKh(rs.getString(5));
                baoHang.setNoidungBh(rs.getString(6));
                list.add(baoHang);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    
    public List<BaoHang> selectBySqlAll(String sql, Object... args){
        List<BaoHang> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {                
                BaoHang baoHang = new BaoHang();
                baoHang.setMaBh(rs.getString("MaBH"));
                baoHang.setMaKh(rs.getString("MaKH"));
                baoHang.setMaXe(rs.getString("MaXe"));
                baoHang.setMaNv(rs.getString("MaNV"));
                baoHang.setTenKhachHang(rs.getString("HoTen"));
                baoHang.setTenXe(rs.getString("TenXe"));
                baoHang.setNgayBaoHanh(rs.getDate("NgayBH"));
                baoHang.setNoidungBh(rs.getString("NoiDungBH"));
                
                list.add(baoHang);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
    
    public List<BaoHang> selectAll() {
        String sql = "SELECT A.MaBH,B.HoTen,C.TenXe,A.NgayBH,A.NoiDungBH,B.MaKH,A.MaNV,C.MaXe FROM"
                + " BaoHanh A inner join KhachHang B on A.MaKH = B.MaKH inner"
                + " join Xe C on A.MaXe = C.MaXe";
        return this.selectBySqlAll(sql);
    }
    
    public List<BaoHang> selectByKeyWord(String keyWord){
        String sql = "SELECT A.MaBH,B.HoTen,C.TenXe, A.MaNV, A.NgayBH,A.NoiDungBH,B.MaKH,C.MaXe"
                + " FROM BaoHanh A inner join KhachHang B on A.MaKH = B.MaKH inner"
                + " join Xe C on A.MaXe = C.MaXe where A.MaBH like ?";
        return this.selectBySqlAll(sql,"%"+keyWord+"%");
    }
    
    public List<BaoHang> selectByTenKh(String keyWord){
        String sql = "SELECT A.MaBH,B.HoTen,C.TenXe,A.NgayBH,A.NoiDungBH,B.MaKH,"
                + " C.MaXe FROM BaoHanh A inner join KhachHang B on A.MaKH = B.MaKH"
                + " inner join Xe C on A.MaXe = C.MaXe where B.HoTen like ?";
        return this.selectBySqlAll(sql,"%"+keyWord+"%");
    }
    
    public List<BaoHang> selectByTenXe(String keyWord){
        String sql = "SELECT A.MaBH,B.HoTen,C.TenXe,A.NgayBH,A.NoiDungBH,B.MaKH,C.MaXe"
                + " FROM BaoHanh A inner join KhachHang B on A.MaKH = B.MaKH inner"
                + " join Xe C on A.MaXe = C.MaXe where C.TenXe like ?";
        return this.selectBySqlAll(sql,"%"+keyWord+"%");
    }
    
    public BaoHang selectByIdTimKiem(String ma) {
        String sql = "SELECT * FROM BaoHanh WHERE MaBH =?";
        List<BaoHang> list = this.selectBySql(sql, ma);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
