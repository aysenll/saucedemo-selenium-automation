# E-Ticaret Web UI Test Otomasyon Framework'ü

Bu proje, [SauceDemo](https://www.saucedemo.com) e-ticaret sitesi üzerinde **Page Object Model (POM)** tasarım deseni kullanılarak geliştirilmiş Java & Selenium test otomasyon altyapısıdır.

## Kullanılan Teknolojiler ve Araçlar
* **Programlama Dili:** Java 21
* **Otomasyon Aracı:** Selenium WebDriver 4
* **Test Çerçevesi:** TestNG
* **Bağımlılık Yönetimi:** Maven
* **Raporlama:** Extent Reports (Otomatik Base64 Ekran Görüntülü HTML Raporu)

## Mimari Özellikler
* **Page Object Model (POM):** Sayfa elementleri ve aksiyonları `pages` paketinde (`LoginPage`, `InventoryPage`, `CartPage`, `CheckoutPage`), test doğrulamaları `tests` paketinde ayrı tutulur.
* **Singleton Pattern & ChromeOptions:** `Driver` sınıfı ile tek WebDriver oturumu yönetilir; tarayıcı `--start-maximized` ve `--incognito` parametreleriyle başlatılır.
* **Merkezi Konfigürasyon:** URL ve tarayıcı ayarları `configuration.properties` dosyasından `ConfigReader` ile dinamik olarak okunur (Cross-Browser desteği).
* **Senkronizasyon (Wait Stratejisi):** Genel element yüklemeleri için `Implicit Wait`, sayfa geçişleri ve dinamik butonlar için `Explicit Wait (WebDriverWait)` kullanılır.
* **Hata Anında Otomatik Ekran Görüntüsü:** `TestBase` içindeki `@AfterMethod` (`ITestResult`) kontrolü sayesinde başarısız olan testlerde `TakesScreenshot` ile Base64 ekran görüntüsü alınıp doğrudan HTML raporuna gömülür.

## Test Senaryoları
* **Pozitif Login Testi:** Geçerli kullanıcı bilgileri ile sisteme başarılı giriş doğrulaması.
* **Negatif Login Testi:** Hatalı şifre ile giriş denemesinde uyarı mesajının görüntülendiğinin doğrulaması.
* **Sepete Ürün Ekleme Testi:** Ürünün sepete eklendiğinin ve sepet sayacının güncellendiğinin doğrulaması.
* **Fiyat Sıralama Testi:** Açılır menü (`Select`) üzerinden ürünlerin ucuzdan pahalıya sıralandığının liste karşılaştırmasıyla doğrulaması.
* **Uçtan Uca (E2E) Satın Alma Testi:** Giriş, sepete ekleme, sepet sayfası, müşteri bilgi formu ve sipariş onayı adımlarının kesintisiz doğrulanması.

## Projeyi Çalıştırma
1. Projeyi bilgisayarınıza klonlayın.
2. Maven bağımlılıklarının yüklenmesini bekleyin.
3. Proje ana dizinindeki `testng.xml` dosyasına sağ tıklayıp **Run** seçeneği ile tüm test paketini çalıştırın.
4. Test bitiminde `test-output/Rapor.html` dosyasını tarayıcıda açarak görsel test raporunu inceleyin.