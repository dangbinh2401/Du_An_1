/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.helper;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class email {
    public  boolean SendEmail(String Email,String MaXacNhan){
            boolean check=true;
            try {
            Properties p = new Properties();
            p.put("mail.smtp.auth", "true");
            p.put("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.put("mail.smtp.port", "587");
            String accountName = "binhdtpd03821@fpt.edu.vn";
            String accountPass = "thanhbinh240";
            Session s = Session.getInstance(p,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(accountName, accountPass);
                        }
                    });
            String from = "binhdtpd03821@fpt.edu.vn";
          //  String to = "hoanguyen11111995@gmail.com";
            String Subject = "Đặt lại mật khẩu Quản Lý Xe Máy";
            String body = "mã xác nhận đặt lại mật khẩu của bạn là : " + MaXacNhan +"   vui lòng không cung cấp mã này với bất kì ai khác!";
            Message msg = new MimeMessage(s);
            msg.setFrom(new InternetAddress(accountName));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(Email));
            msg.setSubject(Subject);
            msg.setText(body);
            Transport.send(msg);
          //  JOptionPane.showMessageDialog(null, "Đã gửi mã xác nhận về email", "Message", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            JOptionPane.showMessageDialog(null, "Đã gửi mã xác nhận về email");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gửi mã không thành công");
            check=false;
        }
            return check;
    }
}
