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
    
    private List<NhaCungCap> select(String sql, Object... args){
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
        } catch (Exception e) {
        }
        return list;
    }
    
    public List<NhaCungCap> select() {
        String sql = "SELECT * FROM NhaCungCap";
        return select(sql);
    }
}
