/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.helper;

import com.xemay.dao.HoaDonNhapDAO;
import com.xemay.dao.XeDAO;
import com.xemay.model.HoaDonNhap;
import com.xemay.model.TaiKhoan;
import com.xemay.model.Xe;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author ADMIN
 */
public class ShareHelper {

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
