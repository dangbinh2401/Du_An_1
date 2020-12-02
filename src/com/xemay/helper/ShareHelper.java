/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.helper;

import com.xemay.model.TaiKhoan;

/**
 *
 * @author ADMIN
 */
public class ShareHelper {
    public static String NV = "NV";
    public static String HDX = "HDX";
    public static String HDN = "HDX";
    public static String XE = "XE";
    public static TaiKhoan TaiKhoan = null;
    
    
    public String getMa(String Ma,String X){
               String rs = Ma+X;
       while (rs.length()!=10){
           if (rs.length()<10){
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
