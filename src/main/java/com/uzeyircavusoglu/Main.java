package com.uzeyircavusoglu;

public class Main {
    public static void main(String[] args) {
        System.out.println("PDF Özgeçmiş Oluşturucu Başlatılıyor...");

        // Ayrı sınıftaki PDF oluşturucudan nesne türetiliyor
        ResumeGenerator generator = new ResumeGenerator();

        // Çıktı dosyasının adı ve fotoğrafın adı
        String pdfDest = "Uzeyir_Cavusoglu_CV.pdf";
        String photoPath = "";

        // PDF oluşturma metodu çalıştırılıyor
        generator.generateResumePdf(pdfDest, photoPath);
    }
}