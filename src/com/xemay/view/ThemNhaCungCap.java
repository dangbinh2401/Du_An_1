/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.view;

import com.xemay.dao.NhaCungCapDAO;
import com.xemay.helper.ShareHelper;
import com.xemay.model.NhaCungCap;
import com.xemay.utils.CheckLoi;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ThemNhaCungCap extends javax.swing.JDialog {

    /**
     * Creates new form ThemNhaCungCap
     */
    public ThemNhaCungCap(java.awt.Frame parent, boolean modal, NhaCungCap ncc) {
        super(parent, modal);
        initComponents();
        setIconImage(ShareHelper.APP_ICON);
        if(ncc != null) {
            showDataOnView(ncc);
        }
        NhaCungCapDAO daoNCC= new NhaCungCapDAO();
        this.setLocationRelativeTo(null);
                List<NhaCungCap> data=daoNCC.selectAll();
        String s;
        if (data.size()-1<0){
            s="0";
        }else{
            s=data.get(data.size()-1).getMaNcc();
        }
        System.out.println(s);
        //ShareHelper.getMaXe("XE", s);
        txtMaNcc.setText(ShareHelper.getMaXe("NCC", s));
        txtMaNcc.disable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtEmailNcc = new javax.swing.JTextField();
        txtSoDienThoaiNcc = new javax.swing.JTextField();
        txtDiaChiNcc = new javax.swing.JTextField();
        txtTenNcc = new javax.swing.JTextField();
        txtMaNcc = new javax.swing.JTextField();
        btnThemNcc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Mã:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Tên nhà cung cấp:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Địa chỉ:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Số điện thoại:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Email:");

        txtEmailNcc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtSoDienThoaiNcc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtDiaChiNcc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtTenNcc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtMaNcc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnThemNcc.setText("Thêm mới");
        btnThemNcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNccActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmailNcc)
                            .addComponent(txtSoDienThoaiNcc)
                            .addComponent(txtDiaChiNcc)
                            .addComponent(txtMaNcc)
                            .addComponent(txtTenNcc, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnThemNcc)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaNcc, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenNcc, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDiaChiNcc, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoDienThoaiNcc, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmailNcc, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jLabel7))
                .addGap(31, 31, 31)
                .addComponent(btnThemNcc)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemNccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNccActionPerformed
        if(btnThemNcc.getText().equals("Thêm mới")){
             this.themMoiNcc();
         }else{
            this.capNhatNcc();
         }
    }//GEN-LAST:event_btnThemNccActionPerformed

    private boolean check(){
        boolean ok = true;
        StringBuilder bd = new StringBuilder();
        CheckLoi.checkRong(txtMaNcc, bd,"Mã nhà cung cấp chưa nhập\n");
        CheckLoi.checkRong(txtTenNcc, bd,"Tên nhà cung cấp chưa nhập\n");
        CheckLoi.checkRong(txtDiaChiNcc, bd,"Địa chỉ nhà cung cấp\n");
        CheckLoi.checkSoDienThoai(txtSoDienThoaiNcc, bd);
        CheckLoi.checkEmail(txtEmailNcc, bd);
        if (bd.length() > 0) {
            JOptionPane.showMessageDialog(this,bd.toString(),"Thông báo",
                    JOptionPane.ERROR_MESSAGE);
            ok = false;
        }
        return ok;
    }
    
    public void themMoiNcc(){
        if (check()) {
            NhaCungCapDAO dao = new NhaCungCapDAO();
            if (dao.selectByIdTxt(txtMaNcc.getText()) != null) {
                JOptionPane.showMessageDialog(this,"Mã đã tồn tại","Thông báo",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                dao.insert(model());
                JOptionPane.showMessageDialog(this,"Thêm thành công");                

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Thêm thất bại","Thông báo",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public NhaCungCap model(){
        NhaCungCap nhaCungCap = new NhaCungCap();
        nhaCungCap.setMaNcc(txtMaNcc.getText());
        nhaCungCap.setTenNcc(txtTenNcc.getText());
        nhaCungCap.setDiaChi(txtDiaChiNcc.getText());
        nhaCungCap.setSdt(txtSoDienThoaiNcc.getText());
        nhaCungCap.setEmail(txtEmailNcc.getText());
        return nhaCungCap;
    }
    
    private void showDataOnView(NhaCungCap nhaCungCap){
        txtMaNcc.setText(nhaCungCap.getMaNcc());
        txtTenNcc.setText(nhaCungCap.getTenNcc());
        txtDiaChiNcc.setText(nhaCungCap.getDiaChi());
        txtSoDienThoaiNcc.setText(nhaCungCap.getSdt());
        txtEmailNcc.setText(nhaCungCap.getEmail());
    }
    
    private void capNhatNcc(){
        if (check()) {
            NhaCungCapDAO dao = new NhaCungCapDAO();
            try {
                if (JOptionPane.showConfirmDialog(this,"Bạn có chắc chắn muốn cập nhật không")== JOptionPane.YES_OPTION) {
                    dao.update(model());
                    JOptionPane.showMessageDialog(this,"Cập nhật thành công");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Thông báo","Cập nhật thành công",
                        JOptionPane.ERROR_MESSAGE);
            }
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
            java.util.logging.Logger.getLogger(ThemNhaCungCap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemNhaCungCap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemNhaCungCap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemNhaCungCap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThemNhaCungCap dialog = new ThemNhaCungCap(new javax.swing.JFrame(), true, null);
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
    public javax.swing.JButton btnThemNcc;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JTextField txtDiaChiNcc;
    public javax.swing.JTextField txtEmailNcc;
    public javax.swing.JTextField txtMaNcc;
    public javax.swing.JTextField txtSoDienThoaiNcc;
    public javax.swing.JTextField txtTenNcc;
    // End of variables declaration//GEN-END:variables


}
