/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.view;

import com.xemay.dao.CuaHangDAO;
import com.xemay.model.CuaHang;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class CuaHangJPanel extends javax.swing.JPanel {

    /**
     * Creates new form cuaHangJPanel
     */
    public CuaHangJPanel() {
        initComponents();
        fillToTable();
    }
    CuaHangDAO dao = new CuaHangDAO(); 
    void fillToTable(){
        DefaultTableModel model = (DefaultTableModel) tblCuaHang.getModel(); 
        model.setRowCount(0); 
        try { 
            List<CuaHang> list = dao.select(); 
            for (CuaHang ch : list) { 
                Object[] row = { 
                    ch.getMaCh(), 
                    ch.getTenCuaHang(), 
                    ch.getDiaChi(), 
                    ch.getSdt(), 
                    ch.getEmail()
                }; 
                model.addRow(row); 
            } 
        }  
        catch (Exception e) { 
            JOptionPane.showMessageDialog(this, "lỗi truy vẫn dữ liệu");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        QuanLyCuaHang = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        cboTimKiem1 = new javax.swing.JComboBox<>();
        jTextField5 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblCuaHang = new javax.swing.JTable();
        jButton27 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();

        QuanLyCuaHang.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("QUẢN LÝ SHOWROOM");

        cboTimKiem1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboTimKiem1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tìm kiếm theo tên", "Tìm kiếm theo mã" }));
        cboTimKiem1.setMinimumSize(new java.awt.Dimension(138, 35));

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField5.setMinimumSize(new java.awt.Dimension(6, 35));

        tblCuaHang.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblCuaHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Cửa Hàng", "Tên Cửa Hàng", "Địa Chỉ", "Số Điện Thoại", "Email"
            }
        ));
        tblCuaHang.setRowHeight(30);
        jScrollPane5.setViewportView(tblCuaHang);

        jButton27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton27.setText("Chỉnh sửa");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton26.setText("Tạo mới");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton25.setText("Sắp xếp theo tên");

        jButton24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton24.setText("Tìm kiếm");

        jButton28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton28.setText("Xóa");

        javax.swing.GroupLayout QuanLyCuaHangLayout = new javax.swing.GroupLayout(QuanLyCuaHang);
        QuanLyCuaHang.setLayout(QuanLyCuaHangLayout);
        QuanLyCuaHangLayout.setHorizontalGroup(
            QuanLyCuaHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuanLyCuaHangLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(QuanLyCuaHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QuanLyCuaHangLayout.createSequentialGroup()
                        .addComponent(cboTimKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1715, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );
        QuanLyCuaHangLayout.setVerticalGroup(
            QuanLyCuaHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuanLyCuaHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(QuanLyCuaHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTimKiem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(QuanLyCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(QuanLyCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        ThemCuaHang themCH = new ThemCuaHang(null, true);
        themCH.show();
        fillToTable();
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        ThemCuaHang capNhatCH = new ThemCuaHang(null, true);
        capNhatCH.btnThemCuaHang.setText("Cập nhật");
        capNhatCH.show();
        fillToTable();
    }//GEN-LAST:event_jButton27ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel QuanLyCuaHang;
    private javax.swing.JComboBox<String> cboTimKiem1;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTable tblCuaHang;
    // End of variables declaration//GEN-END:variables
}
