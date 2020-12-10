
package com.xemay.view;

import com.xemay.dao.TaiKhoanDAO;
import com.xemay.dao.TinNhanDAO;
import com.xemay.helper.ShareHelper;
import com.xemay.model.TaiKhoan;
import com.xemay.model.TinNhan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class TinNhanJpanel extends javax.swing.JPanel {

  
    DefaultListModel model;
    TinNhanDAO dao = new TinNhanDAO();
    List<TinNhan> list;
    List<TinNhan> temp;
    TaiKhoanDAO tk= new TaiKhoanDAO();
    List<TaiKhoan> dataTK = tk.selectAll();
    String USER = ShareHelper.TaiKhoan.getMaTk();
    
    public TinNhanJpanel() {
        initComponents();
        load();
        Thread t = new Thread(new Loader());
		t.start();
        cboUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = cboUser.getSelectedIndex();
                if (i >=0 ) {
                    txtTenNguoiGui.setText(dataTK.get(i).getHoTen());
                    txtTenNguoiGui1.setText(dataTK.get(i).getHoTen());
                }
                list = dao.selectAll(USER, cboUser.getSelectedItem().toString());
                tpnChat.setText("");
                for (TinNhan tinNhan : list) {
                    tpnChat.setText(tpnChat.getText()+tinNhan.getMaNguoiGui()+" : "+tinNhan.getNoiDung()+ "\n");
                    System.out.println(tinNhan.getNoiDung());
                }
            }

        });

    }
    class Loader implements Runnable {
        public void run() {
            while (true) {
                temp = dao.selectAll(USER, cboUser.getSelectedItem().toString());
                if (temp.size() > list.size()) {
                    int i = cboUser.getSelectedIndex();
                    if (i >= 0) {
                        txtTenNguoiGui.setText(dataTK.get(i).getHoTen());
                        txtTenNguoiGui1.setText(dataTK.get(i).getHoTen());
                    }
                    list = dao.selectAll(USER, cboUser.getSelectedItem().toString());
                    tpnChat.setText("");
                    for (TinNhan tinNhan : list) {
                        tpnChat.setText(tpnChat.getText() + tinNhan.getMaNguoiGui() + " : " + tinNhan.getNoiDung() + "\n");
                        System.out.println(tinNhan.getNoiDung());
                    }
                }
                try {

                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("loii" + e.toString());
                }
            }

        }
    }

    
    void load(){
        cboUser.removeAllItems();
        for (TaiKhoan taiKhoan : dataTK) {
            if(!taiKhoan.getMaTk().equals(USER)){
                cboUser.addItem(taiKhoan.getMaTk());
            }
        }
        if(dataTK.size()>0){
            txtTenNguoiGui.setText(dataTK.get(0).getHoTen());
            txtTenNguoiGui1.setText(dataTK.get(0).getHoTen());
            list = dao.selectAll(USER, cboUser.getSelectedItem().toString());
                for (TinNhan tinNhan : list) {
                    tpnChat.setText(tpnChat.getText()+tinNhan.getMaNguoiGui()+" : "+tinNhan.getNoiDung()+ "\n");
                }
        }
    }
    
    TinNhan model(){
        TinNhan model = new TinNhan();
        model.setMaNguoiGui(USER);
        model.setMaNguoiNhan(cboUser.getSelectedItem().toString());
        model.setNoiDung(txtNoiDung.getText());
        return model;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TinNhan = new javax.swing.JPanel();
        txtNoiDung = new javax.swing.JTextField();
        btnGui = new javax.swing.JButton();
        txtTenNguoiGui = new javax.swing.JLabel();
        cboUser = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tpnChat = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        txtHoTen = new javax.swing.JTextField();
        txtTenNguoiGui1 = new javax.swing.JLabel();

        TinNhan.setBackground(new java.awt.Color(255, 255, 255));

        txtNoiDung.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnGui.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGui.setText("Gửi");
        btnGui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuiActionPerformed(evt);
            }
        });

        txtTenNguoiGui.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTenNguoiGui.setText("Đặng Thanh Bình");

        cboUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Đang Chat với :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Chọn người muốn gửi tin nhắn");

        tpnChat.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(tpnChat);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Tìm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtHoTen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtTenNguoiGui1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtTenNguoiGui1.setText("Đặng Thanh Bình");

        javax.swing.GroupLayout TinNhanLayout = new javax.swing.GroupLayout(TinNhan);
        TinNhan.setLayout(TinNhanLayout);
        TinNhanLayout.setHorizontalGroup(
            TinNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TinNhanLayout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addGroup(TinNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(TinNhanLayout.createSequentialGroup()
                        .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                    .addComponent(cboUser, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNguoiGui1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(73, 73, 73)
                .addGroup(TinNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 881, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TinNhanLayout.createSequentialGroup()
                        .addComponent(txtNoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnGui, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TinNhanLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenNguoiGui, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(397, Short.MAX_VALUE))
        );
        TinNhanLayout.setVerticalGroup(
            TinNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TinNhanLayout.createSequentialGroup()
                .addGroup(TinNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TinNhanLayout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(TinNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenNguoiGui, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TinNhanLayout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(TinNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(cboUser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenNguoiGui1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(TinNhanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGui, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1841, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(TinNhan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 798, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(TinNhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuiActionPerformed
        try {
            dao.insert(model());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "gửi tin nhắn thành công");
        }
    }//GEN-LAST:event_btnGuiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TinNhan;
    private javax.swing.JButton btnGui;
    private javax.swing.JComboBox<String> cboUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane tpnChat;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtNoiDung;
    private javax.swing.JLabel txtTenNguoiGui;
    private javax.swing.JLabel txtTenNguoiGui1;
    // End of variables declaration//GEN-END:variables
}
