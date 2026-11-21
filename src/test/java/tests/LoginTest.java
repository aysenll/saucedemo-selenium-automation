package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class LoginTest extends TestBase {

    @Test
    public void testBasariliGiris(){
        //raporda bu test için yeni bir sayfa olusturuyoruz
        extentTest=extentReports.createTest("Başarılı Giriş Testi","Geçerli bilgilerle sisteme giriş yapılabilmeli");

        extentTest.info("Kullanıcı sitenin anasayfasına gider.");
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        LoginPage loginPage = new LoginPage();

        extentTest.info("Geçerli kullanıcı adı ve şifre ile giriş yapılır.");
        loginPage.performLogin("standard_user","secret_sauce");

        extentTest.info("URL'in 'inventory' kelimesi içerdiği doğrulanır.");
        String mevcutUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(mevcutUrl.contains("inventory"));

        //eğer üstteki assert komutu hata vermezse kod buraya ulaşır ve raporu passed yaparız
        extentTest.pass("Başarılı giriş yapıldığı ekrandaki URL üzerinden doğrulandı.");
    }
    @Test
    public void testHataliSifreGiris(){
        extentTest=extentReports.createTest("Hatalı Şifre Testi","Geçersiz şifre ile giriş yapılamamalı ve hata mesajı alınmalı");

        extentTest.info("Kullanıcı sitenin anasayfasına gider.");
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        LoginPage loginPage=new LoginPage();

        //dogru kullanici ama yanlis sifre ile giris yapmayi deniyor
        extentTest.info("Doğru kullanıcı adı ve yanlış şifre ile giriş denenir.");
        loginPage.performLogin("standard_user","yanlis_sifre_123");

        //dogrulama
        extentTest.info("Hata mesajının ekranda göründüğü doğrulanır.");
        Assert.assertTrue(loginPage.errorMesage.isDisplayed());

        extentTest.pass("Hata mesajının başarıyla görüntülendiği doğrulandı.");
    }
}
