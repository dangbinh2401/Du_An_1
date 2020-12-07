/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.dao;

import com.xemay.helper.JdbcHelper;
import com.xemay.model.TinNhan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class TinNhanDAO {
        public List<TinNhan> selectAll(String NguoiGui, String NguoiNhan) {
            //select * from TinNhan where MaNguoiGui='TK00000001' AND MaNguoiNhan='TK00000002' or  MaNguoiGui='TK00000002' and MaNguoiNhan='TK00000001'
        String sql = "select * from TinNhan where MaNguoiGui=? AND MaNguoiNhan=? or  MaNguoiGui=? and MaNguoiNhan=?";
        return select(sql,NguoiGui,NguoiNhan,NguoiNhan,NguoiGui);
    }
        public void insert(TinNhan model) {
        //String MaCh, String TenCuaHang, String DiaChi, String Sdt, String Email
        String sql = "INSERT INTO TinNhan (MaNguoiGui, MaNguoiNhan, NoiDung) VALUES (?, ?, ?)";
        JdbcHelper.executeUpdate(sql, model.getMaNguoiGui(), model.getMaNguoiNhan(), model.getNoiDung());
    }


    private List<TinNhan> select(String sql, Object... args) {
        List<TinNhan> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    TinNhan model = readFromResultSet(rs);
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

    private TinNhan readFromResultSet(ResultSet rs) throws SQLException {
        TinNhan model = new TinNhan();
        model.setMaNguoiGui(rs.getString("MaNguoiGui"));
        model.setMaNguoiNhan(rs.getString("MaNguoiNhan"));
        model.setNoiDung(rs.getString("NoiDung"));
        model.setThoiGian(rs.getDate("ThoiGian"));
        return model;
    }
    
}
