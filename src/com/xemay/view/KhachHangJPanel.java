/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.view;

import com.xemay.dao.KhachHangDao;
import com.xemay.model.KhachHang;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class KhachHangJPanel extends javax.swing.JPanel {

    /**
     * Creates new form khachHangJPanel
     */
    public KhachHangJPanel() {
        initComponents();
        fillToTable();

    }
    KhachHangDao dao = new KhachHangDao();

    void fillToTable() {
        DefaultTableModel model = (DefaultTableModel) tblKhachHang.getModel();
        model.setRowCount(0);
        try {
            List<KhachHang> list = dao.select();
            for (KhachHang ch : list) {
                Object[] row = {
                    ch.getMaTk(),
                    ch.getMaKh(),
                    ch.getHoTen(),
                    ch.getSdt(),
                    ch.getDiaChi(),
                    ch.getEmail(),
                    ch.getGioiTinh()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "lỗi truy vẫn dữ liệu");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        QuanLyKhachHang = new javax.swing.JPanel();
        jButton35 = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        cboTimKiem3 = new javax.swing.JComboBox<String>();
        jButton37 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        jButton38 = new javax.swing.JButton();

        QuanLyKhachHang.setBackground(new java.awt.Color(255, 255, 255));

        jButton35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton35.setText("Sắp xếp theo tên");

        jButton34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton34.setText("Tìm kiếm");

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField7.setMinimumSize(new java.awt.Dimension(6, 35));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setText("QUẢN LÝ KHÁCH HÀNG");

        cboTimKiem3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboTimKiem3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tìm kiếm theo tên", "Tìm kiếm theo mã" }));
        cboTimKiem3.setMinimumSize(new java.awt.Dimension(138, 35));

        jButton37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton37.setText("Chỉnh sửa");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        jButton36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton36.setText("Tạo mới");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        tblKhachHang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã tài khoản", "Mã Khách Hàng", "Tên Khách Hàng", "Số Điện Thoại", "Email", "Địa Chỉ", "Giới tính"
            }
        ));
        tblKhachHang.setRowHeight(30);
        jScrollPane7.setViewportView(tblKhachHang);

        jButton38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton38.setText("Xóa");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout QuanLyKhachHangLayout = new javax.swing.GroupLayout(QuanLyKhachHang);
        QuanLyKhachHang.setLayout(QuanLyKhachHangLayout);
        QuanLyKhachHangLayout.setHorizontalGroup(
            QuanLyKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuanLyKhachHangLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(QuanLyKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QuanLyKhachHangLayout.createSequentialGroup()
                        .addComponent(cboTimKiem3, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)
                        .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel20)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1715, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );
        QuanLyKhachHangLayout.setVerticalGroup(
            QuanLyKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuanLyKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(QuanLyKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTimKiem3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(751, 751, 751))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1840, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(QuanLyKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1013, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(QuanLyKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
        ThemKhachHang themKH = new ThemKhachHang(null, true);
        themKH.show();
        fillToTable();
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        ThemKhachHang capnhatKH = new ThemKhachHang(null, true);
        capnhatKH.btnThemKhachHang.setText("Cập nhật");
        capnhatKH.show();
        fillToTable();
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        String tkk = JOptionPane.showInputDialog(this, "Nhập mã tài khoản: ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        int traloi = JOptionPane.showConfirmDialog(null, "Bạn có muốn khách hàng có mã:  " + tkk, "Yes/No", JOptionPane.YES_NO_CANCEL_OPTION);
        if (traloi == 0) {
            KhachHangDao kh = new KhachHangDao();
            try {
                kh.delete(tkk);
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                fillToTable();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
        }

    }//GEN-LAST:event_jButton38ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel QuanLyKhachHang;
    private javax.swing.JComboBox<String> cboTimKiem3;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTable tblKhachHang;
    // End of variables declaration//GEN-END:variables
}
