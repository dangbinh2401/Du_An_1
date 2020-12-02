package com.xemay.view;

import com.xemay.dao.HoaDonXuatDAO;
import com.xemay.model.HoaDonXuat;
import com.xemay.model.NhanVien;
import com.xemay.model.TaiKhoan;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;

/**
 *
 * @author Admin
 */
public class BanHangPanel extends javax.swing.JPanel {

    /**
     * Creates new form banHangPanel
     */
    public BanHangPanel() {
        initComponents();
        list = dao.selectAll();
        fillToTable(list);
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

    void timKiem() {
        if (cboTimKiem.getSelectedItem().toString().equals("Tìm kiếm theo tên khách hàng")) {
            list = dao.findTenKH(txtTimKiem.getText());
        }
        if (cboTimKiem.getSelectedItem().toString().equals("Tìm kiếm theo tên nhân viên")) {
            list = dao.findTenNV(txtTimKiem.getText());
        }
        fillToTable(list);
    }
    HoaDonXuatDAO dao = new HoaDonXuatDAO();
    List<HoaDonXuat> list;

    void fillToTable(List<HoaDonXuat> list) {
        DefaultTableModel model = (DefaultTableModel) tblHoaDonXuat.getModel();
        model.setRowCount(0);
        try {
            int i = 1;
            for (HoaDonXuat ch : list) {
                Object[] row = {
                    i,
                    ch.getMaHdx(),
                    ch.getMaNV(),
                    ch.getHoTenNhanVien(),
                    ch.getMaKH(),
                    ch.getHoTenKH(),
                    ch.getNgayXuat()
                };
                model.addRow(row);
                i++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "lỗi truy vẫn dữ liệu" + e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BanHang = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        cboTimKiem = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnSapXep = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDonXuat = new javax.swing.JTable();

        BanHang.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("QUẢN LÝ BÁN HÀNG");

        cboTimKiem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tìm kiếm theo tên khách hàng", "Tìm kiếm theo tên nhân viên" }));
        cboTimKiem.setMinimumSize(new java.awt.Dimension(138, 35));

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTimKiem.setMinimumSize(new java.awt.Dimension(6, 35));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Tìm kiếm");

        btnSapXep.setBackground(new java.awt.Color(255, 255, 255));
        btnSapXep.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSapXep.setText("Sắp xếp theo tên nhân viên");
        btnSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXepActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Tạo mới");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Chỉnh sửa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("Chi tiết hóa đơn");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setText("Xóa");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        tblHoaDonXuat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblHoaDonXuat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã hóa đơn xuất", "Mã nhân viên", "Tên Nhân Viên", "Mã Khách Hàng", "Tên Khách Hàng", "Ngày Xuất"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDonXuat.setRowHeight(30);
        jScrollPane1.setViewportView(tblHoaDonXuat);

        javax.swing.GroupLayout BanHangLayout = new javax.swing.GroupLayout(BanHang);
        BanHang.setLayout(BanHangLayout);
        BanHangLayout.setHorizontalGroup(
            BanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BanHangLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(BanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BanHangLayout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(BanHangLayout.createSequentialGroup()
                        .addGroup(BanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(BanHangLayout.createSequentialGroup()
                                .addComponent(cboTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(btnSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36))))
        );
        BanHangLayout.setVerticalGroup(
            BanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BanHangLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(BanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(BanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cboTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(BanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BanHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        ThemHoaDonXuat laphoadon = new ThemHoaDonXuat(null, true);
        laphoadon.show();
        list = dao.selectAll();
        fillToTable(list);
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int i = tblHoaDonXuat.getSelectedRow();
        if (i != -1) {
            ChiTietHoaDonXuat ct = new ChiTietHoaDonXuat(null, true);
            ct.txtMaHDX.setText(list.get(i).getMaHdx());
            ct.txtMaHDX.disable();
            ct.txtMaKH.setText(list.get(i).getMaKH());
            ct.txtMaKH.disable();
            ct.txtMaNV.setText(list.get(i).getMaNV());
            ct.txtMaNV.disable();
            ct.lblHoTenKH.setText(list.get(i).getHoTenKH());
            ct.lblSoDienThoai.setText(list.get(i).getSoDienThoai());
            ct.txtNgayXuat.setText(list.get(i).getNgayXuat().toString());
            ct.fillToTable();
            ct.show();
            list = dao.selectAll();
            fillToTable(list);
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn cần xem");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
                ThemHoaDonXuat cs = new ThemHoaDonXuat(null, true);
                int i=tblHoaDonXuat.getSelectedRow();
                cs.txtMaHDX.setText(list.get(i).getMaHdx());
                cs.txtMaHDX.disable();
                cs.txtMaNV.setText(list.get(i).getMaNV());
                cs.txtMaNV.disable();
                cs.cboMaKH.setSelectedItem(list.get(i).getMaKH());
                cs.btnThem.setText("Chỉnh sửa");
                cs.show();
                list = dao.selectAll();
                fillToTable(list);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int i = tblHoaDonXuat.getSelectedRow();
        if (i == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn cần xóa");
        } else {
            if (JOptionPane.showConfirmDialog(this, "bạn có chắc muốn xóa hóa đơn này?") == 0) {
                try {
                    dao.delete(list.get(i).getMaHdx());
                    JOptionPane.showMessageDialog(this, "Xóa thành công!");
                    list = dao.selectAll();
                    fillToTable(list);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "không được xóa hóa đơn đã có chi tiết hóa đơn!");
                }
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXepActionPerformed
        Comparator<HoaDonXuat> sortNameNV = new Comparator<HoaDonXuat>() {
            @Override
            public int compare(HoaDonXuat s1, HoaDonXuat s2) {
                return s1.getHoTenNhanVien().compareTo(s2.getHoTenNhanVien());
            }
        };
        Comparator<HoaDonXuat> sortTenKH = new Comparator<HoaDonXuat>() {
            @Override
            public int compare(HoaDonXuat s1, HoaDonXuat s2) {
                return s1.getHoTenKH().compareTo(s2.getHoTenKH());
            }
        };
        Comparator<HoaDonXuat> sortMaHDX = new Comparator<HoaDonXuat>() {
            @Override
            public int compare(HoaDonXuat s1, HoaDonXuat s2) {
                return s1.getMaHdx().compareTo(s2.getMaHdx());
            }
        };
        if (btnSapXep.getText().equals("Sắp xếp theo tên nhân viên")) {
            Collections.sort(list, sortNameNV);
            btnSapXep.setText("Sắp xếp theo tên khách hàng");
        } else {
            if (btnSapXep.getText().equals("Sắp xếp theo tên khách hàng")) {
                Collections.sort(list, sortTenKH);
                btnSapXep.setText("Sắp xếp theo mã hóa đơn xuất");
            } else {
                Collections.sort(list, sortMaHDX);
                btnSapXep.setText("Sắp xếp theo tên nhân viên");
            }
        }
        fillToTable(list);
    }//GEN-LAST:event_btnSapXepActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BanHang;
    private javax.swing.JButton btnSapXep;
    private javax.swing.JComboBox<String> cboTimKiem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblHoaDonXuat;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
