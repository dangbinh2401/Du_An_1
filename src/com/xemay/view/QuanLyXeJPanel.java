/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.view;

import com.xemay.dao.LoaiXeDao;
import com.xemay.dao.XeDAO;
import com.xemay.model.LoaiXe;
import com.xemay.model.Xe;
import java.text.DecimalFormat;
import java.text.NumberFormat;
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
public class QuanLyXeJPanel extends javax.swing.JPanel {

    /**
     * Creates new form quanLyXeJPanel
     */
    public QuanLyXeJPanel() {
        initComponents();
        fillToTable();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        QuanLyXe = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblXe = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        cboTimKiem2 = new javax.swing.JComboBox<String>();
        txtTimKiem = new javax.swing.JTextField();
        jButton49 = new javax.swing.JButton();
        btnSapXep = new javax.swing.JButton();
        jButton51 = new javax.swing.JButton();
        jButton52 = new javax.swing.JButton();
        jButton53 = new javax.swing.JButton();

        QuanLyXe.setBackground(new java.awt.Color(255, 255, 255));

        tblXe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblXe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã cửa hàng", "Mã Xe", "Tên Xe", "Tên Loại Xe", "Số khung", "Dung Tích", "Số Lượng", "Năm Sản Xuất", "Thời Gian Bảo Hành", "Giá tiền bán"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblXe.setRowHeight(30);
        tblXe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblXeMousePressed(evt);
            }
        });
        jScrollPane9.setViewportView(tblXe);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setText("QUẢN LÝ XE");

        cboTimKiem2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboTimKiem2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tìm kiếm theo tên", "Tìm kiếm theo mã" }));
        cboTimKiem2.setMinimumSize(new java.awt.Dimension(138, 35));

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTimKiem.setMinimumSize(new java.awt.Dimension(6, 35));

        jButton49.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton49.setText("Tìm kiếm");
        jButton49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton49ActionPerformed(evt);
            }
        });

        btnSapXep.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSapXep.setText("Sắp xếp theo tên");
        btnSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXepActionPerformed(evt);
            }
        });

        jButton51.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton51.setText("Tạo mới");
        jButton51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton51ActionPerformed(evt);
            }
        });

        jButton52.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton52.setText("Chỉnh sửa");
        jButton52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton52ActionPerformed(evt);
            }
        });

        jButton53.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton53.setText("Xóa");
        jButton53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton53ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout QuanLyXeLayout = new javax.swing.GroupLayout(QuanLyXe);
        QuanLyXe.setLayout(QuanLyXeLayout);
        QuanLyXeLayout.setHorizontalGroup(
            QuanLyXeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuanLyXeLayout.createSequentialGroup()
                .addGap(0, 64, Short.MAX_VALUE)
                .addGroup(QuanLyXeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(QuanLyXeLayout.createSequentialGroup()
                        .addComponent(cboTimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 230, Short.MAX_VALUE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(jButton49, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addComponent(btnSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addComponent(jButton51, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(jButton52, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jButton53, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel24)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 1715, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 73, Short.MAX_VALUE))
        );
        QuanLyXeLayout.setVerticalGroup(
            QuanLyXeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, QuanLyXeLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(QuanLyXeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton51, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton52, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton53, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton49, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTimKiem2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(QuanLyXe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(QuanLyXe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
XeDAO dao = new XeDAO();
    List<Xe> list;

    void fillToTable() {
        DefaultTableModel model = (DefaultTableModel) tblXe.getModel();
        model.setRowCount(0);
        try {
            list = dao.selectTong();
            int i = 1;
            for (Xe ch : list) {
                Object[] row = {
                    i,
                    ch.getMaCH(),
                    ch.getMaXe(),
                    ch.getTenXe(),
                    ch.getTenLx(),
                    ch.getSoKhung(),
                    ch.getDungTich(),
                    ch.getSoLuong(),
                    ch.getNamSx(),
                    ch.getThoiGianBh(),
                    ch.getGiaTienBan()
                };
                model.addRow(row);
                i++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "lỗi truy vẫn dữ liệu");
        }
    }

    void fillChinhSua() {
        ThemMoiXe themXe = new ThemMoiXe(null, true);
        themXe.btnThem.setText("Chỉnh sửa");
        int i = tblXe.getSelectedRow();
        try {
            themXe.txtMaXe.setText(list.get(i).getMaXe());
            themXe.txtMaXe.disable();
            themXe.cboMaCuaHang.setSelectedItem(list.get(i).getMaCH());
            themXe.cboMaLoaiXe.setSelectedItem(list.get(i).getTenLx());
            themXe.txtTenXe.setText(list.get(i).getTenXe());
            themXe.txtNamSanXuat1.setText(String.valueOf(list.get(i).getNamSx()));
            themXe.txtSoKhung.setText(list.get(i).getSoKhung());
            themXe.txtDungTich.setText(String.valueOf(list.get(i).getDungTich()));
            NumberFormat formatter = new DecimalFormat("#,###,###");
            String formattedNumber = formatter.format(list.get(i).getGiaTienBan());
            themXe.txtGiaTien.setText(formattedNumber);
            themXe.txtSoLuong.setText(String.valueOf(list.get(i).getSoLuong()));
            themXe.txtThoiGianBaoHanh.setText(String.valueOf(list.get(i).getThoiGianBh()));
            themXe.txtAnh.setText("");
            themXe.show();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "vui lòng chọn xe cần sửa");
        }
        fillToTable();
    }

    void timKiem() {
        if (cboTimKiem2.getSelectedItem().toString().equals("Tìm kiếm theo tên")) {
            list = dao.findTenXe(txtTimKiem.getText());
        } else {
            list = dao.findMaNV(txtTimKiem.getText());
        }
        DefaultTableModel model = (DefaultTableModel) tblXe.getModel();
        model.setRowCount(0);
        try {
            int i = 1;
            for (Xe ch : list) {
                Object[] row = {
                    i,
                    ch.getMaCH(),
                    ch.getMaXe(),
                    ch.getTenXe(),
                    ch.getTenLx(),
                    ch.getSoKhung(),
                    ch.getDungTich(),
                    ch.getSoLuong(),
                    ch.getNamSx(),
                    ch.getThoiGianBh(),
                    ch.getGiaTienBan()
                };
                model.addRow(row);
                i++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "lỗi truy vẫn dữ liệu");
        }
    }

    private void jButton51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton51ActionPerformed
        ThemMoiXe themXe = new ThemMoiXe(null, true);
        themXe.show();
        fillToTable();
    }//GEN-LAST:event_jButton51ActionPerformed

    private void jButton52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton52ActionPerformed
        fillChinhSua();
        fillToTable();
    }//GEN-LAST:event_jButton52ActionPerformed

    private void btnSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXepActionPerformed
        Comparator<Xe> sortName = new Comparator<Xe>() {
            @Override
            public int compare(Xe s1, Xe s2) {
                return s1.getTenXe().toUpperCase().compareTo(s2.getTenXe().toUpperCase());
            }
        };
        Comparator<Xe> sortMaNV = new Comparator<Xe>() {
            @Override
            public int compare(Xe s1, Xe s2) {
                return s1.getMaXe().toUpperCase().compareTo(s2.getMaXe().toUpperCase());
            }
        };
        if (btnSapXep.getText().equals("Sắp xếp theo tên")) {
            Collections.sort(list, sortName);
            btnSapXep.setText("Sắp xếp theo mã");
        } else {
            Collections.sort(list, sortMaNV);
            btnSapXep.setText("Sắp xếp theo tên");
        }
        DefaultTableModel model = (DefaultTableModel) tblXe.getModel();
        model.setRowCount(0);
        try {
            int i = 1;
            for (Xe ch : list) {
                Object[] row = {
                    i,
                    ch.getMaCH(),
                    ch.getMaXe(),
                    ch.getTenXe(),
                    ch.getTenLx(),
                    ch.getSoKhung(),
                    ch.getDungTich(),
                    ch.getSoLuong(),
                    ch.getNamSx(),
                    ch.getThoiGianBh(),
                    ch.getGiaTienBan()
                };
                model.addRow(row);
                i++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "lỗi truy vẫn dữ liệu");
        }
    }//GEN-LAST:event_btnSapXepActionPerformed

    private void tblXeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblXeMousePressed
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
    }//GEN-LAST:event_tblXeMousePressed

    private void jButton49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton49ActionPerformed

    }//GEN-LAST:event_jButton49ActionPerformed

    private void jButton53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton53ActionPerformed
        try {
            int i = tblXe.getSelectedRow();
            int traloi = JOptionPane.showConfirmDialog(this, "bạn có chắc muốn xóa xe có mã: " + list.get(i).getMaXe());
            if (traloi == 0) {
                XeDAO kh = new XeDAO();
                try {
                    kh.delete(list.get(i).getMaXe());
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                    fillToTable();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Không thể xóa khi còn hóa đơn");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cần chọn xe để xóa");
        }

    }//GEN-LAST:event_jButton53ActionPerformed
    int kt = 0;
    int x = 0;
    int y = 0;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel QuanLyXe;
    private javax.swing.JButton btnSapXep;
    private javax.swing.JComboBox<String> cboTimKiem2;
    private javax.swing.JButton jButton49;
    private javax.swing.JButton jButton51;
    private javax.swing.JButton jButton52;
    private javax.swing.JButton jButton53;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable tblXe;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
