/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.view;

import com.xemay.dao.HoaDonNhapDAO;
import com.xemay.helper.ShareHelper;
import com.xemay.model.HoaDonNhap;
import com.xemay.model.HoaDonXuat;
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
public class NhapHangPanel extends javax.swing.JPanel {

    /**
     * Creates new form nhapHangPanel
     */
        public String VaiTro = ShareHelper.TaiKhoan.getVaiTro();
    public String MaCH = ShareHelper.TaiKhoan.getMaCH();
    public String MaNV = ShareHelper.TaiKhoan.getMaNV();
    public NhapHangPanel() {
        initComponents();
        list=select();
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
        cboTimKiem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = cboTimKiem.getSelectedIndex();
                if (i >=0 ) {
                    timKiem();
                }

            }
        });
    }
    List<HoaDonNhap> select(){
        List<HoaDonNhap> temp=null;
        if (VaiTro.equals("GiamDoc")) {
            temp = dao.selectAll();
        }
        if (VaiTro.equals("NhanVien")) {
            temp = dao.selectAll(MaCH,MaNV);
        }
        if (VaiTro.equals("QuanLy")) {
            temp = dao.selectAll(MaCH);
        }
        return temp;
    }
    void timKiem(){
        if (cboTimKiem.getSelectedItem().toString().equals("Tìm kiếm theo tên nhân viên")) {
            if(VaiTro.equals("GiamDoc")){
                list = dao.findTenNV(txtTimKiem.getText());
            }
            if(VaiTro.equals("QuanLy")){
                list = dao.findTenNV(txtTimKiem.getText(),MaCH);    
            }
        }
        if (cboTimKiem.getSelectedItem().toString().equals("Tìm kiếm theo Tên nhà cung cấp")) {
            if(VaiTro.equals("GiamDoc")){
                list = dao.findTenNCC(txtTimKiem.getText());
            }
            if(VaiTro.equals("NhanVien")){
                list = dao.findTenNCC(txtTimKiem.getText(),MaCH,MaNV);
            }
            if(VaiTro.equals("QuanLy")){
                list = dao.findTenNCC(txtTimKiem.getText(),MaCH);    
            }
            
        }
        fillToTable(list);
    }
    List<HoaDonNhap> list;
    HoaDonNhapDAO dao = new HoaDonNhapDAO();
    void fillToTable(List<HoaDonNhap> list) {
        DefaultTableModel model = (DefaultTableModel) tblHoaDonNhap.getModel();
        model.setRowCount(0);
        try {
            int i = 1;
            for (HoaDonNhap ch : list) {
                Object[] row = {
                    i,
                    ch.getMaHDN(),
                    ch.getMaNV(),
                    ch.getTenNV(),
                    ch.getTenNCC(),
                    ch.getNgayNhap()
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

        NhapHang = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDonNhap = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        btnSapXep = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        cboTimKiem = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();

        NhapHang.setBackground(new java.awt.Color(255, 255, 255));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton7.setText("Tìm kiếm");

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setText("Chi tiết hóa đơn");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        tblHoaDonNhap.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblHoaDonNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã hóa đơn nhập", "Mã nhân viên", "Tên nhân viên", "Tên nhà cung cấp", "Ngày nhập"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDonNhap.setRowHeight(30);
        tblHoaDonNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblHoaDonNhapMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoaDonNhap);

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton9.setText("Xóa");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        btnSapXep.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSapXep.setText("Sắp xếp tên nhân viên");
        btnSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXepActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton11.setText("Chỉnh sửa");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton12.setText("Tạo mới");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTimKiem.setMinimumSize(new java.awt.Dimension(6, 35));

        cboTimKiem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tìm kiếm theo tên nhân viên", "Tìm kiếm theo Tên nhà cung cấp" }));
        cboTimKiem.setMinimumSize(new java.awt.Dimension(138, 35));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setText("QUẢN LÝ NHẬP HÀNG");

        javax.swing.GroupLayout NhapHangLayout = new javax.swing.GroupLayout(NhapHang);
        NhapHang.setLayout(NhapHangLayout);
        NhapHangLayout.setHorizontalGroup(
            NhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NhapHangLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(NhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NhapHangLayout.createSequentialGroup()
                        .addComponent(cboTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(NhapHangLayout.createSequentialGroup()
                        .addGroup(NhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1724, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(63, Short.MAX_VALUE))))
        );
        NhapHangLayout.setVerticalGroup(
            NhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NhapHangLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(NhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NhapHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cboTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 703, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(NhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        ThemHoaDonNhap themHDN = new ThemHoaDonNhap(null, true);
        themHDN.show();
        list = select();
        fillToTable(list);
    }//GEN-LAST:event_jButton12ActionPerformed
    void xemCTHD(){
        int i=tblHoaDonNhap.getSelectedRow();
        if(i!=-1){
            ChiTietHoaDonNhap ct = new ChiTietHoaDonNhap(null, true);
            ct.txtMaHDN.setText(list.get(i).getMaHDN());
            ct.txtMaHDN.disable();
            ct.txtMaNV.setText(list.get(i).getMaNV());
            ct.txtMaNV.disable();
            ct.txtMaNCC.setText(list.get(i).getMaNCC());
            ct.txtMaNCC.disable();
            ct.lblTenNCC.setText(list.get(i).getTenNCC());
            ct.lblSoDienThoai.setText(list.get(i).getSDT());
            ct.txtNgayNhap.setText(list.get(i).getNgayNhap().toString());
            ct.fillToTable();
            ct.show();
            list = select();
            fillToTable(list);
        }else{
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn cần xem");
        }
    }
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        this.xemCTHD();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        int i=tblHoaDonNhap.getSelectedRow();
        if(i!=-1){
            ThemHoaDonNhap cs = new ThemHoaDonNhap(null, true);
            cs.btnThem.setText("Chỉnh sửa");
            cs.txtMaHDN.setText(list.get(i).getMaHDN());
            cs.txtMaHDN.disable();
            cs.txtMaNV.setText(list.get(i).getMaNV());
            cs.txtMaNV.disable();
            cs.cboMaNCC.setSelectedItem(list.get(i).getMaNCC());
            cs.txtTenNCC.setText(list.get(i).getTenNCC());
            cs.txtNgayNhap.setText(list.get(i).getNgayNhap().toString());          
            cs.show();
            list = select();
            fillToTable(list);
        
        }else{
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn cần xem");
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void btnSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXepActionPerformed
        Comparator<HoaDonNhap> sortNameNV = new Comparator<HoaDonNhap>() {
            @Override
            public int compare(HoaDonNhap s1, HoaDonNhap s2) {
                
                return s1.getTenNV().toUpperCase().compareTo(s2.getTenNV().toUpperCase());
            }
        };
        Comparator<HoaDonNhap> sortNCC = new Comparator<HoaDonNhap>() {
            @Override
            public int compare(HoaDonNhap s1, HoaDonNhap s2) {
                return s1.getTenNCC().toUpperCase().compareTo(s2.getTenNCC().toUpperCase());
            }
        };
        if (btnSapXep.getText().equals("Sắp xếp tên nhân viên")) {
            Collections.sort(list, sortNameNV);
            btnSapXep.setText("Sắp xếp tên NCC");
        }else
        if (btnSapXep.getText().equals("Sắp xếp tên NCC")) {
            Collections.sort(list, sortNCC);
            btnSapXep.setText("Sắp xếp tên nhân viên");
        }
        fillToTable(list);
    }//GEN-LAST:event_btnSapXepActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        int i = tblHoaDonNhap.getSelectedRow();
        if (i!=-1){
            if (JOptionPane.showConfirmDialog(this, "bạn có chắc muốn xóa hóa đơn này?")==0){
                dao.delete(list.get(i).getMaHDN());
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
            list=select();
            fillToTable(list);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn cần xóa!");
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void tblHoaDonNhapMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonNhapMousePressed
        
if (evt.getX() == x & evt.getY() == y) {
            kt = 1;
        } else {
            x = evt.getX();
            y = evt.getY();
        }
        if (kt == 1) {
            this.xemCTHD();
            kt = 0;
            x = 0;
            y = 0;
        }

    }//GEN-LAST:event_tblHoaDonNhapMousePressed
int kt = 0;
    int x = 0;
    int y = 0;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel NhapHang;
    private javax.swing.JButton btnSapXep;
    private javax.swing.JComboBox<String> cboTimKiem;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblHoaDonNhap;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
