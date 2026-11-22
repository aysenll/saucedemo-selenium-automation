package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

import java.util.List;

public class InventoryPage {

    public InventoryPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    //sırt cantası urununun add to cart butonu
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addToCartBackpackButton;

    //sepet ikonu ustundeki cıkan sayi
    @FindBy(className = "shopping_cart_badge")
    public WebElement cartBadge;

    //sepet sayfasina gitmek icin sepet ikonu
    @FindBy(className = "shopping_cart_link")
    public WebElement cartLink;

    //urun siralama dropdown
    @FindBy(className = "product_sort_container")
    public WebElement sortDropdown;

    //sayfadaki tum urunlerin fiyat etiketleri(liste olarak)
    @FindBy(className = "inventory_item_price")
    public List<WebElement> productPrices;

    public void addBackpackToCart(){
        addToCartBackpackButton.click();
    }
    public String getCartBadgeCount(){
        return cartBadge.getText();
    }

    //sepet ikonuna tiklaninca sepet sayfasina gider
    public void gotoCart(){
        cartLink.click();
    }

    public void selectSortOption(String optionText){
        Select select = new Select(sortDropdown);
        select.selectByVisibleText(optionText);
    }

    //urunu sepete ekleyen metot
    // public void addBackpackToCart(){
    //    addToCartBackpackButton.click();
    //}

    //sepetteki urun sayisini string oalrak okuyan metot
    //public String getCartBadgeCount(){
    //    return cartBadge.getText();
    //}


}
