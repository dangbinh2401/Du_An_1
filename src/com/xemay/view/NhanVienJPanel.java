/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.view;

import com.xemay.dao.NhanVienDAO;
import com.xemay.helper.ShareHelper;
import com.xemay.model.NhanVien;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class NhanVienJPanel extends javax.swing.JPanel {

    public String VaiTro = ShareHelper.TaiKhoan.getVaiTro();
    public String MaCH = ShareHelper.TaiKhoan.getMaCH();
    public String MaNV = ShareHelper.TaiKhoan.getMaNV();

    public NhanVienJPanel() {
        initComponents();
        list = select();
        fillToTable(list);
        cboTimKiem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = cboTimKiem2.getSelectedIndex();
                if (i >=0 ) {
                    timKiem();
                }

            }
        });
        txtTimKiem.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                timKiem();
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                timKiem();
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                timKiem();
            }
        });
    }

    List<NhanVien> select() {
        List<NhanVien> temp = null;
        if (VaiTro.equals("GiamDoc")) {
            temp = dao.select();
        } else {
            temp = dao.select(MaCH);
        }
        return temp;
    }

    void fillChinhSua() {
        ThemNhanVien themNV = new ThemNhanVien(null, true);
        themNV.btnThemNV.setText("Chỉnh sửa");
        int i = tblNhanVien.getSelectedRow();
        try {
            themNV.txtMaNhanVien.setText(list.get(i).getMaNV());
            themNV.txtMaNhanVien.disable();
            themNV.txtHoTen.setText(list.get(i).getHoTen());
            themNV.txtSoDienThoai.setText(list.get(i).getSdt());
            themNV.txtEmail.setText(list.get(i).getEmail());
            if (list.get(i).getGioiTinh()) {
                themNV.rdoNam.setSelected(true);
            } else {
                themNV.rdoNu.setSelected(true);
            }
            themNV.txtDiaChi.setText(list.get(i).getDiaChi());
            themNV.txtMaTaiKhoan.setText(list.get(i).getMaTK());
            themNV.txtMaTaiKhoan.disable();
            themNV.show();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "vui lòng chọn nhân viên hàng cần sửa");
        }
        list = select();
        fillToTable(list);
    }

    void timKiem() {
        if (cboTimKiem2.getSelectedItem().toString().equals("Tìm kiếm theo tên")) {
            if(VaiTro.equals("GiamDoc")){
                list = dao.findName(txtTimKiem.getText());
            }else{
                list = dao.findName(txtTimKiem.getText(),MaCH);
            }
        } else {
            
            if(VaiTro.equals("GiamDoc")){
                list = dao.findMaNV(txtTimKiem.getText());
            }else{
                list = dao.findMaNV(txtTimKiem.getText(),MaCH);
            }
        }
        DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
        model.setRowCount(0);
        try {
            int i = 1;
            for (NhanVien ch : list) {
                Object[] row = {
                    i, ch.getMaCH(),
                    ch.getMaNV(),
                    ch.getHoTen(),
                    ch.getSdt(),
                    ch.getEmail(),
                    ch.getGioiTinh(),
                    ch.getDiaChi()
                };
                model.addRow(row);
                i++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "lỗi truy vẫn dữ liệu");
        }
    }
    NhanVienDAO dao = new NhanVienDAO();
    List<NhanVien> list;

    void fillToTable(List<NhanVien> list) {
        DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
        model.setRowCount(0);
        try {
            //list = dao.select();
            int i = 1;
            for (NhanVien ch : list) {
                String gt = "Nữ";
                if (ch.getGioiTinh()) {
                    gt = "Nam";
                }
                Object[] row = {
                    i, ch.getMaCH(),
                    ch.getMaNV(),
                    ch.getHoTen(),
                    ch.getSdt(),
                    ch.getEmail(),
                    gt,
                    ch.getDiaChi()
                };
                model.addRow(row);
                i++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "lỗi truy vẫn dữ liệu");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        QuanLyNhanVien = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        cboTimKiem2 = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        jButton29 = new javax.swing.JButton();
        btnSapXep = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        QuanLyNhanVien.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("QUẢN LÝ NHÂN VIÊN");

        cboTimKiem2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboTimKiem2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tìm kiếm theo tên", "Tìm kiếm theo mã" }));
        cboTimKiem2.setMinimumSize(new java.awt.Dimension(138, 35));

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTimKiem.setMinimumSize(new java.awt.Dimension(6, 35));

        jButton29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton29.setText("Tìm kiếm");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        btnSapXep.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSapXep.setText("Sắp xếp theo tên");
        btnSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXepActionPerformed(evt);
            }
        });

        jButton31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton31.setText("Tạo mới");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        jButton32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton32.setText("Chỉnh sửa");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        tblNhanVien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã cửa hàng", "Mã Nhân Viên", "Tên Nhân Viên", "Số Điện Thoại", "Email", "Giới Tính", "Địa Chỉ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhanVien.setRowHeight(30);
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblNhanVienMousePressed(evt);
            }
        });
        jScrollPane6.setViewportView(tblNhanVien);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Xóa");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout QuanLyNhanVienLayout = new javax.swing.GroupLayout(QuanLyNhanVien);
        QuanLyNhanVien.setLayout(QuanLyNhanVienLayout);
        QuanLyNhanVienLayout.setHorizontalGroup(
            QuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QuanLyNhanVienLayout.createSequentialGroup()
                .addContainerGap(1520, Short.MAX_VALUE)
                .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
            .addGroup(QuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(QuanLyNhanVienLayout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addGroup(QuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(QuanLyNhanVienLayout.createSequentialGroup()
                            .addComponent(cboTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(62, 62, 62)
                            .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(78, 78, 78)
                            .addComponent(btnSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(83, 83, 83)
                            .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(367, 367, 367))
                        .addComponent(jLabel16)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1715, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(49, 49, 49)))
        );
        QuanLyNhanVienLayout.setVerticalGroup(
            QuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuanLyNhanVienLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(QuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(QuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(QuanLyNhanVienLayout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(jLabel16)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(QuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboTimKiem2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(209, 209, 209)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1855, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 10, Short.MAX_VALUE)
                    .addComponent(QuanLyNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 11, Short.MAX_VALUE)
                    .addComponent(QuanLyNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 969, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        ThemNhanVien themNV = new ThemNhanVien(null, true);
        themNV.show();
        list = select();
        fillToTable(list);
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        fillChinhSua();
        list = select();
        fillToTable(list);
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        timKiem();
    }//GEN-LAST:event_jButton29ActionPerformed

    private void btnSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXepActionPerformed
        Comparator<NhanVien> sortName = new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien s1, NhanVien s2) {
                return s1.getHoTen().compareTo(s2.getHoTen());
            }
        };
        Comparator<NhanVien> sortMaNV = new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien s1, NhanVien s2) {
                return s1.getMaNV().compareTo(s2.getMaNV());
            }
        };
        if (btnSapXep.getText().equals("Sắp xếp theo tên")) {
            Collections.sort(list, sortName);
            btnSapXep.setText("Sắp xếp theo mã");
        } else {
            Collections.sort(list, sortMaNV);
            btnSapXep.setText("Sắp xếp theo tên");
        }
        DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
        model.setRowCount(0);
        try {
            int i = 1;
            for (NhanVien ch : list) {
                Object[] row = {
                    i, ch.getMaCH(),
                    ch.getMaNV(),
                    ch.getHoTen(),
                    ch.getSdt(),
                    ch.getEmail(),
                    ch.getGioiTinh(),
                    ch.getDiaChi()
                };
                model.addRow(row);
                i++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "lỗi truy vẫn dữ liệu");
        }
    }//GEN-LAST:event_btnSapXepActionPerformed

    private void tblNhanVienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMousePressed
        if (evt.getX() == x & evt.getY() == y) {
            kt = 1;
        } else {
            x = evt.getX();
            y = evt.getY();
        }
        if (kt == 1) {
            fillChinhSua();
            kt = 0;
            x = 0;
            y = 0;
        }
    }//GEN-LAST:event_tblNhanVienMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            int i = tblNhanVien.getSelectedRow();
            int traloi = JOptionPane.showConfirmDialog(this, "bạn có chắc muốn xóa nhân viên có mã: " + list.get(i).getMaNV());
            if (traloi == 0) {
                NhanVienDAO kh = new NhanVienDAO();
                try {
                    kh.delete(list.get(i).getMaTK());
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                    list = select();
                    fillToTable(list);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Xóa thất bại");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cần chọn nhân viên để xóa");
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    int kt = 0;
    int x = 0;
    int y = 0;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel QuanLyNhanVien;
    private javax.swing.JButton btnSapXep;
    private javax.swing.JComboBox<String> cboTimKiem2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
