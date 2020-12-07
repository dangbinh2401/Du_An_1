/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.view;

import com.xemay.model.BaoHang;
import com.xemay.model.KhachHang;
import com.xemay.dao.XeDAO;
import com.xemay.dao.KhachHangDao;
import com.xemay.dao.BaoHanhDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
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
public class BaoHanhJPanel extends javax.swing.JPanel {

    public List<BaoHang> dataBaoHanh;
    private List<KhachHang> dataKhachHang;
    SimpleDateFormat date_Format = new SimpleDateFormat("dd/MM/yyyy");
    BaoHanhDAO bhDao = new BaoHanhDAO();
    KhachHangDao khDao = new KhachHangDao();
    XeDAO xeDao = new XeDAO();
    BaoHang baoHang = new BaoHang();
    
    /**
     * Creates new form baoHanhJPanel
     */
    public BaoHanhJPanel() {
        initComponents();
        fillTable();
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
                cboTimKiemBaoHanh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = cboTimKiemBaoHanh.getSelectedIndex();
                if (i >=0 ) {
                    timKiem();
                }

            }
        });
    }
    void timKiem(){
        String tk=cboTimKiemBaoHanh.getSelectedItem().toString();
        //Tìm kiếm theo tên khách hàng, Tìm kiếm theo mã bảo hành, Tìm kiếm theo tên xe
        if (tk.equals("Tìm kiếm theo tên khách hàng")){
            dataBaoHanh = bhDao.selectByTenKh(txtTimKiem.getText());
        }
        if (tk.equals("Tìm kiếm theo mã bảo hành")){
            dataBaoHanh = bhDao.selectByKeyWord(txtTimKiem.getText());
        }
        if (tk.equals("Tìm kiếm theo tên xe")){
            dataBaoHanh = bhDao.selectByTenXe(txtTimKiem.getText());
        }
                DefaultTableModel model = (DefaultTableModel) tblBaoHanh.getModel();
        model.setRowCount(0);
        int i = 1;
        try {
            //dataBaoHanh = bhDao.selectAll();
            for (BaoHang bh : dataBaoHanh) {
                Object[] row = {
                    i++,
                    bh.getMaBh(),
                    bh.getTenKhachHang(),
                    bh.getTenXe(),
                    bh.getNgayBaoHanh(),
                    bh.getNoidungBh()
                };
                model.addRow(row); 
                model.fireTableDataChanged();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"lỗi truy vẫn dữ liệu");
        }
    }
    void fillTable(){
        DefaultTableModel model = (DefaultTableModel) tblBaoHanh.getModel();
        model.setRowCount(0);
        int i = 1;
        try {
            dataBaoHanh = bhDao.selectAll();
            for (BaoHang bh : dataBaoHanh) {
                Object[] row = {
                    i++,
                    bh.getMaBh(),
                    bh.getTenKhachHang(),
                    bh.getTenXe(),
                    bh.getNgayBaoHanh(),
                    bh.getNoidungBh()
                };
                model.addRow(row); 
                model.fireTableDataChanged();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"lỗi truy vẫn dữ liệu");
        }
    }
    
    void update(){
        BaoHanh bh = new BaoHanh(null, true);
        bh.btnThem.setText("Cập nhật");
        int index = tblBaoHanh.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(this,"Chọn 1 hàng trước khi cập nhật","Thông báo",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            bh.txtMaBaoHanh.setText(dataBaoHanh.get(index).getMaBh());
            bh.txtMaBaoHanh.setEditable(false);
            bh.txtMaNhanVien.setText(dataBaoHanh.get(index).getMaNv());
            bh.cboMaKhachHang.setSelectedItem(dataBaoHanh.get(index).getMaKh());
            bh.cboMaXe.setSelectedItem(dataBaoHanh.get(index).getMaXe());
            bh.txtNgayBaoHanh.setText(date_Format.format(dataBaoHanh.get(index).getNgayBaoHanh()));
            bh.txtNoiDungBaoHanh.setText(dataBaoHanh.get(index).getNoidungBh());
            bh.show();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"Lỗi "+e);
        }
        fillTable();
    }

    void delete(){
        int index = tblBaoHanh.getSelectedRow();
        if (index >= 0) {
            BaoHang baoHang = dataBaoHanh.get(index);
            try {
                if (JOptionPane.showConfirmDialog(this,"Bạn có chắc chắn xóa không") == JOptionPane.YES_OPTION) {
                    bhDao.delete(baoHang.getMaBh());
                    JOptionPane.showMessageDialog(this,"Xóa thành công");
                    fillTable();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,"Xóa thất bại","Thông báo",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void timKiemTheoMaBH(){
        int i = 1;
        DefaultTableModel model = (DefaultTableModel) tblBaoHanh.getModel();
        model.setRowCount(0);
        try {
            dataBaoHanh = bhDao.selectByKeyWord(txtTimKiem.getText());
            for (BaoHang baoHang1 : dataBaoHanh) {
                Object[] row ={
                    i++,
                    baoHang1.getMaBh(),
                    baoHang1.getTenKhachHang(),
                    baoHang1.getTenXe(),
                    baoHang1.getNgayBaoHanh(),
                    baoHang1.getNoidungBh()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"lỗi truy vẫn dữ liệu");
        }
    }
    
    private void timKiemTheoTenKH(){
        int i = 1;
        DefaultTableModel model = (DefaultTableModel) tblBaoHanh.getModel();
        model.setRowCount(0);
        try {
            dataBaoHanh = bhDao.selectByTenKh(txtTimKiem.getText());
            for (BaoHang baoHang1 : dataBaoHanh) {
                Object[] row ={
                    i++,
                    baoHang1.getMaBh(),
                    baoHang1.getTenKhachHang(),
                    baoHang1.getTenXe(),
                    baoHang1.getNgayBaoHanh(),
                    baoHang1.getNoidungBh()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"lỗi truy vẫn dữ liệu");
        }
    }
    
    private void timKiemTheoTenXe(){
        int i = 1;
        DefaultTableModel model = (DefaultTableModel) tblBaoHanh.getModel();
        model.setRowCount(0);
        try {
            dataBaoHanh = bhDao.selectByTenXe(txtTimKiem.getText());
            for (BaoHang baoHang1 : dataBaoHanh) {
                Object[] row ={
                    i++,
                    baoHang1.getMaBh(),
                    baoHang1.getTenKhachHang(),
                    baoHang1.getTenXe(),
                    baoHang1.getNgayBaoHanh(),
                    baoHang1.getNoidungBh()
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

        BaoHanh = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cboTimKiemBaoHanh = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        btnSapXep = new javax.swing.JButton();
        btnTaoMoi = new javax.swing.JButton();
        btnChinhSua = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblBaoHanh = new javax.swing.JTable();
        btnXoa = new javax.swing.JButton();

        BaoHanh.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("PHIẾU BẢO HÀNH XE");

        cboTimKiemBaoHanh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cboTimKiemBaoHanh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tìm kiếm theo tên khách hàng", "Tìm kiếm theo mã bảo hành", "Tìm kiếm theo tên xe" }));
        cboTimKiemBaoHanh.setMinimumSize(new java.awt.Dimension(138, 35));

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTimKiem.setMinimumSize(new java.awt.Dimension(6, 35));

        btnTimKiem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnSapXep.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSapXep.setText("Sắp xếp theo tên");
        btnSapXep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSapXepActionPerformed(evt);
            }
        });

        btnTaoMoi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTaoMoi.setText("Tạo mới");
        btnTaoMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoMoiActionPerformed(evt);
            }
        });

        btnChinhSua.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnChinhSua.setText("Chỉnh sửa");
        btnChinhSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChinhSuaActionPerformed(evt);
            }
        });

        tblBaoHanh.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblBaoHanh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Bảo Hành", "Tên Khách Hàng", "Tên Xe", "Ngày Bảo Hành", "Nội Dung"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBaoHanh.setRowHeight(30);
        tblBaoHanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblBaoHanhMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tblBaoHanh);

        btnXoa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BaoHanhLayout = new javax.swing.GroupLayout(BaoHanh);
        BaoHanh.setLayout(BaoHanhLayout);
        BaoHanhLayout.setHorizontalGroup(
            BaoHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BaoHanhLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(BaoHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(BaoHanhLayout.createSequentialGroup()
                        .addComponent(cboTimKiemBaoHanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102)
                        .addComponent(btnSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(103, 103, 103)
                        .addComponent(btnTaoMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(btnChinhSua, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1715, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        BaoHanhLayout.setVerticalGroup(
            BaoHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BaoHanhLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BaoHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaoMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChinhSua, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSapXep, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTimKiemBaoHanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BaoHanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BaoHanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoMoiActionPerformed
        BaoHanh bh = new BaoHanh(null, true);
        bh.txtNgayBaoHanh.setEditable(false);
        bh.show();
        fillTable();
    }//GEN-LAST:event_btnTaoMoiActionPerformed

    private void btnChinhSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChinhSuaActionPerformed
        this.update();
    }//GEN-LAST:event_btnChinhSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        this.delete();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSapXepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSapXepActionPerformed
        int i =1;
        Comparator<BaoHang> sortName = new Comparator<BaoHang>() {
            @Override
            public int compare(BaoHang s1, BaoHang s2) {
                return s2.getMaBh().compareTo(s1.getMaBh());
            }
        }; 
        Collections.sort(dataBaoHanh,sortName);
           
        DefaultTableModel model = (DefaultTableModel) tblBaoHanh.getModel(); 
        model.setRowCount(0); 
        try {
            for (BaoHang bh : this.dataBaoHanh) {
                String tenKh = khDao.selectByMa(bh.getMaKh()).getHoTen();
                String tenXe = xeDao.selectByIdTimKiem(bh.getMaXe()).getTenXe();
                Object[] row = {
                    i++,
                    bh.getMaBh(),
                    tenKh,
                    tenXe,
                    bh.getNgayBaoHanh(),
                    bh.getNoidungBh()
                };
                model.addRow(row);                 
            } 
        }  
        catch (Exception e) { 
            JOptionPane.showMessageDialog(this, "lỗi truy vẫn dữ liệu"+e);
        }
    }//GEN-LAST:event_btnSapXepActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        if (cboTimKiemBaoHanh.getSelectedItem().equals("Tìm kiếm theo tên khách hàng")) {
            this.timKiemTheoTenKH(); 
        }else if (cboTimKiemBaoHanh.getSelectedItem().equals("Tìm kiếm theo mã bảo hành")) {
            this.timKiemTheoMaBH();
        }else{
            this.timKiemTheoTenXe();
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tblBaoHanhMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBaoHanhMousePressed
        if (evt.getX() == x & evt.getY() == y) {
            kt = 1;
        } else {
            x = evt.getX();
            y = evt.getY();
        }
        if (kt == 1) {
            this.update();
            kt = 0;
            x = 0;
            y = 0;
        }
    }//GEN-LAST:event_tblBaoHanhMousePressed
 int kt = 0;
    int x = 0;
    int y = 0;


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BaoHanh;
    private javax.swing.JButton btnChinhSua;
    private javax.swing.JButton btnSapXep;
    private javax.swing.JButton btnTaoMoi;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboTimKiemBaoHanh;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblBaoHanh;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
