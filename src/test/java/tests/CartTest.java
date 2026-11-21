package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

public class CartTest extends TestBase {

    @Test
    public void testSepeteUrunEkleme(){
        extentTest = extentReports.createTest("Sepete Ürün Ekleme Testi", "Kullanıcı giriş yapıp bir ürünü sepete ekleyebilmeli");

        extentTest.info("Kullanıcı sitenin ana sayfasına gider.");
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        extentTest.info("Geçerli bilgilerle sisteme giriş yapılır.");
        LoginPage loginPage = new LoginPage();
        loginPage.performLogin("standard_user","secret_sauce");

        extentTest.info("'Sauce Labs Backpack' ürünü sepete eklenir.");
        InventoryPage inventoryPage = new InventoryPage();
        inventoryPage.addBackpackToCart();

        //gercek degerle beklenen degeri karsilastirma
        extentTest.info("Sepet ikonundaki ürün sayısının 1 olduğu doğrulanır.");
        String actualCount = inventoryPage.getCartBadgeCount();
        Assert.assertEquals(actualCount,"1");

        extentTest.pass("Ürün başarıyla sepete eklendi ve sepet sayacı 1 olarak doğrulandı.");

    }
}
