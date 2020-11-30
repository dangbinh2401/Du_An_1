/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.view;

import com.xemay.dao.HoaDonXuatDAO;
import com.xemay.model.HoaDonXuat;
import com.xemay.model.TaiKhoan;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

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
        if(cboTimKiem.getSelectedItem().toString().equals("Tìm kiếm theo tên khách hàng")){
            list= dao.findTenKH(txtTimKiem.getText());
        }
        if(cboTimKiem.getSelectedItem().toString().equals("Tìm kiếm theo tên nhân viên")){
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
        jButton2 = new javax.swing.JButton();
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

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Sắp xếp theo tên");

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Tạo mới");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Chỉnh sửa");

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("Chi tiết hóa đơn");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setText("Xóa");

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
                                .addComponent(cboTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)
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
                .addGroup(BanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(BanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cboTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        fillToTable(list);
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ChiTietHoaDonXuat ct = new ChiTietHoaDonXuat(null, true);
        int i = tblHoaDonXuat.getSelectedRow();
        ct.txtMaHDX.setText(list.get(i).getMaHdx());
        ct.txtMaKH.setText(list.get(i).getMaKH());
        ct.txtMaNV.setText(list.get(i).getMaNV());
        ct.lblHoTenKH.setText(list.get(i).getHoTenKH());
        ct.lblSoDienThoai.setText(list.get(i).getSoDienThoai());
        ct.txtNgayXuat.setText(list.get(i).getNgayXuat().toString());
        ct.fillToTable();
        ct.show();
        fillToTable(list);
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BanHang;
    private javax.swing.JComboBox<String> cboTimKiem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
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
