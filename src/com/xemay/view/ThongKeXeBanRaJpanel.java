/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.view;

import com.xemay.dao.CuaHangDAO;
import com.xemay.dao.ThongKeXBRDAO;
import com.xemay.helper.ShareHelper;
import com.xemay.helper.printPDF;
import com.xemay.model.CuaHang;
import com.xemay.model.ThongKeXeNV;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class ThongKeXeBanRaJpanel extends javax.swing.JPanel {

    /**
     * Creates new form ThongKeXeBanRa
     */
    ThongKeXBRDAO dao = new ThongKeXBRDAO();
    List<ThongKeXeNV> list;

    public ThongKeXeBanRaJpanel() {
        initComponents();
        fillMaCH();
        fillTable();
    }

    void fillMaCH() {
        CuaHangDAO dao = new CuaHangDAO();
        List<CuaHang> list = dao.select();
        cboTimKiem4.removeAllItems();
                if(ShareHelper.TaiKhoan.getVaiTro().equals("GiamDoc")){
            cboTimKiem4.addItem("Tất cả các cửa hàng");
        for (CuaHang cuaHang : list) {
            cboTimKiem4.addItem(cuaHang.getTenCuaHang());
        }
                cboTimKiem5.addItem("Tất cả các tháng");
        for (int i = 1; i <= 12; i++) {
            cboTimKiem5.addItem(String.valueOf(i));
        }
        }else{
            for (CuaHang cuaHang : list) {
                if(ShareHelper.TaiKhoan.getMaCH().equals(cuaHang.getMaCh())){
                    cboTimKiem4.addItem(cuaHang.getTenCuaHang());
                }
            }
            cboTimKiem5.addItem("Tất cả các tháng");
        }
    }

    void fillTable() {
        if (cboTimKiem4.getSelectedItem().equals("Tất cả các cửa hàng")) {
            list = dao.getXeBanRa();
            fill();
        } else {
            String TenCh = cboTimKiem4.getSelectedItem().toString();
            list = dao.Select(TenCh);
            fill();

        }
    }

    void TimkiemTheoThang() {
        if (cboTimKiem5.getSelectedItem().equals("Tất cả các tháng")) {
            list = dao.getXeBanRa();
            fill();
        } else {
            String TenCh = cboTimKiem5.getSelectedItem().toString();
            list = dao.SelectThang(TenCh);
            fill();

        }
    }

    void fill() {
        DefaultTableModel model = (DefaultTableModel) tblThongKeXe.getModel();
        model.setRowCount(0);
//            list = dao.Select("Chi nhánh 15");
        try {
//                list = dao.getXeNhapVao();
            int i = 1;
            for (ThongKeXeNV ch : list) {
                Object[] row = {
                    i,
                    ch.getTenCH(),
                    ch.getTenXe(),
                    ch.getSoLuong(),
                    ch.getGiaTien(),
                    ch.getTongTien()
                };
                model.addRow(row);
                i++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "lỗi truy vẫn dữ liệu");
        }
        float Tong = 0;
        int row = tblThongKeXe.getRowCount();
        for (int i = 0; i < row; i++) {
            Tong = Tong + Float.valueOf(tblThongKeXe.getModel().getValueAt(i, 5).toString());
        }
        NumberFormat formatter = new DecimalFormat("#,###,###");
        String formattedNumber = formatter.format(Tong);
        lblTong.setText(formattedNumber);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        QuanLyCuaHang = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblThongKeXe = new javax.swing.JTable();
        btnSapXep = new javax.swing.JButton();
        btnSapXep1 = new javax.swing.JButton();
        cboTimKiem4 = new javax.swing.JComboBox<String>();
        cboTimKiem5 = new javax.swing.JComboBox<String>();
        jLabel1 = new javax.swing.JLabel();
        lblTong = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        QuanLyCuaHang.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("BÁO CÁO THỐNG KÊ: XE BÁN RA");

        tblThongKeXe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblThongKeXe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Tên cửa hàng", "Tên xe", "Số lượng", "Giá tiền", "Tổng tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblThongKeXe.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblThongKeXe.setRowHeight(30);
        tblThongKeXe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThongKeXeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblThongKeXeMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblThongKeXeMouseReleased(evt);
            }
        });
        jScrollPane5.setViewportView(tblThongKeXe);

        btnSapXep.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSapXep.setText("Sắp xếp theo tên xe");
        btnSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXepActionPerformed(evt);
            }
        });

        btnSapXep1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSapXep1.setText("In thống kê ");
        btnSapXep1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXep1ActionPerformed(evt);
            }
        });

        cboTimKiem4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboTimKiem4.setToolTipText("");
        cboTimKiem4.setMinimumSize(new java.awt.Dimension(138, 35));
        cboTimKiem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTimKiem4ActionPerformed(evt);
            }
        });

        cboTimKiem5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboTimKiem5.setMinimumSize(new java.awt.Dimension(138, 35));
        cboTimKiem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTimKiem5ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Tổng");

        lblTong.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        javax.swing.GroupLayout QuanLyCuaHangLayout = new javax.swing.GroupLayout(QuanLyCuaHang);
        QuanLyCuaHang.setLayout(QuanLyCuaHangLayout);
        QuanLyCuaHangLayout.setHorizontalGroup(
            QuanLyCuaHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuanLyCuaHangLayout.createSequentialGroup()
                .addGroup(QuanLyCuaHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QuanLyCuaHangLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(QuanLyCuaHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1715, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addGroup(QuanLyCuaHangLayout.createSequentialGroup()
                                .addComponent(cboTimKiem4, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(cboTimKiem5, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(btnSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(btnSapXep1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QuanLyCuaHangLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTong, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        QuanLyCuaHangLayout.setVerticalGroup(
            QuanLyCuaHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QuanLyCuaHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(QuanLyCuaHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTimKiem4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSapXep1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTimKiem5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(QuanLyCuaHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTong, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(QuanLyCuaHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(QuanLyCuaHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblThongKeXeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThongKeXeMouseClicked

    }//GEN-LAST:event_tblThongKeXeMouseClicked

    private void tblThongKeXeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThongKeXeMousePressed

    }//GEN-LAST:event_tblThongKeXeMousePressed

    private void tblThongKeXeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThongKeXeMouseReleased

    }//GEN-LAST:event_tblThongKeXeMouseReleased

    private void btnSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXepActionPerformed
        Comparator<ThongKeXeNV> sortName = new Comparator<ThongKeXeNV>() {
            @Override
            public int compare(ThongKeXeNV s1, ThongKeXeNV s2) {
                return s1.getTenXe().toUpperCase().compareTo(s2.getTenXe().toUpperCase());
            }
        };
        Comparator<ThongKeXeNV> sortMaCH = new Comparator<ThongKeXeNV>() {
            @Override
            public int compare(ThongKeXeNV s1, ThongKeXeNV s2) {
                return String.valueOf(s2.getSoLuong()).compareTo(String.valueOf(s1.getSoLuong()));
            }
        };
        if (btnSapXep.getText().equals("Sắp xếp theo tên xe")) {
            Collections.sort(list, sortName);
            btnSapXep.setText("Sắp xếp theo số lượng ");
        } else {
            Collections.sort(list, sortMaCH);
            btnSapXep.setText("Sắp xếp theo tên xe");
        }
        DefaultTableModel model = (DefaultTableModel) tblThongKeXe.getModel();
        model.setRowCount(0);
        try {
            int i = 1;
            for (ThongKeXeNV ch : list) {
                Object[] row = {
                    i,
                    ch.getTenCH(),
                    ch.getTenXe(),
                    ch.getSoLuong(),
                    ch.getGiaTien(),
                    ch.getTongTien()
                };
                model.addRow(row);
                i++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "lỗi truy vẫn dữ liệu" + e);
        }
    }//GEN-LAST:event_btnSapXepActionPerformed

    private void btnSapXep1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXep1ActionPerformed
        printPDF print = new printPDF();
        try {
            print.printThongKe(list, lblTong.getText(),"BÁN RA");
            JOptionPane.showMessageDialog(this, "In thành công");
            try {
                Desktop.getDesktop().browse(new File("hoadon/ThongKeBanRa.pdf").toURI());
            } catch (IOException ex) {
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_btnSapXep1ActionPerformed

    private void cboTimKiem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTimKiem4ActionPerformed
        fillTable();
    }//GEN-LAST:event_cboTimKiem4ActionPerformed

    private void cboTimKiem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTimKiem5ActionPerformed
        TimkiemTheoThang();
    }//GEN-LAST:event_cboTimKiem5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel QuanLyCuaHang;
    private javax.swing.JButton btnSapXep;
    private javax.swing.JButton btnSapXep1;
    private javax.swing.JComboBox<String> cboTimKiem4;
    private javax.swing.JComboBox<String> cboTimKiem5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblTong;
    private javax.swing.JTable tblThongKeXe;
    // End of variables declaration//GEN-END:variables
}
