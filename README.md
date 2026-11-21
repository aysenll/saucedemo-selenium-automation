# E-Ticaret Web UI Test Otomasyon Framework'ü

Bu proje, [SauceDemo](https://www.saucedemo.com) e-ticaret sitesi üzerinde **Page Object Model (POM)** tasarım deseni kullanılarak geliştirilmiş Java & Selenium test otomasyon altyapısıdır.

## Kullanılan Teknolojiler ve Araçlar
* **Programlama Dili:** Java 21
* **Otomasyon Aracı:** Selenium WebDriver 4
* **Test Çerçevesi:** TestNG
* **Bağımlılık Yönetimi:** Maven
* **Raporlama:** Extent Reports (HTML Raporu)

## Mimari Özellikler
* **Singleton Pattern:** `Driver` sınıfı ile test boyunca tek bir WebDriver oturumu yönetilir.
* **Merkezi Konfigürasyon:** URL ve tarayıcı ayarları `configuration.properties` dosyasından `ConfigReader` ile dinamik olarak okunur (Cross-Browser desteği).
* **Kalıtım (Inheritance):** `TestBase` sınıfı ile tarayıcı kurulumu, kapatma ve raporlama yaşam döngüsü (`@BeforeTest`, `@BeforeMethod`, `@AfterMethod`, `@AfterTest`) tek merkezden yönetilir.
* **Page Object Model (POM):** Web elementleri ve sayfa aksiyonları `pages` paketinde, test doğrulamaları `tests` paketinde ayrı tutulur.

## Test Senaryoları
* **Pozitif Login Testi:** Geçerli kullanıcı bilgileri ile sisteme başarılı giriş doğrulaması.
* **Negatif Login Testi:** Hatalı şifre ile giriş denemesinde uyarı mesajının görüntülendiğinin doğrulaması.

## Projeyi Çalıştırma
1. Projeyi bilgisayarınıza klonlayın.
2. Maven bağımlılıklarının yüklenmesini bekleyin.
3. Proje ana dizinindeki `testng.xml` dosyasına sağ tıklayıp **Run** seçeneği ile tüm test paketini çalıştırın.
4. Test bitiminde `test-output/Rapor.html` dosyasını tarayıcıda açarak görsel test raporunu inceleyin.