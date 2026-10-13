package com.uzeyircavusoglu;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;

public class ResumeGenerator {

    public void generateResumePdf(String destPath, String imagePath) {
        try {
            // PDF dosyasının oluşturulması
            PdfWriter writer = new PdfWriter(destPath);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Türkçe karakter desteği için font ayarı (ÇÖZÜM BURADA)
            PdfFont turkishFont = PdfFontFactory.createFont(StandardFonts.HELVETICA, "Cp1254");
            document.setFont(turkishFont);

            // Fotoğraf Ekleme
            try {
                ImageData imageData = ImageDataFactory.create(imagePath);
                Image profilePic = new Image(imageData);
                // Fotoğraf boyutları 150x150 olarak büyütüldü
                profilePic.setWidth(150);
                profilePic.setHeight(150);
                profilePic.setHorizontalAlignment(com.itextpdf.layout.properties.HorizontalAlignment.CENTER);
                document.add(profilePic);
            } catch (Exception e) {
                System.out.println("Fotoğraf bulunamadı, fotoğrafsız devam ediliyor.");
            }

            // Kişisel Bilgiler
            document.add(new Paragraph("Üzeyir Çavuşoğlu")
                    .setBold().setFontSize(20).setTextAlignment(TextAlignment.CENTER));
            document.add(new Paragraph("Yazılım Mühendisliği Öğrencisi | Oyun Geliştirici & Siber Güvenlik Meraklısı")
                    .setTextAlignment(TextAlignment.CENTER));
            document.add(new Paragraph("E-posta: uzeyir@example.com | Tel: +90 555 123 4567\n\n"));

            // Eğitim Bilgileri
            document.add(new Paragraph("EĞİTİM").setBold().setFontSize(14));
            document.add(new Paragraph("Kırklareli Üniversitesi - Mühendislik Fakültesi\nYazılım Mühendisliği, 2. Sınıf (2025 - Devam Ediyor)\n\n"));

            // İş Deneyimleri
            document.add(new Paragraph("İŞ DENEYİMLERİ").setBold().setFontSize(14));

            document.add(new Paragraph("1. GamePlay Studios - Junior Oyun Geliştirici (Mayıs 2026 - Eylül 2026)")
                    .setBold());
            document.add(new Paragraph("Unity ve C# kullanarak mobil platformlar için 2D platform oyun mekaniklerinin geliştirilmesi.\n"));

            document.add(new Paragraph("2. CyberGuard Tech - Sızma Testi Stajyeri (Ocak 2026 - Nisan 2026)")
                    .setBold());
            document.add(new Paragraph("Web uygulamalarında zafiyet taramaları (OWASP Top 10) yapılması ve raporlanması.\n"));

            document.add(new Paragraph("3. Freelance - Web Geliştirici (2025 - 2026)")
                    .setBold());
            document.add(new Paragraph("HTML, CSS ve JavaScript kullanarak kurumsal web siteleri tasarımı.\n\n"));

            // Yetenekler
            document.add(new Paragraph("YETENEKLER").setBold().setFontSize(14));
            document.add(new Paragraph("- Programlama Dilleri: Java, C, C#\n- Teknolojiler: HTML, CSS, Git, Linux (Ubuntu), VirtualBox\n- İlgi Alanları: Tersine Mühendislik, Algoritma Geliştirme"));

            // Belgeyi kapatma ve kaydetme
            document.close();
            System.out.println("Özgeçmiş başarıyla oluşturuldu: " + destPath);

        } catch (Exception e) {
            System.err.println("Dosya oluşturulurken hata meydana geldi: " + e.getMessage());
        }
    }
}