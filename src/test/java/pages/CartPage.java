package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CartPage {

    public CartPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //sepet sayfasindaki checkout butonu
    @FindBy(id="checkout")
    public WebElement checkoutButton;

    //ödeme ekranina gecme
    public void clickCheckout(){
        checkoutButton.click();
    }
}
