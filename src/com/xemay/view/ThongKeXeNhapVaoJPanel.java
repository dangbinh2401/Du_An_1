/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.view;

/**
 *
 * @author PC
 */
public class ThongKeXeNhapVaoJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ThongKeXeJPanel
     */
    public ThongKeXeNhapVaoJPanel() {
        initComponents();
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
        jButton24 = new javax.swing.JButton();
        btnSapXep1 = new javax.swing.JButton();
        cboTimKiem4 = new javax.swing.JComboBox<String>();
        cboTimKiem5 = new javax.swing.JComboBox<String>();

        setBackground(new java.awt.Color(255, 255, 255));

        QuanLyCuaHang.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("BÁO CÁO THỐNG KÊ: XE NHẬP VÀO");

        tblThongKeXe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblThongKeXe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Cửa Hàng", "Mã xe", "Tên xe", "Số lượng", "Tổng tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

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
        btnSapXep.setText("Sắp xếp theo tên");
        btnSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXepActionPerformed(evt);
            }
        });

        jButton24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton24.setText("Tìm kiếm");

        btnSapXep1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSapXep1.setText("In thống kê ");
        btnSapXep1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXep1ActionPerformed(evt);
            }
        });

        cboTimKiem4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboTimKiem4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tất cả các cửa hàng" }));
        cboTimKiem4.setToolTipText("");
        cboTimKiem4.setMinimumSize(new java.awt.Dimension(138, 35));

        cboTimKiem5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboTimKiem5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Thống kê theo năm", "Thống theo tháng" }));
        cboTimKiem5.setMinimumSize(new java.awt.Dimension(138, 35));

        javax.swing.GroupLayout QuanLyCuaHangLayout = new javax.swing.GroupLayout(QuanLyCuaHang);
        QuanLyCuaHang.setLayout(QuanLyCuaHangLayout);
        QuanLyCuaHangLayout.setHorizontalGroup(
            QuanLyCuaHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addComponent(btnSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnSapXep1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46))
            .addGroup(QuanLyCuaHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(QuanLyCuaHangLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jButton24)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        QuanLyCuaHangLayout.setVerticalGroup(
            QuanLyCuaHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuanLyCuaHangLayout.createSequentialGroup()
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
                .addGap(90, 90, 90))
            .addGroup(QuanLyCuaHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(QuanLyCuaHangLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jButton24)
                    .addGap(0, 0, Short.MAX_VALUE)))
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
//        if (evt.getX()==x & evt.getY()==y){
//            kt=1;
//        }else{
//            x=evt.getX();
//            y=evt.getY();
//        }
//        if (kt==1){
//            fillChinhSua();
//            kt=0;
//            x=0;
//            y=0;
//        }
    }//GEN-LAST:event_tblThongKeXeMousePressed

    private void tblThongKeXeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThongKeXeMouseReleased

    }//GEN-LAST:event_tblThongKeXeMouseReleased

    private void btnSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXepActionPerformed
//        Comparator<CuaHang> sortName = new Comparator<CuaHang>() {
//            @Override
//            public int compare(CuaHang s1, CuaHang s2) {
//                return s1.getTenCuaHang().compareTo(s2.getTenCuaHang());
//            }
//        };
//        Comparator<CuaHang> sortMaCH = new Comparator<CuaHang>() {
//            @Override
//            public int compare(CuaHang s1, CuaHang s2) {
//                return s1.getMaCh().compareTo(s2.getMaCh());
//            }
//        };
//        if(btnSapXep.getText().equals("Sắp xếp theo tên")){
//            Collections.sort(list,sortName);
//            btnSapXep.setText("Sắp xếp theo mã");
//        }else{
//            Collections.sort(list,sortMaCH);
//            btnSapXep.setText("Sắp xếp theo tên");
//        }
//        DefaultTableModel model = (DefaultTableModel) tblCuaHang.getModel();
//        model.setRowCount(0);
//        try {
//            for (CuaHang ch : list) {
//                Object[] row = {
//                    ch.getMaCh(),
//                    ch.getTenCuaHang(),
//                    ch.getDiaChi(),
//                    ch.getSdt(),
//                    ch.getEmail()
//                };
//                model.addRow(row);
//            }
//        }
//        catch (Exception e) {
//            JOptionPane.showMessageDialog(this, "lỗi truy vẫn dữ liệu"+e);
//        }
    }//GEN-LAST:event_btnSapXepActionPerformed

    private void btnSapXep1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXep1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSapXep1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel QuanLyCuaHang;
    private javax.swing.JButton btnSapXep;
    private javax.swing.JButton btnSapXep1;
    private javax.swing.JComboBox<String> cboTimKiem4;
    private javax.swing.JComboBox<String> cboTimKiem5;
    private javax.swing.JButton jButton24;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tblThongKeXe;
    // End of variables declaration//GEN-END:variables
}