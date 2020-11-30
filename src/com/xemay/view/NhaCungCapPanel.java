/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.view;

import com.xemay.dao.NhaCungCapDAO;
import com.xemay.model.NhaCungCap;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class NhaCungCapPanel extends javax.swing.JPanel {

    private List<NhaCungCap> dataNhaCungCaps;
    /**
     * Creates new form nhaCungCapPanel
     */
    public NhaCungCapPanel() {
        initComponents();
        fillTable();
    }
    NhaCungCapDAO dao = new NhaCungCapDAO();
    void timKiemTheoTen(){
        int i = 1;
        DefaultTableModel model = (DefaultTableModel) tblQuanLyNcc.getModel(); 
        model.setRowCount(0); 
        try { 
            dataNhaCungCaps = dao.selectByKeyWord(txtTimKiemNcc.getText()); 
            for (NhaCungCap ncc : dataNhaCungCaps) { 
                Object[] row = { 
                    i++,
                    ncc.getMaNcc(),
                    ncc.getTenNcc(),
                    ncc.getSdt(),
                    ncc.getDiaChi(),
                    ncc.getEmail()
                }; 
                model.addRow(row); 
            } 
        }  
        catch (Exception e) { 
            JOptionPane.showMessageDialog(this,"lỗi truy vẫn dữ liệu");
            
        }
    }
    
    void timKiemTheoMa(){
        int i = 1;
        DefaultTableModel model = (DefaultTableModel) tblQuanLyNcc.getModel(); 
        model.setRowCount(0); 
        try { 
            dataNhaCungCaps = dao.selectByKyId(txtTimKiemNcc.getText()); 
            for (NhaCungCap ncc : dataNhaCungCaps) { 
                Object[] row = { 
                    i++,
                    ncc.getMaNcc(),
                    ncc.getTenNcc(),
                    ncc.getSdt(),
                    ncc.getDiaChi(),
                    ncc.getEmail()
                }; 
                model.addRow(row); 
            } 
        }  
        catch (Exception e) { 
            JOptionPane.showMessageDialog(this,"lỗi truy vẫn dữ liệu");
            
        }
    }
    
    void fillTable(){
        DefaultTableModel model = (DefaultTableModel) tblQuanLyNcc.getModel();
        model.setRowCount(0);
        int i = 1;
        try {
            this.dataNhaCungCaps = dao.selectAll();
            for (NhaCungCap ncc : this.dataNhaCungCaps) {
                Object[] row = {
                    i++,
                    ncc.getMaNcc(),
                    ncc.getTenNcc(),
                    ncc.getSdt(),
                    ncc.getDiaChi(),
                    ncc.getEmail()
                };
                model.addRow(row);                 
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"lỗi truy vẫn dữ liệu");
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

        NhaCungCap = new javax.swing.JPanel();
        jButton17 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblQuanLyNcc = new javax.swing.JTable();
        btnXoaNcc = new javax.swing.JButton();
        btnSapXep = new javax.swing.JButton();
        btnCapNhatNcc = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        txtTimKiemNcc = new javax.swing.JTextField();
        cboTimKiemNcc = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();

        NhaCungCap.setBackground(new java.awt.Color(255, 255, 255));

        jButton17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton17.setText("Tìm kiếm");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        tblQuanLyNcc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblQuanLyNcc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Nhà Cung Cấp", "Tên Nhà Cung Cấp", "Số ĐIện Thoại", "Địa Chỉ", "Email"
            }
        ));
        tblQuanLyNcc.setRowHeight(30);
        tblQuanLyNcc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQuanLyNccMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblQuanLyNcc);

        btnXoaNcc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnXoaNcc.setText("Xóa");
        btnXoaNcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaNccActionPerformed(evt);
            }
        });

        btnSapXep.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSapXep.setText("Sắp xếp theo tên");
        btnSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXepActionPerformed(evt);
            }
        });

        btnCapNhatNcc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCapNhatNcc.setText("Chỉnh sửa");
        btnCapNhatNcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatNccActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnThem.setText("Tạo mới");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        txtTimKiemNcc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTimKiemNcc.setMinimumSize(new java.awt.Dimension(6, 35));

        cboTimKiemNcc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboTimKiemNcc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tìm kiếm theo tên", "Tìm kiếm theo mã" }));
        cboTimKiemNcc.setMinimumSize(new java.awt.Dimension(138, 35));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setText("NHÀ CUNG CẤP");

        javax.swing.GroupLayout NhaCungCapLayout = new javax.swing.GroupLayout(NhaCungCap);
        NhaCungCap.setLayout(NhaCungCapLayout);
        NhaCungCapLayout.setHorizontalGroup(
            NhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NhaCungCapLayout.createSequentialGroup()
                .addContainerGap(934, Short.MAX_VALUE)
                .addComponent(btnSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(171, 171, 171)
                .addComponent(btnCapNhatNcc, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(221, 221, 221))
            .addGroup(NhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(NhaCungCapLayout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addGroup(NhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(NhaCungCapLayout.createSequentialGroup()
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1496, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(NhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, NhaCungCapLayout.createSequentialGroup()
                                .addComponent(cboTimKiemNcc, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(txtTimKiemNcc, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 903, Short.MAX_VALUE)
                                .addComponent(btnXoaNcc, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGap(44, 44, 44)))
        );
        NhaCungCapLayout.setVerticalGroup(
            NhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NhaCungCapLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(NhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCapNhatNcc, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(966, Short.MAX_VALUE))
            .addGroup(NhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(NhaCungCapLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jLabel19)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(NhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(NhaCungCapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTimKiemNcc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoaNcc, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(cboTimKiemNcc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(438, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1835, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(NhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1045, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(NhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        ThemNhaCungCap themNcc = new ThemNhaCungCap(null, true, null);
        themNcc.show();
        fillTable();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapNhatNccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatNccActionPerformed
        int index = tblQuanLyNcc.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this,"Hãy chọn 1 dòng rồi ấn nút xóa","Thông báo",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            NhaCungCap nhaCungCap = dataNhaCungCaps.get(index);
            ThemNhaCungCap themNCCDialog = new ThemNhaCungCap(null, true, nhaCungCap);
            themNCCDialog.btnThemNcc.setText("Cập nhật");
            themNCCDialog.txtMaNcc.setEditable(false);
            themNCCDialog.show();
            fillTable();
        }
    }//GEN-LAST:event_btnCapNhatNccActionPerformed

    private void tblQuanLyNccMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQuanLyNccMouseClicked
        
    }//GEN-LAST:event_tblQuanLyNccMouseClicked

    private void btnXoaNccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaNccActionPerformed
        int index = tblQuanLyNcc.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this,"Hãy chọn 1 dòng rồi ấn nút xóa","Thông báo",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            NhaCungCapDAO dao = new NhaCungCapDAO();
            NhaCungCap nhaCungCap = dataNhaCungCaps.get(index);
            ThemNhaCungCap themNCCDialog = new ThemNhaCungCap(null, true, nhaCungCap);
            String maNcc = themNCCDialog.txtMaNcc.getText();
            try {
                if (JOptionPane.showConfirmDialog(this,"Bạn có chắc chắn xóa không") == JOptionPane.YES_OPTION) {
                    dao.delete(maNcc);
                    JOptionPane.showMessageDialog(this,"Xóa thành công");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Xóa thất bại","Thông báo",
                    JOptionPane.ERROR_MESSAGE);
            }
            fillTable();
        }
    }//GEN-LAST:event_btnXoaNccActionPerformed

    private void btnSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXepActionPerformed
        int i =1;
        Comparator<NhaCungCap> sortName = new Comparator<NhaCungCap>() {
            @Override
            public int compare(NhaCungCap s1, NhaCungCap s2) {
                return s1.getTenNcc().compareTo(s2.getTenNcc());
            }
        }; 
        Comparator<NhaCungCap> sortMaCH = new Comparator<NhaCungCap>() {
            @Override
            public int compare(NhaCungCap s1, NhaCungCap s2) {
                return s1.getMaNcc().compareTo(s2.getMaNcc());
            }
        };   
        if(btnSapXep.getText().equals("Sắp xếp theo tên")){
            Collections.sort(dataNhaCungCaps,sortName);
            btnSapXep.setText("Sắp xếp theo mã");
        }else{
            Collections.sort(dataNhaCungCaps,sortMaCH);
            btnSapXep.setText("Sắp xếp theo tên");
        }
        DefaultTableModel model = (DefaultTableModel) tblQuanLyNcc.getModel(); 
        model.setRowCount(0); 
        try {
            for (NhaCungCap ncc : dataNhaCungCaps) { 
                Object[] row = { 
                    i++,
                    ncc.getMaNcc(),
                    ncc.getTenNcc(),
                    ncc.getSdt(),
                    ncc.getDiaChi(),
                    ncc.getEmail()
                }; 
                model.addRow(row); 
            } 
        }  
        catch (Exception e) { 
            JOptionPane.showMessageDialog(this, "lỗi truy vẫn dữ liệu"+e);
        }
    }//GEN-LAST:event_btnSapXepActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        if (cboTimKiemNcc.getSelectedItem().equals("Tìm kiếm theo tên")) {
            this.timKiemTheoTen();
        }else{
            this.timKiemTheoMa();
        }
    }//GEN-LAST:event_jButton17ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel NhaCungCap;
    private javax.swing.JButton btnCapNhatNcc;
    private javax.swing.JButton btnSapXep;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoaNcc;
    private javax.swing.JComboBox<String> cboTimKiemNcc;
    private javax.swing.JButton jButton17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblQuanLyNcc;
    private javax.swing.JTextField txtTimKiemNcc;
    // End of variables declaration//GEN-END:variables

}
