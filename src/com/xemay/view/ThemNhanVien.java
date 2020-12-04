/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.view;

import com.xemay.dao.CuaHangDAO;
import com.xemay.dao.NhanVienDAO;
import com.xemay.dao.TaiKhoanDAO;
import com.xemay.helper.ShareHelper;
import com.xemay.model.CuaHang;
import com.xemay.model.NhanVien;
import com.xemay.model.TaiKhoan;
import com.xemay.utils.CheckLoi;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author ADMIN
 */
public class ThemNhanVien extends javax.swing.JDialog {

    /**
     * Creates new form themNhanVien
     */
    public ThemNhanVien(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
                try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
        } catch (Exception ex) {
        }
        initComponents();
        setLocationRelativeTo(null);
        fillMaCH();
                        List<NhanVien> data=dao.select();
        String s;
        if (data.size()-1<0){
            s="0";
        }else{
            s=data.get(data.size()-1).getMaNV();
        }
        txtMaNhanVien.setText(ShareHelper.getMaXe("NV", s));
        txtMaNhanVien.disable(); 
    }
    NhanVienDAO dao = new NhanVienDAO();
    void fillMaCH(){
        CuaHangDAO dao = new CuaHangDAO();
        List <CuaHang> list = dao.select();
        cboMaCuaHang.removeAllItems();
        for (CuaHang cuaHang : list) {
            cboMaCuaHang.addItem(cuaHang.getMaCh());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgrGioiTinh = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnThemNV = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cboMaCuaHang = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        txtDiaChi = new javax.swing.JTextField();
        txtMaTaiKhoan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nhân viên");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnThemNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnThemNV.setText("Thêm nhân viên");
        btnThemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNVActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Họ Tên");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Mã nhân viên");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Số điện thoại");

        txtMaNhanVien.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Email");

        cboMaCuaHang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboMaCuaHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMaCuaHangActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Giới tính");

        txtHoTen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Địa chỉ");

        txtSoDienThoai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Mã tài khoản");

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        rdoNam.setBackground(new java.awt.Color(255, 255, 255));
        btgrGioiTinh.add(rdoNam);
        rdoNam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");

        rdoNu.setBackground(new java.awt.Color(255, 255, 255));
        btgrGioiTinh.add(rdoNu);
        rdoNu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdoNu.setText("Nữ");

        txtDiaChi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtMaTaiKhoan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Mã cửa hàng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnThemNV)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaTaiKhoan, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cboMaCuaHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHoTen)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdoNam)
                                .addGap(18, 18, 18)
                                .addComponent(rdoNu)
                                .addGap(0, 291, Short.MAX_VALUE))
                            .addComponent(txtMaNhanVien))))
                .addGap(52, 52, 52))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboMaCuaHang)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtHoTen)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdoNam)
                        .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaTaiKhoan)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(btnThemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void cboMaCuaHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMaCuaHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboMaCuaHangActionPerformed

    private void btnThemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNVActionPerformed
        if(btnThemNV.getText().equals("Thêm nhân viên")){
            this.themNV();
        }else{
            this.chinhSuaNV();
        }
    }//GEN-LAST:event_btnThemNVActionPerformed
    TaiKhoan mdTk(){
        TaiKhoan mdTk = new TaiKhoan();
        mdTk.setMaTk(txtMaTaiKhoan.getText());
        mdTk.setMatKhau("123");
        mdTk.setVaiTro("NhanVien");
        return mdTk;
    }
    void themNV(){
        StringBuilder bd = new StringBuilder();
        CheckLoi.checkRong(txtMaNhanVien,bd,"Mã nhân viên chưa nhập");
        try {
            if (checkMaTK()==true){
                tk.insert(mdTk());
                dao.insert(model());
                JOptionPane.showMessageDialog(this, "thêm nhân viên thành công!");
            }else{
                JOptionPane.showMessageDialog(this, "Mã tài khoản đã có người sử dụng!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Mã nhân viên đã có trong danh sách!"+e.toString());
        }
    }
    TaiKhoanDAO tk = new TaiKhoanDAO();
    boolean checkMaTK(){
        List <TaiKhoan> checkma = tk.findMaTK(txtMaTaiKhoan.getText());
        boolean kt = true;
        if (checkma.size()==1){
            kt = false;
        }
        return kt;
    }
    NhanVien model(){
        NhanVien model = new NhanVien();
        model.setMaNV(txtMaNhanVien.getText());
        model.setHoTen(txtHoTen.getText());
        model.setMaCH(cboMaCuaHang.getSelectedItem().toString());
        model.setSdt(txtSoDienThoai.getText());
        model.setEmail(txtEmail.getText());
        model.setGioiTinh(rdoNam.isSelected());
        model.setDiaChi(txtDiaChi.getText());
        model.setMaTK(txtMaTaiKhoan.getText());
        return model;
    }
    
    void chinhSuaNV(){
        try {
            dao.update(model());
            JOptionPane.showMessageDialog(this, "Chỉnh sửa thành công !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chỉnh sửa thất bại");
            
        }
    }
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
            java.util.logging.Logger.getLogger(ThemNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThemNhanVien dialog = new ThemNhanVien(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup btgrGioiTinh;
    public javax.swing.JButton btnThemNV;
    public javax.swing.JComboBox<String> cboMaCuaHang;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JRadioButton rdoNam;
    public javax.swing.JRadioButton rdoNu;
    public javax.swing.JTextField txtDiaChi;
    public javax.swing.JTextField txtEmail;
    public javax.swing.JTextField txtHoTen;
    public javax.swing.JTextField txtMaNhanVien;
    public javax.swing.JTextField txtMaTaiKhoan;
    public javax.swing.JTextField txtSoDienThoai;
    // End of variables declaration//GEN-END:variables
}
