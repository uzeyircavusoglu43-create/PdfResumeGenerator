# PdfResumeGenerator
Java ve iText 7 kütüphanesi kullanılarak geliştirilmiş, nesne yönelimli PDF özgeçmiş oluşturucu
# Java PDF Özgeçmiş Oluşturucu

Bu proje, Java kullanılarak nesne yönelimli programlama (OOP) prensiplerine uygun şekilde, PDF formatında özgeçmiş (CV) oluşturan arayüzsüz bir konsol uygulamasıdır. (Üniversite Ödevi)

## Karşılanan İsterler
- PDF oluşturma işlemleri `main` metodundan bağımsız, ayrı bir `ResumeGenerator` sınıfında yapılmıştır.
- Herhangi bir grafiksel arayüz (GUI) kullanılmamıştır.
- Özgeçmişe kod üzerinden başarıyla profil fotoğrafı (`profil.jpg`) eklenmektedir.
- 3 adet kurgusal iş deneyimi içermektedir.

## Kullanılan Teknolojiler ve Kütüphaneler
- **Java 11+**
- **Maven:** Proje kütüphanelerini yönetmek için.
- **iText 7 Core (7.2.5):** Java ekosisteminde PDF belgelerini programatik olarak oluşturmak, metinleri hizalamak ve font/görsel ayarlamalarını yapmak için en geniş ve stabil kütüphane olduğu için tercih edilmiştir.

## Kullanılan Bileşenler, Nesneler ve Görevleri
Projede Nesne Yönelimli Programlama mantığıyla şu sınıflar/nesneler kullanılmıştır:

1. **`ResumeGenerator` Sınıfı ve Nesnesi:** PDF oluşturma görevini üstlenir. Kodun modüler olması (Single Responsibility prensibi) amacıyla `main` metodundan ayrılmıştır. `Main` içinde bu sınıftan bir nesne türetilerek metodu çağrılır.
2. **`PdfWriter` Nesnesi:** Bellekteki PDF verilerini diske fiziksel bir dosya (`.pdf`) olarak yazmak (I/O işlemi) için kullanılmıştır.
3. **`PdfDocument` Nesnesi:** PDF dosyasının temel çerçevesini ve sayfalarını temsil eder.
4. **`Document` Nesnesi:** Belgenin içine eklenecek olan paragrafların (`Paragraph`), metinlerin ve resimlerin yerleşimini (layout) yönetmek için kullanılmıştır.
5. **`Image` ve `ImageData` Nesneleri:** Proje dizinindeki resmi (`profil.jpg`) okuyup PDF içerisine bir görsel eleman olarak tanımlamak için kullanılmıştır.
6. **`PdfFont` Nesnesi:** Türkçe karakterlerin (ı, ş, ğ vb.) PDF'te boşluksuz ve hatasız görünmesi için `Cp1254` (Türkçe) formatında font tanımlamak amacıyla kullanılmıştır.
