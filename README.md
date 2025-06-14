Tabii Buğra, işte bu Java projesi için uygun ve sade bir `README.md` dosyası örneği:

---

## 🎓 Ders Seçim Sistemi Simülasyonu (JAVACS)

Bu proje, Java programlama dili kullanılarak geliştirilen basit bir **ders seçim sistemi simülasyonudur**. Proje, `Öğrenci` ve `Yönetici (Admin)` rollerini desteklemektedir ve kullanıcıların rolüne göre farklı işlemleri gerçekleştirmesine olanak tanır.

---

### 📁 Proje Yapısı

* `Course.java`: Ders bilgilerini temsil eder (`kod`, `isim`, `kredi`, `açıklık durumu`).
* `User.java`: Soyut kullanıcı sınıfı.
* `Student.java`: Öğrenci rolü, `User` sınıfından türemiştir.
* `Admin.java`: Yönetici rolü, `User` sınıfından türemiştir.
* `LessonCart.java`: Öğrencinin ders sepetini temsil eder. Sadece `Course` türünden dersleri içerir.
* `CourseManager.java`: Derslerin listelenmesi, eklenmesi ve silinmesini yöneten yardımcı sınıf.
* `Main.java`: Programın çalıştığı ana sınıf.
* `courses.txt`: Başlangıçta yüklenecek olan ders listesini içeren metin dosyası (opsiyonel, açıklama aşağıda).

---

### 🔧 Özellikler

#### Öğrenci:

* Tüm dersleri görüntüleyebilir.
* Ders sepetine ders ekleyebilir (sadece açık olanlar ve toplam 30 krediyi aşmadan).
* Ders sepetinden ders çıkarabilir.
* Ders sepetini görüntüleyebilir.
* Ders sepetini **bir kez** kaydedebilir (sonrasında değişiklik yapılamaz).

#### Yönetici:

* Yeni ders ekleyebilir (kod, isim, kredi, açık/kapalı bilgileriyle).
* Mevcut dersi silebilir.
* Tüm dersleri listeleyebilir.

---

### 📝 Önemli Kurallar

* Aynı ders birden fazla kez eklenemez.
* Kapalı dersler seçilemez.
* 30 krediyi geçen seçimler engellenir.
* Sepet kaydedildikten sonra ekleme/silme işlemi yapılamaz.
* Yönetici var olan bir dersi tekrar ekleyemez.
* Silinmek istenen ders mevcut değilse hata verilir.
* Geçersiz seçimlerde kullanıcı bilgilendirilir.

---

### 📥 `courses.txt` Desteği (Opsiyonel)

Sistem gelecekte `courses.txt` adında bir dosyadan dersleri okuyarak başlatılabilir. Bu özellik henüz eklenmemiştir ancak planlanmaktadır.

📌 **Beklenen format örneği:**

```
CSE101,Programlamaya Giriş,6,true
MAT102,Lineer Cebir,5,true
FIZ103,Fizik I,5,false
```

> Her satır: `DersKodu,DersAdı,Kredi,AçıkMı`

---

### ▶️ Çalıştırma

1. Tüm `.java` dosyalarını bir dizine yerleştirin.
2. Konsoldan derleyin:

```bash
javac *.java
```

3. Programı çalıştırın:

```bash
java Main
```

---

### 👥 Geliştiriciler

* **Buğra Berk İnci**

---
