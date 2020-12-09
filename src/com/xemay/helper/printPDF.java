/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xemay.helper;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.xemay.model.ChiTietHDN;
import com.xemay.model.ChiTietHdx;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class printPDF {

    public printPDF() {
    }
        
        public void print(String MaHD,String TenCuaHang,String DiaChi, String SDT,String TenKH,String sdtKH,String NgayLap,List<ChiTietHdx> list,String tong) throws IOException, DocumentException{
         com.itextpdf.text.Document document = new com.itextpdf.text.Document(PageSize.A4, 50, 50, 50, 50);

		try {
                        Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 22,Font.BOLD);
                         Font catFontt = new Font();
                        catFont.getFamilyname();
                        //Vnariali.ttf
                        Font f = new Font(BaseFont.createFont("src/com/xemay/help/times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
                           // f.setColor(Color.BLUE);
                            f.setSize(22);
                            f.setStyle(Font.NORMAL);
			// Tạo đối tượng PdfWriter
			PdfWriter.getInstance(document, new FileOutputStream("src/com/xemay/help/"+MaHD+".pdf"));

			// Mở file để thực hiện ghi
			document.open();
                        f.setSize(24);
                        Paragraph tenHD = new Paragraph("HÓA ĐƠN BÁN HÀNG",f);
                        tenHD.setAlignment(Element.ALIGN_CENTER);
                        //String MaHD="HD00001";
                        f.setSize(22);
                        Paragraph mahd = new Paragraph("Mã hóa đơn: "+MaHD,f); 
                        String TenCongTy="ĐẠI LÝ XE MÁY HBH";
                        //String ChiNhanh="Nguyễn lương bằng";
                        //String DiaChi="128 nguyễn lương bằng";
                        //String SDT="0961143378";
                        //String TenKH="Đặng Thanh Bình";
                        //String sdtKH="099999999";
                        //String NgayLap="2020-12-4";
                        f.setSize(14);
			Paragraph tenCT = new Paragraph(TenCongTy,f);
                        mahd.setAlignment(Element.ALIGN_CENTER);
                        tenCT.setAlignment(Element.ALIGN_CENTER);
                        addEmptyLine(mahd, 1);

                        Paragraph CN = new Paragraph("Chi Nhánh :"+TenCuaHang,f);
                        Paragraph DC = new Paragraph("Địa Chỉ :"+DiaChi,f);
                        Paragraph sdt = new Paragraph("Số Điện thoại CH: "+SDT,f);
                        Paragraph ten = new Paragraph("Họ Tên :"+TenKH,f);
                        Paragraph SDTKH = new Paragraph("Số điện thoại :"+sdtKH,f);
                        Paragraph ngay = new Paragraph("Ngày lập : "+NgayLap,f);
                        document.add(tenHD);
                        f.setSize(14);
                        document.add(tenCT);
                        document.add(mahd);
                        document.add(CN);
                        document.add(DC);
                        document.add(sdt);
                        document.add(ten);
                        document.add(SDTKH);
                        document.add(ngay);
                        PdfPTable t = new PdfPTable(6);
                        t.setSpacingBefore(25);
                        t.setSpacingAfter(25);
                        t.setHorizontalAlignment(Element.ALIGN_CENTER);
                        PdfPCell c1 = new PdfPCell(new Phrase("STT",f));
                        t.addCell(c1);
                        PdfPCell c2 = new PdfPCell(new Phrase("Mã xe",f));
                        t.addCell(c2);
                        PdfPCell c3 = new PdfPCell(new Phrase("Tên xe",f));
                        t.addCell(c3);
                        PdfPCell c4 = new PdfPCell(new Phrase("Giá bán",f));
                        t.addCell(c4);
                        PdfPCell c5 = new PdfPCell(new Phrase("Số lượng",f));
                        t.addCell(c5);
                        PdfPCell c6 = new PdfPCell(new Phrase("Thành tiền",f));
                        t.addCell(c6);
                        int i=1;
                        NumberFormat formatter = new DecimalFormat("#,###,###");
                        for (ChiTietHdx hdx : list) {
                            t.addCell(String.valueOf(i));
                            t.addCell(hdx.getMaXe());
                            t.addCell(hdx.getTenXe());
                            t.addCell(formatter.format(hdx.getGiaTienBan()));
                            t.addCell(String.valueOf(hdx.getSoLuong()));
                            t.addCell(formatter.format(hdx.getGiaTienBan()*hdx.getSoLuong()));
                            i++;
                        }
                        document.add(t);
                        Paragraph tt = new Paragraph("                                                                                   Tổng tiền: "+tong,f);
                        addEmptyLine(tt, 2);
                        document.add(tt);
                        document.add(new Paragraph("           Người mua hàng                                                           Nhân viên bán",f));
                        document.add(new Paragraph("                   ký tên                                                                            ký tên",f));
                        //---------
			document.close();
			System.out.println("Write file succes!");
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
    }
    public void printHDN(String MaHD,String TenCuaHang,String DiaChi, String SDT,String TenKH,String sdtKH,String NgayLap,List<ChiTietHDN> list,String tong) throws IOException, DocumentException{
         com.itextpdf.text.Document document = new com.itextpdf.text.Document(PageSize.A4, 50, 50, 50, 50);

		try {
                        Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 22,Font.BOLD);
                         Font catFontt = new Font();
                        catFont.getFamilyname();
                        //Vnariali.ttf
                        Font f = new Font(BaseFont.createFont("src/com/xemay/help/times.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED));
                           // f.setColor(Color.BLUE);
                            f.setSize(22);
                            f.setStyle(Font.NORMAL);
			// Tạo đối tượng PdfWriter
			PdfWriter.getInstance(document, new FileOutputStream("src/com/xemay/help/"+MaHD+".pdf"));

			// Mở file để thực hiện ghi
			document.open();
                        f.setSize(24);
                        Paragraph tenHD = new Paragraph("HÓA ĐƠN NHẬP HÀNG",f);
                        tenHD.setAlignment(Element.ALIGN_CENTER);

                        f.setSize(22);
                        Paragraph mahd = new Paragraph("Mã hóa đơn: "+MaHD,f); 
                        String TenCongTy="ĐẠI LÝ XE MÁY HBH";

                        f.setSize(14);
			Paragraph tenCT = new Paragraph(TenCongTy,f);
                        mahd.setAlignment(Element.ALIGN_CENTER);
                        tenCT.setAlignment(Element.ALIGN_CENTER);
                        addEmptyLine(mahd, 1);

                        Paragraph CN = new Paragraph("Chi Nhánh :"+TenCuaHang,f);
                        Paragraph DC = new Paragraph("Địa Chỉ :"+DiaChi,f);
                        Paragraph sdt = new Paragraph("Số Điện thoại nhà cung cấp: "+SDT,f);
                        Paragraph ten = new Paragraph("Tên nhà cung cấp :"+TenKH,f);
                        Paragraph SDTKH = new Paragraph("Số điện thoại :"+sdtKH,f);
                        Paragraph ngay = new Paragraph("Ngày nhập : "+NgayLap,f);
                        document.add(tenHD);
                        f.setSize(14);
                        document.add(tenCT);
                        document.add(mahd);
                        document.add(CN);
                        document.add(DC);
                        document.add(sdt);
                        document.add(ten);
                        document.add(SDTKH);
                        document.add(ngay);
                        PdfPTable t = new PdfPTable(6);
                        t.setSpacingBefore(25);
                        t.setSpacingAfter(25);
                        t.setHorizontalAlignment(Element.ALIGN_CENTER);
                        PdfPCell c1 = new PdfPCell(new Phrase("STT",f));
                        t.addCell(c1);
                        PdfPCell c2 = new PdfPCell(new Phrase("Mã xe",f));
                        t.addCell(c2);
                        PdfPCell c3 = new PdfPCell(new Phrase("Tên xe",f));
                        t.addCell(c3);
                        PdfPCell c4 = new PdfPCell(new Phrase("Giá bán",f));
                        t.addCell(c4);
                        PdfPCell c5 = new PdfPCell(new Phrase("Số lượng",f));
                        t.addCell(c5);
                        PdfPCell c6 = new PdfPCell(new Phrase("Thành tiền",f));
                        t.addCell(c6);
                        int i=1;
                        NumberFormat formatter = new DecimalFormat("#,###,###");
                        for (ChiTietHDN hdx : list) {
                            t.addCell(String.valueOf(i));
                            t.addCell(hdx.getMaXe());
                            t.addCell(hdx.getTenXe());
                            t.addCell(formatter.format(hdx.getGiaTienNhap()));
                            t.addCell(String.valueOf(hdx.getSoLuong()));
                            t.addCell(formatter.format(hdx.getGiaTienNhap()*hdx.getSoLuong()));
                            i++;
                        }
                        document.add(t);
                        Paragraph tt = new Paragraph("                                                                                   Tổng tiền: "+tong,f);
                        addEmptyLine(tt, 2);
                        document.add(tt);
                        document.add(new Paragraph("           Nhà cung cấp                                                           Nhân viên nhập",f));
                        document.add(new Paragraph("                ký tên                                                                            ký tên",f));
                        //---------
			document.close();
			System.out.println("Write file succes!");
		} catch (FileNotFoundException | DocumentException e) {
			e.printStackTrace();
		}
    }
     private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
