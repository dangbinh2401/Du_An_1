/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.view;

import static com.sun.java.accessibility.util.SwingEventMonitor.addDocumentListener;
import com.xemay.dao.CuaHangDAO;
import com.xemay.model.CuaHang;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
    CuaHangDAO dao = new CuaHangDAO(); 
    List<CuaHang> list;
    
    void timKiem(){
        DefaultTableModel model = (DefaultTableModel) tblCuaHang.getModel(); 
        model.setRowCount(0); 
        try { 
            list = dao.find(txtTimKiem.getText()); 
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
            JOptionPane.showMessageDialog(this,"lỗi truy vẫn dữ liệu");
            
        }
    }
    void fillToTable(){
        DefaultTableModel model = (DefaultTableModel) tblCuaHang.getModel(); 
        model.setRowCount(0); 
        try { 
            list = dao.select(); 
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
            JOptionPane.showMessageDialog(this, "lỗi truy vẫn dữ liệu"+e);
        }
    }
    void fillChinhSua(){
                ThemCuaHang capNhatCH = new ThemCuaHang(null, true);
        capNhatCH.btnThemCuaHang.setText("Cập nhật");
        int i = tblCuaHang.getSelectedRow();
        try {
            capNhatCH.txtMaCuaHang.setText(list.get(i).getMaCh());
            capNhatCH.txtTenCuaHang.setText(list.get(i).getTenCuaHang());
            capNhatCH.txtDiaChi.setText(list.get(i).getDiaChi());
            capNhatCH.txtSoDienThoai.setText(list.get(i).getSdt());
            capNhatCH.txtEmail.setText(list.get(i).getEmail());
            capNhatCH.show();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "vui lòng chọn cửa hàng cần sửa");
        }
        fillToTable();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        QuanLyCuaHang = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        cboTimKiem1 = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblCuaHang = new javax.swing.JTable();
        jButton27 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        btnSapXep = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();

        QuanLyCuaHang.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("QUẢN LÝ SHOWROOM");

        cboTimKiem1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboTimKiem1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tìm kiếm theo tên", "Tìm kiếm theo mã" }));
        cboTimKiem1.setMinimumSize(new java.awt.Dimension(138, 35));

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTimKiem.setMinimumSize(new java.awt.Dimension(6, 35));

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
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCuaHang.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblCuaHang.setRowHeight(30);
        tblCuaHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCuaHangMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblCuaHangMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblCuaHangMouseReleased(evt);
            }
        });
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

        btnSapXep.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSapXep.setText("Sắp xếp theo tên");
        btnSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXepActionPerformed(evt);
            }
        });

        jButton24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton24.setText("Tìm kiếm");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton28.setText("Xóa");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

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
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(btnSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        fillChinhSua();
        
    }//GEN-LAST:event_jButton27ActionPerformed
    
    private void tblCuaHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCuaHangMouseClicked
       
    }//GEN-LAST:event_tblCuaHangMouseClicked
    
    private void tblCuaHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCuaHangMousePressed
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
    }//GEN-LAST:event_tblCuaHangMousePressed
    int x=0;
    int y=0;
    int kt=0;
    private void tblCuaHangMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCuaHangMouseReleased

    }//GEN-LAST:event_tblCuaHangMouseReleased

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        timKiem();
    }//GEN-LAST:event_jButton24ActionPerformed

    private void btnSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXepActionPerformed
            Comparator<CuaHang> sortName = new Comparator<CuaHang>() {
            @Override
            public int compare(CuaHang s1, CuaHang s2) {
                return s1.getTenCuaHang().compareTo(s2.getTenCuaHang());
            }
        };    
        Comparator<CuaHang> sortMaCH = new Comparator<CuaHang>() {
            @Override
            public int compare(CuaHang s1, CuaHang s2) {
                return s1.getMaCh().compareTo(s2.getMaCh());
            }
        };   
        if(btnSapXep.getText().equals("Sắp xếp theo tên")){
            Collections.sort(list,sortName);
            btnSapXep.setText("Sắp xếp theo mã");
        }else{
            Collections.sort(list,sortMaCH);
            btnSapXep.setText("Sắp xếp theo tên");
        }
        DefaultTableModel model = (DefaultTableModel) tblCuaHang.getModel(); 
        model.setRowCount(0); 
        try {
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
            JOptionPane.showMessageDialog(this, "lỗi truy vẫn dữ liệu"+e);
        }
    }//GEN-LAST:event_btnSapXepActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        int i = tblCuaHang.getSelectedRow();
        if(i>0){
            if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa cửa hàng này?")==0){
                JOptionPane.showMessageDialog(this, "đang làm chức năng xóa");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Vui lòng chọn cửa hàng cần xóa");
        }
    }//GEN-LAST:event_jButton28ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel QuanLyCuaHang;
    private javax.swing.JButton btnSapXep;
    private javax.swing.JComboBox<String> cboTimKiem1;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tblCuaHang;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
