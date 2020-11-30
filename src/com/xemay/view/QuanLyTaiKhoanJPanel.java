/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.view;



import com.xemay.dao.TaiKhoanDAO;

import com.xemay.model.TaiKhoan;
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
public class QuanLyTaiKhoanJPanel extends javax.swing.JPanel {

    /**
     * Creates new form quanLyTaiKhoanJPanel
     */
    public QuanLyTaiKhoanJPanel() {
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
        void timKiem(){
         DefaultTableModel model = (DefaultTableModel) tblTaiKhoan.getModel(); 
        model.setRowCount(0); 
        try { 
            list = dao.findkey(txtTimKiem.getText()); 
            int i = 1;
            for (TaiKhoan ch : list) { 
                Object[] row = { 
                    i
                    ,ch.getMaTk(), 
                    ch.getHoTen(), 
                    ch.getMatKhau(), 
                    ch.getVaiTro(), 
                }; 
                model.addRow(row); 
                i++;
            } 
        }  
        catch (Exception e) { 
            JOptionPane.showMessageDialog(this, "lỗi truy vẫn dữ liệu"+e);
        }
    }
        TaiKhoanDAO dao = new TaiKhoanDAO(); 
    List<TaiKhoan> list;
        void fillToTable(){
        DefaultTableModel model = (DefaultTableModel) tblTaiKhoan.getModel(); 
        model.setRowCount(0); 
        try { 
            list = dao.selectAll(); 
            int i = 1;
            for (TaiKhoan ch : list) { 
                Object[] row = { 
                    i
                    ,ch.getMaTk(), 
                    ch.getHoTen(), 
                    ch.getMatKhau(), 
                    ch.getVaiTro(), 
                }; 
                model.addRow(row); 
                i++;
            } 
        }  
        catch (Exception e) { 
            JOptionPane.showMessageDialog(this, "lỗi truy vẫn dữ liệu"+e);
        }
    }
    void fillChinhSua(){
        ThemTaiKhoan cs = new ThemTaiKhoan(null, true);
        cs.btnThem.setText("Chỉnh sửa");
        int i = tblTaiKhoan.getSelectedRow();
        try {
            cs.txtMaTK.setText(list.get(i).getMaTk());
            cs.txtMatKhau.setText(list.get(i).getMatKhau());
            cs.txtVaiTro.setText(list.get(i).getVaiTro());
            cs.show();
            fillToTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "vui lòng chọn tài khoản hàng cần sửa");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        QuanLyTaiKhoan = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        cboTimKiem4 = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        jButton39 = new javax.swing.JButton();
        btnSapXep = new javax.swing.JButton();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblTaiKhoan = new javax.swing.JTable();
        jButton43 = new javax.swing.JButton();

        QuanLyTaiKhoan.setBackground(new java.awt.Color(255, 255, 255));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setText("QUẢN LÝ TÀI KHOẢN");

        cboTimKiem4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboTimKiem4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tìm kiếm theo tên", "Tìm kiếm theo mã" }));
        cboTimKiem4.setMinimumSize(new java.awt.Dimension(138, 35));

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTimKiem.setMinimumSize(new java.awt.Dimension(6, 35));

        jButton39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton39.setText("Tìm kiếm");

        btnSapXep.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSapXep.setText("Sắp xếp theo tên");
        btnSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXepActionPerformed(evt);
            }
        });

        jButton41.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton41.setText("Tạo mới");
        jButton41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton41ActionPerformed(evt);
            }
        });

        jButton42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton42.setText("Chỉnh sửa");
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });

        tblTaiKhoan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Tài Khoản", "Họ Tên", "Mật Khẩu", "Vai Trò"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTaiKhoan.setRowHeight(30);
        tblTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblTaiKhoanMousePressed(evt);
            }
        });
        jScrollPane8.setViewportView(tblTaiKhoan);

        jButton43.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton43.setText("Xóa");
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout QuanLyTaiKhoanLayout = new javax.swing.GroupLayout(QuanLyTaiKhoan);
        QuanLyTaiKhoan.setLayout(QuanLyTaiKhoanLayout);
        QuanLyTaiKhoanLayout.setHorizontalGroup(
            QuanLyTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1835, Short.MAX_VALUE)
            .addGroup(QuanLyTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(QuanLyTaiKhoanLayout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addGroup(QuanLyTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(QuanLyTaiKhoanLayout.createSequentialGroup()
                            .addComponent(cboTimKiem4, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(62, 62, 62)
                            .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(86, 86, 86)
                            .addComponent(btnSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(83, 83, 83)
                            .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(79, 79, 79)
                            .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(109, 109, 109)
                            .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(QuanLyTaiKhoanLayout.createSequentialGroup()
                            .addComponent(jLabel21)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 1737, Short.MAX_VALUE))
                    .addGap(49, 49, 49)))
        );
        QuanLyTaiKhoanLayout.setVerticalGroup(
            QuanLyTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1013, Short.MAX_VALUE)
            .addGroup(QuanLyTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(QuanLyTaiKhoanLayout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(jLabel21)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(QuanLyTaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton41, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboTimKiem4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(334, 334, 334)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1835, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(QuanLyTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1013, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(QuanLyTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblTaiKhoanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTaiKhoanMousePressed
         if (evt.getX()==x & evt.getY()==y){
            kt=1;
        }else{
            x=evt.getX();
            y=evt.getY();
        }
        if (kt==1){
            fillChinhSua();
            kt=0;
            x=0;
            y=0;
        }
    }//GEN-LAST:event_tblTaiKhoanMousePressed

    private void jButton41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton41ActionPerformed
        ThemTaiKhoan them = new ThemTaiKhoan(null, true);
        them.show();
        fillToTable();
    }//GEN-LAST:event_jButton41ActionPerformed

    private void btnSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXepActionPerformed
                    Comparator<TaiKhoan> sortName = new Comparator<TaiKhoan>() {
            @Override
            public int compare(TaiKhoan s1, TaiKhoan s2) {
                return s1.getHoTen().compareTo(s2.getHoTen());
            }
        };    
        Comparator<TaiKhoan> sortMaTK = new Comparator<TaiKhoan>() {
            @Override
            public int compare(TaiKhoan s1, TaiKhoan s2) {
                return s1.getMaTk().compareTo(s2.getMaTk());
            }
        };   
        if(btnSapXep.getText().equals("Sắp xếp theo tên")){
            Collections.sort(list,sortName);
            btnSapXep.setText("Sắp xếp theo mã");
        }else{
            Collections.sort(list,sortMaTK);
            btnSapXep.setText("Sắp xếp theo tên");
        }
        DefaultTableModel model = (DefaultTableModel) tblTaiKhoan.getModel(); 
        model.setRowCount(0); 
        try { 
            int i = 1;
            for (TaiKhoan ch : list) { 
                Object[] row = { 
                    i
                    ,ch.getMaTk(), 
                    ch.getHoTen(), 
                    ch.getMatKhau(), 
                    ch.getVaiTro(), 
                }; 
                model.addRow(row); 
                i++;
            } 
        }  
        catch (Exception e) { 
            JOptionPane.showMessageDialog(this, "lỗi truy vẫn dữ liệu"+e);
        }
    }//GEN-LAST:event_btnSapXepActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        fillChinhSua();
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        String tkk = JOptionPane.showInputDialog(this, "Nhập mã tài khoản: ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        int traloi = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa tài khoản có mã: " + tkk, "Yes/No", JOptionPane.YES_NO_CANCEL_OPTION);
        if (traloi == 0) {
           TaiKhoanDAO tk= new TaiKhoanDAO();
            try {
                tk.delete(tkk);
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                fillToTable();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
            }
        }
        
        
    }//GEN-LAST:event_jButton43ActionPerformed
    int x=0;
    int y=0;
    int kt=0;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel QuanLyTaiKhoan;
    private javax.swing.JButton btnSapXep;
    private javax.swing.JComboBox<String> cboTimKiem4;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable tblTaiKhoan;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
