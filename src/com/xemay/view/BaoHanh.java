/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.view;

import com.xemay.dao.BaoHanhDAO;
import com.xemay.dao.XeDAO;
import com.xemay.dao.KhachHangDao;
import com.xemay.helper.ShareHelper;
import javax.swing.UIManager;
import com.xemay.model.KhachHang;
import com.xemay.model.Xe;
import com.xemay.model.BaoHang;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class BaoHanh extends javax.swing.JDialog {

    KhachHangDao khdao = new KhachHangDao();
    BaoHanhDAO bhDao = new BaoHanhDAO();
    SimpleDateFormat date_Format = new SimpleDateFormat("dd/MM/yyyy");
    /**
     * Creates new form baoHanh
     */
    public BaoHanh(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
        } catch (Exception ex) {
        }
        initComponents();
        setLocationRelativeTo(null);
        fillComboxXe();
        timKiemTenKH();
        cboMaKhachHang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i = cboMaKhachHang.getSelectedIndex();
                if (i >= 0) {
                    lblHoTen.setText(listKH.get(i).getHoTen());
                    lblDiaChi.setText(listKH.get(i).getDiaChi());
                    lblSDT.setText(listKH.get(i).getSdt());
                }

            }
        });
                List<BaoHang> data=bhDao.selectAll();
        String s;
        if (data.size()-1<0){
            s="0";
        }else{
            s=data.get(data.size()-1).getMaBh();
        }
        txtMaBaoHanh.setText(ShareHelper.getMaXe("BH", s));
        txtMaBaoHanh.disable();
        txtMaNhanVien.setText(ShareHelper.TaiKhoan.getMaNV());
        txtMaNhanVien.disable();
    }
    

    public void fillComboxXe() {
        XeDAO dao = new XeDAO();
        List<Xe> list = dao.selectTong();
        cboMaXe.removeAllItems();
        for (Xe xe : list) {
            cboMaXe.addItem(xe.getMaXe());
        }
    }
    List<KhachHang> listKH = null;

    public void timKiemTenKH() {
        KhachHangDao dao = new KhachHangDao();
        listKH = dao.find(txtHoTenKH.getText());
        if (listKH.size()>0) {
            cboMaKhachHang.removeAllItems();
            for (KhachHang khachHang : listKH) {
                cboMaKhachHang.addItem(khachHang.getMaKh());
            }
            lblHoTen.setText(listKH.get(0).getHoTen());
            lblDiaChi.setText(listKH.get(0).getDiaChi());
            lblSDT.setText(listKH.get(0).getSdt());
        }
    }

    public void setModel(BaoHang baoHang) {
        String tenKh = khdao.selectByMa(baoHang.getMaKh()).getHoTen();
        String diaChiKh = khdao.selectByMa(baoHang.getMaKh()).getDiaChi();
        String soDTKh = khdao.selectByMa(baoHang.getMaKh()).getSdt();
        txtMaNhanVien.setText(baoHang.getMaNv());
        txtHoTenKH.setText(tenKh);
        cboMaKhachHang.setSelectedItem(baoHang.getMaKh());
        lblHoTen.setText(tenKh);
        lblDiaChi.setText(diaChiKh);
        lblSDT.setText(soDTKh);
        cboMaXe.setSelectedItem(baoHang.getMaXe());
        try {
            txtNgayBaoHanh.setText(date_Format.format(baoHang.getNgayBaoHanh()));
        } catch(Exception e) {
            txtNgayBaoHanh.setText("");
        }
        txtNoiDungBaoHanh.setText(baoHang.getNoidungBh());
    }

    public  BaoHang getModel(){
        BaoHang baoHanh = new BaoHang();
        baoHanh.setMaBh(txtMaBaoHanh.getText());
        baoHanh.setMaXe((String) cboMaXe.getSelectedItem());
        baoHanh.setMaNv(txtMaNhanVien.getText());
        baoHanh.setMaKh((String) cboMaKhachHang.getSelectedItem());
        baoHanh.setNoidungBh(txtNoiDungBaoHanh.getText());
        return baoHanh;
    }
    
    public void themBaoHanh() {
        StringBuilder bd = new StringBuilder();
        
        if (bhDao.selectByIdTimKiem(txtMaBaoHanh.getText()) != null) {
            JOptionPane.showMessageDialog(this,"Mã đã tồn tại","Thông báo",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            bhDao.insert(getModel());
            JOptionPane.showMessageDialog(this,"Thêm thành công");                
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Thêm thất bại","Thông báo",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void suaBaoHanh() {
        try {
            if (JOptionPane.showConfirmDialog(this,"Bạn có chắc chắn muốn cập nhật không")== JOptionPane.YES_OPTION) {
                bhDao.update(getModel());
                JOptionPane.showMessageDialog(this,"Cập nhật thành công");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Thông báo","Cập nhật thành công",
                    JOptionPane.ERROR_MESSAGE);
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

        jPanel1 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        txtHoTenKH = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboMaKhachHang = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cboMaXe = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        lblSDT = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblDiaChi = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblHoTen = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        txtNgayBaoHanh = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNoiDungBaoHanh = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        txtMaBaoHanh = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Bảo Hành");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnThem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jButton1.setText("Chọn");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Ngày bảo hành:");

        txtHoTenKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Địa chỉ khách hàng:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Mã nhân viên:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Họ tên khách hàng: ");

        cboMaKhachHang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Mã khách hàng:");

        cboMaXe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Mã xe:");

        lblSDT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSDT.setText("jLabel4");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Số điện thoại:");

        lblDiaChi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDiaChi.setText("jLabel4");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Họ tên khách hàng: ");

        lblHoTen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtMaNhanVien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNhanVienActionPerformed(evt);
            }
        });

        txtNgayBaoHanh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Nội dung bảo hành:");

        txtNoiDungBaoHanh.setColumns(20);
        txtNoiDungBaoHanh.setRows(5);
        jScrollPane1.setViewportView(txtNoiDungBaoHanh);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Mã bão hành:");

        txtMaBaoHanh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtMaBaoHanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaBaoHanhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(lblSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(217, 217, 217))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(60, 60, 60)
                                .addComponent(txtHoTenKH)
                                .addGap(92, 92, 92))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(jLabel1))
                                .addGap(63, 63, 63)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblDiaChi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(54, 54, 54))
                                    .addComponent(txtNgayBaoHanh)
                                    .addComponent(cboMaXe, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
                                    .addComponent(cboMaKhachHang, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel13))
                                .addGap(60, 60, 60)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaNhanVien)
                                    .addComponent(txtMaBaoHanh))))
                        .addGap(64, 64, 64))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaBaoHanh, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaNhanVien)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboMaXe, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNgayBaoHanh)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNhanVienActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (btnThem.getText().equals("Thêm")) {
            this.themBaoHanh();
        } else {
            this.suaBaoHanh();
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        timKiemTenKH();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtMaBaoHanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaBaoHanhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaBaoHanhActionPerformed

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
            java.util.logging.Logger.getLogger(BaoHanh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BaoHanh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BaoHanh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BaoHanh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BaoHanh dialog = new BaoHanh(new javax.swing.JFrame(), true);
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
    public javax.swing.JComboBox<String> cboMaKhachHang;
    public javax.swing.JComboBox<String> cboMaXe;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblDiaChi;
    public javax.swing.JLabel lblHoTen;
    public javax.swing.JLabel lblSDT;
    public javax.swing.JTextField txtHoTenKH;
    public javax.swing.JTextField txtMaBaoHanh;
    public javax.swing.JTextField txtMaNhanVien;
    public javax.swing.JTextField txtNgayBaoHanh;
    public javax.swing.JTextArea txtNoiDungBaoHanh;
    // End of variables declaration//GEN-END:variables
}
