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
    
    public List<BaoHang> selectAll() {
        String sql = "SELECT * FROM BaoHanh";
        return this.selectBySql(sql);
    }
    
    public List<BaoHang> selectByKeyWord(String keyWord){
        String sql = "SELECT * FROM NhaCungCap WHERE TenNCC LIKE ?";
        return this.selectBySql(sql,"%"+keyWord+"%");
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
