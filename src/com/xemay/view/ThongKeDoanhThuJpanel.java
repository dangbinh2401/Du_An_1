/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.view;

import com.xemay.dao.CuaHangDAO;
import com.xemay.dao.DoanhThuDAO;
import com.xemay.model.CuaHang;
import com.xemay.model.DoanhThu;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class ThongKeDoanhThuJpanel extends javax.swing.JPanel {

    /**
     * Creates new form ThongKeXeBanChayJPanel
     */
    public ThongKeDoanhThuJpanel() {
        initComponents();
        fillMaCH();
        fillTable();
    }
    DoanhThuDAO dao = new DoanhThuDAO();
    List<DoanhThu> list;

    void fillMaCH() {
        CuaHangDAO dao = new CuaHangDAO();
        List<CuaHang> list = dao.select();
        cboTimKiem14.removeAllItems();
        cboTimKiem14.addItem("Tất cả các cửa hàng");
        for (CuaHang cuaHang : list) {
            cboTimKiem14.addItem(cuaHang.getTenCuaHang());
        }
    }

    void fillTable() {
        if (cboTimKiem14.getSelectedItem().equals("Tất cả các cửa hàng")) {
            list = dao.getDoanhThuNV();
            fill();
        } else {
            String TenCh = cboTimKiem14.getSelectedItem().toString();
            list = dao.Select(TenCh);
            fill();

        }
    }

    void fill() {
        DefaultTableModel model = (DefaultTableModel) tblDoanhThu.getModel();
        model.setRowCount(0);
        try {
            int i = 1;
            for (DoanhThu ch : list) {
                Object[] row = {
                    i,
                    ch.getTenCH(),
                    ch.getTongNhap(),
                    ch.getDoanhThu(),
                    Float.valueOf(ch.getDoanhThu()) - Float.valueOf(ch.getTongNhap())
                };
                model.addRow(row);
                i++;
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

        QuanLyNhanVien4 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        tblDoanhThu = new javax.swing.JTable();
        cboTimKiem14 = new javax.swing.JComboBox<String>();
        jButton37 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        QuanLyNhanVien4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel33.setText("BÁO CÁO THỐNG KÊ: DOANH THU");

        tblDoanhThu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên cửa hàng", "Tổng tiền nhập", "Doanh Thu", "Lợi Nhuận"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDoanhThu.setRowHeight(30);
        jScrollPane13.setViewportView(tblDoanhThu);

        cboTimKiem14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboTimKiem14.setMinimumSize(new java.awt.Dimension(138, 35));
        cboTimKiem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTimKiem14ActionPerformed(evt);
            }
        });

        jButton37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton37.setText("In thống kê");

        javax.swing.GroupLayout QuanLyNhanVien4Layout = new javax.swing.GroupLayout(QuanLyNhanVien4);
        QuanLyNhanVien4.setLayout(QuanLyNhanVien4Layout);
        QuanLyNhanVien4Layout.setHorizontalGroup(
            QuanLyNhanVien4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuanLyNhanVien4Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(QuanLyNhanVien4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QuanLyNhanVien4Layout.createSequentialGroup()
                        .addComponent(cboTimKiem14, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 1715, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 169, Short.MAX_VALUE))
            .addGroup(QuanLyNhanVien4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(QuanLyNhanVien4Layout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1510, Short.MAX_VALUE)))
        );
        QuanLyNhanVien4Layout.setVerticalGroup(
            QuanLyNhanVien4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QuanLyNhanVien4Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(QuanLyNhanVien4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboTimKiem14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(342, 342, 342))
            .addGroup(QuanLyNhanVien4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(QuanLyNhanVien4Layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(jLabel33)
                    .addContainerGap(897, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1933, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(QuanLyNhanVien4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 946, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(QuanLyNhanVien4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboTimKiem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTimKiem14ActionPerformed
        fillTable();        // TODO add your handling code here:
    }//GEN-LAST:event_cboTimKiem14ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel QuanLyNhanVien4;
    private javax.swing.JComboBox<String> cboTimKiem14;
    private javax.swing.JButton jButton37;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JTable tblDoanhThu;
    // End of variables declaration//GEN-END:variables
}
