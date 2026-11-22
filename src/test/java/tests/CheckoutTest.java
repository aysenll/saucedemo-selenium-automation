package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class CheckoutTest extends TestBase {

    @Test
    public void testUctanUcaSatinAlma() {
        extentTest = extentReports.createTest("Uçtan Uca Satın Alma Testi", "Kullanıcı giriş yapıp ürün seçerek siparişi tamamlayabilmeli");

        extentTest.info("Kullanıcı sitenin anasayfasına gider ve giriş yapar.");
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        LoginPage loginPage = new LoginPage();
        loginPage.performLogin("standard_user","secret_sauce");

        extentTest.info("Ürün sepete eklenir ve sepet sayfasına gidilir.");
        InventoryPage inventoryPage = new InventoryPage();
        inventoryPage.addBackpackToCart();
        inventoryPage.gotoCart();

        extentTest.info("Sepet sayfasında 'Checkout' butonuna tıklanır.");
        CartPage cartPage = new CartPage();
        cartPage.clickCheckout();

        extentTest.info("Müşteri adres bilgileri doldurulur ve sipariş onaylanır.");
        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.fillCustomerInfo("Songül","Bahar","36500");
        checkoutPage.clickFinish();

        extentTest.info("Siparişin başarıyla tamamlandığı ekrandaki onay mesajıyla doğrulanır.");
        String actualMessage = checkoutPage.getCompleteMessage();
        Assert.assertEquals(actualMessage,"Thank you for your order!");

        extentTest.pass("Sipariş uçtan uca başarıyla tamamlandı:" + actualMessage);
    }
}
