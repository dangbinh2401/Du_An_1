package com.xemay.utils;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class CheckLoi {
    public static boolean checkRong(JTextField txt,StringBuilder bd, String mess){
        boolean ok = true;
        if (txt.getText().equals("")) {
            bd.append(mess).equals("\n");
            txt.setBackground(Color.yellow);
            txt.requestFocus();
            ok = false;
        }else{
            txt.setBackground(Color.white);
        }
        return ok;
    }
    
    public static void checkRongPass(JPasswordField txt, StringBuilder bd, String mess){
        String pass = new String(txt.getPassword());
        if (pass.equals("")) {
            bd.append(mess).append("\n");
            txt.setBackground(Color.yellow);
            txt.requestFocus();
        }else{
            txt.setBackground(Color.white);
        }        
    }
    
    public static boolean checkTien(JTextField txt, StringBuilder bd){
        boolean ok = true;
        if (!checkRong(txt, bd,"Tiền chưa nhập\n")) {
            return false;
        }
        try {
            float tien = Float.parseFloat(txt.getText());
            if (tien < 0) {
                bd.append("Tiền phải lớn hơn 0\n");
                txt.setBackground(Color.yellow);
                txt.requestFocus();
                ok = false;
            }
        } catch (Exception e) {
            bd.append("Tiền phải là số không được ký tự khác\n");
            txt.setBackground(Color.yellow);
            txt.requestFocus();
            ok = false;
        }
        return ok;
    }
    
    public static boolean checkSo(JTextField txt, StringBuilder bd,String mess,String ten){
        boolean ok = true;
        if (!checkRong(txt, bd,mess)) {
            return false;
        }
        try {
            float so = Integer.parseInt(txt.getText());
            if (so < 0) {
                bd.append(ten+" phải lớn hơn 0\n");
                txt.setBackground(Color.yellow);
                txt.requestFocus();
                ok = false;
            }
        } catch (Exception e) {
            bd.append(ten +" không được ký tự khác.Phải là số\n");
            txt.setBackground(Color.yellow);
            txt.requestFocus();
            ok = false;
        }
        return ok;
    }
    
    public static boolean checkEmail(JTextField txt, StringBuilder bd) {
        boolean ok = true;
        //kiểm tra email đã nhập chưa
        if (!checkRong(txt, bd, "Email chưa nhập\n")) {
            return false;
        }
        //khai báo biến email
        String email = txt.getText();
        Pattern pattern = Pattern.compile("\\w+@\\w+\\.+\\w+");//biểu thức chính quy theo khôn mẫu
        Matcher matcher = pattern.matcher(txt.getText());
        //kiểm tra email nhập vào có khớp với định dạng không
        if (!matcher.find()) {
            bd.append("Email không đúng định dạng(vd: abc@gmail.com)\n");
            txt.setBackground(Color.yellow);
            txt.requestFocus();
            ok = false;
        }
        if (ok) {
            txt.setBackground(Color.white);
        }
        return ok;
    }
    
    public static boolean checkSoDienThoai(JTextField txt, StringBuilder bd) {
        boolean ok = true;
        if (!checkRong(txt, bd, "Số điện thoại chưa nhập\n")) {
        return false;
        }
        String soDienThoai = txt.getText();
        Pattern pattern = Pattern.compile("^0\\d{9}$");//biểu thức chính quy theo khôn mẫu
        Matcher matcher = pattern.matcher(txt.getText());
        if (!matcher.find()) {
            bd.append("Số điện thoại không đúng định dạng.Số điện thoại phải 10 số(vd: 0978785678)\n");
            txt.setBackground(Color.yellow);
            txt.requestFocus();
            ok = false;
        }
        if (ok) {
            txt.setBackground(Color.white);
        }
        return ok;
    } 
    
    public static boolean checkNam(JTextField txt, StringBuilder bd){
        boolean ok = true;
        if (!checkRong(txt, bd, "Năm sản xuất chưa nhập\n")) {
        return false;
        }
        String namSX = txt.getText();
        Pattern pattern = Pattern.compile("^\\d{4}$");//biểu thức chính quy theo khôn mẫu
        Matcher matcher = pattern.matcher(namSX);
        if (!matcher.find()) {
            bd.append("Năm sản xuất không đúng định dạng. Năm sản xuất có 4 số (vd: 1999)\n");
            txt.setBackground(Color.yellow);
            txt.requestFocus();
            ok = false;
        }
        if (ok) {
            txt.setBackground(Color.white);
        }
        return ok;
    }
    
    public static boolean checkNgaySinh(JTextField txt, StringBuilder bd){
        boolean ok = true;
        if (!checkRong(txt, bd,"Ngày chưa nhập\n")) {
            return false;
        }
        SimpleDateFormat date = new SimpleDateFormat();
        date.applyPattern("yyyy-MM-dd");
        try {
            Date dob = date.parse(txt.getText());
            txt.setBackground(Color.white);
        } catch (Exception e) {
            bd.append("Ngày nhập không đúng định dạng (vd: 1999-01-01)\n");
            txt.setBackground(Color.yellow);
        }
        return ok;
    }
    
    public static boolean checkNgayNhap(JTextField txt, StringBuilder bd){
        boolean ok = true;
        if (!checkRong(txt, bd,"Ngày chưa nhập\n")) {
            return false;
        }
        SimpleDateFormat date = new SimpleDateFormat();
        date.applyPattern("yyyy-MM-dd");
        try {
            Date dob = date.parse(txt.getText());
            txt.setBackground(Color.white);
        } catch (Exception e) {
            bd.append("Ngày nhập không đúng định dạng (vd: 1999-01-01)\n");
            txt.setBackground(Color.yellow);
        }
        return ok;
    }
}
