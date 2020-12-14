/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.view;

import com.xemay.dao.HoaDonXuatDAO;
import com.xemay.dao.KhachHangDao;
import com.xemay.helper.ShareHelper;
import com.xemay.model.HoaDonXuat;
import com.xemay.model.KhachHang;
import com.xemay.utils.CheckLoi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class ThemHoaDonXuat extends javax.swing.JDialog {

    public ThemHoaDonXuat(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(ShareHelper.APP_ICON);
        setLocationRelativeTo(null);
        fillToKH();
        cboMaKH.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = cboMaKH.getSelectedIndex();
                if (i >= 0) {
                    lblHoTen.setText(list.get(i).getHoTen());
                    lblSoDienThoai.setText(list.get(i).getSdt());
                    lblDiaChi.setText(list.get(i).getDiaChi());
                }

            }
        });
        txtNgayXuat.setText(java.time.LocalDate.now().toString());
        List<HoaDonXuat> data = dao.selectAll();
        String s;
        if (data.size() - 1 < 0) {
            s = "0";
        } else {
            s = data.get(data.size() - 1).getMaHdx();
        }
        txtMaHDX.setText(ShareHelper.getMaXe("HDX", s));
        txtMaHDX.disable();
        txtMaNV.setText(ShareHelper.TaiKhoan.getMaNV());
        txtMaNV.disable();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblDiaChi = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();
        btnChiTiet = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cboMaKH = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtMaHDX = new javax.swing.JTextField();
        lblHoTen = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblSoDienThoai = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNgayXuat = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Hóa đơn xuất");
        setAutoRequestFocus(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblDiaChi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblDiaChi.setText("86 nguyễn sinh sắc");

        txtHoTen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnThem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnThem.setText("Thêm hóa đơn xuất");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnTim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        btnChiTiet.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnChiTiet.setText("Thêm chi tiết hóa đơn xuất");
        btnChiTiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChiTietMouseClicked(evt);
            }
        });
        btnChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Họ tên khách hàng");

        cboMaKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Họ Tên KH");

        txtMaHDX.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtMaHDX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHDXActionPerformed(evt);
            }
        });

        lblHoTen.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblHoTen.setText("Đặng Thanh Bình");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Mã hóa đơn xuất");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Mã khách hàng");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Số điện thoại");

        lblSoDienThoai.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSoDienThoai.setText("0999999");

        txtMaNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Địa chỉ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Mã nhân viên");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Ngày xuất");

        txtNgayXuat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 96, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnChiTiet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnThem))
                            .addComponent(cboMaKH, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtHoTen)
                                .addGap(18, 18, 18)
                                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblHoTen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSoDienThoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDiaChi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaHDX, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(txtNgayXuat)))
                .addGap(100, 100, 100))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaHDX)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaNV)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNgayXuat)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtHoTen)
                    .addComponent(btnTim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboMaKH)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    KhachHangDao dataKH = new KhachHangDao();
    List<KhachHang> list;

    Boolean check() {
        boolean ok = true;
        StringBuilder bd = new StringBuilder();
        CheckLoi.checkRong(txtMaHDX, bd, "Mã hóa đơn xuất không được để trống!\n");
        CheckLoi.checkRong(txtMaNV, bd, "Mã nhân viên không được để trống!\n");
        CheckLoi.checkNgayNhap(txtNgayXuat, bd);
        if (bd.length() > 0) {
            JOptionPane.showMessageDialog(this, bd.toString(), "Thông báo",
                    JOptionPane.ERROR_MESSAGE);
            ok = false;
        }
        return ok;
    }

    void fillToKH() {
        list = dataKH.findHoTen(txtHoTen.getText());
        cboMaKH.removeAllItems();
        for (KhachHang khachHang : list) {
            cboMaKH.addItem(khachHang.getMaKh());
        }
        if (list.size() > 0) {
            cboMaKH.setSelectedItem(list.get(0).getMaKh());
            lblHoTen.setText(list.get(0).getHoTen());
            lblSoDienThoai.setText(list.get(0).getSdt());
            lblDiaChi.setText(list.get(0).getDiaChi());
        }
    }
    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        fillToKH();
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (check() == true) {
            if (btnThem.getText().equals("Thêm hóa đơn xuất")) {
                this.themHoaDonXuat();
            } else {
                this.ChinhSua();
            }
        }

    }//GEN-LAST:event_btnThemActionPerformed

    void ChinhSua() {
        if (check()) {
            try {
                dao.update(model());
                JOptionPane.showMessageDialog(this, "Chỉnh sửa hóa đơn thành công");
                kt = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Chỉnh sửa hóa đơn thất bại", "Thông báo",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private void btnChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietActionPerformed
        if (kt == true) {
            ChiTietHoaDonXuat ct = new ChiTietHoaDonXuat(null, true);
            ct.txtMaHDX.setText(txtMaHDX.getText());
            ct.txtMaHDX.disable();
            ct.txtMaKH.setText(cboMaKH.getSelectedItem().toString());
            ct.txtMaKH.disable();
            ct.txtMaNV.setText(txtMaNV.getText());
            ct.txtMaNV.disable();
            ct.lblHoTenKH.setText(lblHoTen.getText());
            ct.lblSoDienThoai.setText(lblSoDienThoai.getText());
            ct.txtNgayXuat.setText(txtNgayXuat.getText());
            ct.fillToTable();
            ct.show();
        }
    }//GEN-LAST:event_btnChiTietActionPerformed

    private void btnChiTietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChiTietMouseClicked

    }//GEN-LAST:event_btnChiTietMouseClicked

    private void txtMaHDXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHDXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHDXActionPerformed
    HoaDonXuatDAO dao = new HoaDonXuatDAO();
    Boolean kt = false;

    void themHoaDonXuat() {
        try {
            dao.insert(model());
            JOptionPane.showMessageDialog(this, "Thêm hóa đơn thành công");
            kt = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Thêm hóa đơn thất bại " + e, "Thông báo",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    HoaDonXuat model() {
        HoaDonXuat model = new HoaDonXuat();
        model.setMaHdx(txtMaHDX.getText());
        model.setMaNV(txtMaNV.getText());
        SimpleDateFormat Ngay = new SimpleDateFormat("yyyy-MM-dd");
        try {
            model.setNgayXuat(chuyenNgay(Ngay.parse(txtNgayXuat.getText())));
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(this, "ngày không đúng định dạng");
        }
        model.setMaKH(cboMaKH.getSelectedItem().toString());
        return model;
    }

    private static java.sql.Date chuyenNgay(java.util.Date date) {
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
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
            java.util.logging.Logger.getLogger(ThemHoaDonXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemHoaDonXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemHoaDonXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemHoaDonXuat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThemHoaDonXuat dialog = new ThemHoaDonXuat(new javax.swing.JFrame(), true);
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
    public javax.swing.JButton btnChiTiet;
    public javax.swing.JButton btnThem;
    public javax.swing.JButton btnTim;
    public javax.swing.JComboBox<String> cboMaKH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblSoDienThoai;
    public javax.swing.JTextField txtHoTen;
    public javax.swing.JTextField txtMaHDX;
    public javax.swing.JTextField txtMaNV;
    public javax.swing.JTextField txtNgayXuat;
    // End of variables declaration//GEN-END:variables

}
