/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.view;

import com.xemay.dao.ChiTietHoaDonNhapDAO;
import com.xemay.dao.XeDAO;
import com.xemay.model.ChiTietHDN;
import com.xemay.model.HoaDonNhap;
import com.xemay.model.Xe;
import com.xemay.utils.CheckLoi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class ThemChiTietHoaDonNhap extends javax.swing.JDialog {

    /**
     * Creates new form ThemChiTietHoaDonNhap
     */
    public int SoLuongGoc = 0;
    public ThemChiTietHoaDonNhap(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        fillToXe();
        cboMaXe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = cboMaXe.getSelectedIndex();
                if (i >= 0) {
                    cboMaXe.setSelectedItem(list.get(i).getMaXe());
                    lblTenXe.setText(list.get(i).getTenXe());
                    lblNamSX.setText(String.valueOf(list.get(i).getNamSx()));
                    lblDungTich.setText(String.valueOf(list.get(i).getDungTich()));
//                    NumberFormat formatter = new DecimalFormat("#,###,###");
//                    String formattedNumber = formatter.format(list.get(i).getGiaTienBan());
//                    lblGiaBan.setText(formattedNumber);
                }
            }
        });
    }
    XeDAO dataXe = new XeDAO();
    List<Xe> list;

    void fillToXe() {
        list = dataXe.findTenXe(txtTenXe.getText());
        cboMaXe.removeAllItems();
        for (Xe dataXe : list) {
            cboMaXe.addItem(dataXe.getMaXe());
        }
        if (list.size() > 0) {
            cboMaXe.setSelectedItem(list.get(0).getMaXe());
            lblTenXe.setText(list.get(0).getTenXe());
            lblNamSX.setText(String.valueOf(list.get(0).getNamSx()));
            lblDungTich.setText(String.valueOf(list.get(0).getDungTich()));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtMaHDN = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtTenXe = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cboMaXe = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblNamSX = new javax.swing.JLabel();
        lblDungTich = new javax.swing.JLabel();
        lblTenXe = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtGiaTien = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm sản phẩm");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtMaHDN.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Mã hóa đơn nhập");

        txtTenXe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tên Xe");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Tìm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cboMaXe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboMaXe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Tên xe");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Năm sản xuất:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Dung tích:");

        lblNamSX.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblDungTich.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblTenXe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Mã xe");

        btnThem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Số lượng");

        txtSoLuong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Giá tiền nhập");

        txtGiaTien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboMaXe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaHDN)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTenXe)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblNamSX, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(lblDungTich, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
                            .addComponent(lblTenXe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtSoLuong)
                            .addComponent(txtGiaTien))))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaHDN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenXe)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(cboMaXe))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(lblTenXe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNamSX, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDungTich, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        fillToXe();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if(btnThem.getText().equals("Thêm")){
            this.them();
        }else{
            this.chinhSua();
        }
    }//GEN-LAST:event_btnThemActionPerformed
    
    private boolean check(){
        boolean ok = true;
        StringBuilder bd = new StringBuilder();
        CheckLoi.checkSo(txtSoLuong, bd,"Số lượng chưa nhập\n","Số lượng");
        CheckLoi.checkSo(txtGiaTien, bd,"Giá tiền chưa nhập\n","Giá tền");
        if (bd.length()>0) {
            JOptionPane.showMessageDialog(this,bd.toString(),"Thông báo",
                    JOptionPane.ERROR_MESSAGE);
            ok=false;
        }
        return ok;
    }
    
    void them(){
        if (check()) {
            try {
                dao.insert(model());
                XeDAO xe = new XeDAO();
                int i = Integer.valueOf(txtSoLuong.getText());
                xe.update(list.get(cboMaXe.getSelectedIndex()).getSoLuong()+i, cboMaXe.getSelectedItem().toString());   
                JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công!");
            } catch (Exception e) {
                 //System.out.println(list.get(cboMaXe.getSelectedIndex()).getSoLuong()+Integer.getInteger(txtSoLuong.getText()));
                JOptionPane.showMessageDialog(this,"Thêm sản phẩm thất bại!"+e,"Thông báo",
                        JOptionPane.ERROR_MESSAGE);
            }   
        }
    }
    void chinhSua(){
        if (check()) {
            try {
                if(list.get(cboMaXe.getSelectedIndex()).getSoLuong()-(SoLuongGoc-Integer.valueOf(txtSoLuong.getText()))<0){
                    JOptionPane.showMessageDialog(this, "Số lượng nhiều hơn số lượng xe trong kho!"); 
                }else{
                    XeDAO xe = new XeDAO();
                    xe.update(list.get(cboMaXe.getSelectedIndex()).getSoLuong()-(SoLuongGoc-Integer.valueOf(txtSoLuong.getText())), cboMaXe.getSelectedItem().toString());
                    dao.update(model());
                    JOptionPane.showMessageDialog(this, "Chỉnh sửa sản phẩm thành công!");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Chỉnh sửa sản phẩm thất bại!"+e,"Thông báo",
                        JOptionPane.ERROR_MESSAGE);
            }   
        }
    }
    ChiTietHDN model(){
        ChiTietHDN model = new ChiTietHDN();
        model.setMaHDN(txtMaHDN.getText());
        model.setMaXe(cboMaXe.getSelectedItem().toString());
        model.setSoLuong(Integer.valueOf(txtSoLuong.getText()));
        model.setGiaTienNhap(Float.valueOf(txtGiaTien.getText()));
        return model;
    }
    ChiTietHoaDonNhapDAO dao = new ChiTietHoaDonNhapDAO();
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThemChiTietHoaDonNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemChiTietHoaDonNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemChiTietHoaDonNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemChiTietHoaDonNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThemChiTietHoaDonNhap dialog = new ThemChiTietHoaDonNhap(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnThem;
    public javax.swing.JComboBox<String> cboMaXe;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDungTich;
    private javax.swing.JLabel lblNamSX;
    private javax.swing.JLabel lblTenXe;
    public javax.swing.JTextField txtGiaTien;
    public javax.swing.JTextField txtMaHDN;
    public javax.swing.JTextField txtSoLuong;
    public javax.swing.JTextField txtTenXe;
    // End of variables declaration//GEN-END:variables
}
