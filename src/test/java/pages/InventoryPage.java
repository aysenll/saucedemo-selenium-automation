package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

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

    //urunu sepete ekleyen metot
    public void addBackpackToCart(){
        addToCartBackpackButton.click();
    }

    //sepetteki urun sayisini string oalrak okuyan metot
    public String getCartBadgeCount(){
        return cartBadge.getText();
    }
}
