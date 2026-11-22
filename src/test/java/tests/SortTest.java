package tests;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortTest extends TestBase {

    @Test
    public void testFiyatUcuzdanPahaliyaSiralama(){
        extentTest = extentReports.createTest("Fiyat Sıralama Testi","Ürünler ucuzdan pahalıya doğru sıralanabilmeli");

        extentTest.info("Kullanıcı sitenin ana sayfasına gider ve giriş yapar.");
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        LoginPage loginPage = new LoginPage();
        loginPage.performLogin("standard_user","secret_sauce");

        extentTest.info("Açılır menüden 'Price (low to high)' seçeneği seçilir.");
        InventoryPage inventoryPage = new InventoryPage();
        inventoryPage.selectSortOption("Price (low to high)");

        extentTest.info("Sayfadaki tüm ürün fiyatları okunup sayıya çevrilir.");
        List<Double> actualPrices = new ArrayList<>();

        for(WebElement priceElement : inventoryPage.productPrices) {
            //$ işareti fiyatin onunden siliniyor
            String priceText = priceElement.getText().replace("$","");
            //metni matematiksel ondalikli sayiya cevirip listeye ekliyoruz
            actualPrices.add(Double.parseDouble(priceText));
        }

        //siteden gelen listenin kopyasini olusturup javaya kucukten buyuge sıralatma
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        Collections.sort(expectedPrices);

        extentTest.info("Sitedeki fiyat sirasinin kucukten buyuge dogru oldugu dogrulanir.");
        Assert.assertEquals(actualPrices,expectedPrices);

        extentTest.pass("Ürünlerin ucuzdan pahalıya dogru siralandigi dogrulandi:" + actualPrices);

    }
}
