package com.xemay.dao;

import com.xemay.helper.JdbcHelper;
import com.xemay.model.NhaCungCap;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NhaCungCapDAO {

    public void insert(NhaCungCap model) {
        String sql = "INSERT INTO NhaCungCap (MaNCC, TenNCC, DiaChi, SoDienThoai, Email, Kt) VALUES (?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql, model.getMaNcc(), model.getTenNcc(),
                model.getDiaChi(), model.getSdt(), model.getEmail(), 1);
    }

    public void update(NhaCungCap model) {
        String sql = "UPDATE NhaCungCap SET TenNCC = ?, DiaChi = ?, SoDienThoai = ?, Email = ? WHERE MaNCC = ?";
        JdbcHelper.executeUpdate(sql, model.getTenNcc(), model.getDiaChi(),
                model.getSdt(), model.getEmail(), model.getMaNcc());
    }

    public void delete(String ma) {
        String sql = "update NhaCungCap set Kt = 0 where MaNCC =?";
        try {
            JdbcHelper.executeUpdate(sql, ma);
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

    public NhaCungCap selectByIdTxt(String ma) {
        String sql = "select * from NhaCungCap where MaNcc= ?";
        List<NhaCungCap> list = this.selectBySql(sql, ma);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<NhaCungCap> selectAll() {
        String sql = "select * from NhaCungCap where Kt = 1";
        return this.selectBySql(sql);
    }

    public List<NhaCungCap> selectByKeyWord(String keyWord) {
        String sql = "SELECT * FROM NhaCungCap WHERE TenNCC LIKE ?";
        return this.selectBySql(sql, "%" + keyWord + "%");
    }

    public List<NhaCungCap> selectByKyId(String keyWord) {
        String sql = "select * from NhaCungCap where MaNcc LIKE ?";
        return this.selectBySql(sql, "%" + keyWord + "%");
    }
}
