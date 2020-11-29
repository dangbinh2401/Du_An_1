package com.xemay.dao;

import com.xemay.helper.JdbcHelper;
import com.xemay.model.NhaCungCap;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NhaCungCapDAO {
    public void insert(NhaCungCap model){
        String sql = "INSERT INTO NhaCungCap (MaNCC, TenNCC, DiaChi, SoDienThoai"
                + ", Email) VALUES (?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql,model.getMaNcc(),model.getTenNcc(),
                model.getDiaChi(),model.getSdt(),model.getEmail());
    }
    
    public void update(NhaCungCap model){
        String sql = "UPDATE NhaCungCap SET TenNCC =?, DiaChi =?, SoDienThoai =?"
                + ", Email =? WHERE MaNCC =?";
        JdbcHelper.executeUpdate(sql,model.getTenNcc(),model.getDiaChi(),
                model.getSdt(),model.getEmail(),model.getMaNcc());
    }
    
    public void delete(String ma) {
        String sql = "DELETE NhaCungCap WHERE MaNCC=?";
        try {
            JdbcHelper.executeUpdate(sql,ma);
        } catch (Exception ex) {
            System.out.println("Lỗi");
        }
    }
    
    protected List<NhaCungCap> selectBySql(String sql, Object... args) {
        List<NhaCungCap> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, args);
            while (rs.next()) {                
                NhaCungCap nhaCungCap = new NhaCungCap();
                nhaCungCap.setMaNcc(rs.getString(1));
                nhaCungCap.setTenNcc(rs.getString(2));
                nhaCungCap.setDiaChi(rs.getString(3));
                nhaCungCap.setSdt(rs.getString(4));
                nhaCungCap.setEmail(rs.getString(5));
                list.add(nhaCungCap);

            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }   
    
    public List<NhaCungCap> selectAll() {
        String sql = "SELECT * FROM NhaCungCap";
        return this.selectBySql(sql);
    }
    
    public List<NhaCungCap> selectByKeyWord(String keyWord){
        String sql = "SELECT * FROM NhaCungCap WHERE TenNCC LIKE ?";
        return this.selectBySql(sql,"%"+keyWord+"%");
    }
    
    public List<NhaCungCap> selectByKeyWord1(String keyWord){
        String sql = "select * from NhaCungCap where MaNcc LIKE ?";
        return this.selectBySql(sql,"%"+keyWord+"%");
    } 
}
