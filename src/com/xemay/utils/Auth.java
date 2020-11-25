package com.xemay.utils;

import com.xemay.model.NhanVien;

public class Auth {
    public static NhanVien user = null; //duy trì user đăng nhập vào hệ thống
    public static void clear(){ //Xóa bỏ nhân viên đã đăng nhập
        Auth.user = null;
    }
    public static boolean isLogin(){ //Kiểm tra đã đăng nhập hay chưa
        return Auth.user != null;
    }
}
