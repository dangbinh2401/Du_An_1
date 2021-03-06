/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.helper;

import com.xemay.model.TaiKhoan;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;


/**
 *
 * @author ADMIN
 */
public class ShareHelper {
        public static final Image APP_ICON;

    static {
        String file = "/com/xemay/icon/hbh.png";
        APP_ICON = new ImageIcon(ShareHelper.class.getResource(file)).getImage();
    }

    public static boolean saveLogo(File file) {
        File dir = new File("logos");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File newFile = new File(dir, file.getName());
        try {
            Path source = Paths.get(file.getAbsolutePath());
            Path destination = Paths.get(newFile.getAbsolutePath());
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public static TaiKhoan TaiKhoan = null;
    
    public static String getMaXe(String Ma,String s){
         int  i = 0;
         boolean kt=false;
         while (kt!=true){
             try {
                 i =Integer.parseInt(s);
                 i++;
                 kt=true;
             } catch (Exception e) {
                 s=s.substring(1, s.length());
             }
         }
         return getMa(Ma,String.valueOf(i));
    }
//    public static void main(String[] args) {
//        List<Xe> dataXe = xe.selectTong();
//        List<HoaDonNhap> dataHDN = hdn.selectAll();
//        System.out.println(ShareHelper.getMaXe(XE,dataXe.get(dataXe.size()-1).getMaXe()));
//        
//        System.out.println(ShareHelper.getMaXe(HDN,dataHDN.get(dataHDN.size()-1).getMaHDN()));
//    }
    public static String getMa(String Ma,String X){
               String rs = Ma+X;
       while (rs.length()!=7){
           if (rs.length()<7){
               X = "0"+X;
           }else{
               X = X.substring(1, X.length());
           }
           rs = Ma+X;
       }
       return rs;
    }
    
     /**
     * * đăng xuất
     */
    public static void logoff(){
        ShareHelper.TaiKhoan = null;
    }
    
    /**
     * * Kiểm tra xem đăng nhập hay chưa * @return đăng nhập hay chưa
     */
    public static boolean authenticated() {
        return ShareHelper.TaiKhoan != null;
    }
}
