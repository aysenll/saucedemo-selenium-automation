package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class CheckoutPage {

    public CheckoutPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //musteri bilgileri formu
    @FindBy(id="first-name")
    public WebElement firstNameInput;

    @FindBy(id="last-name")
    public WebElement lastNameInput;

    @FindBy(id="postal-code")
    public WebElement postalCodeInput;

    @FindBy(id="continue")
    public WebElement continueButton;

    //siparis ekranindaki finish butonu
    @FindBy(id="finish")
    public WebElement finishButton;

    //siparis ekranindaki basari mesaji
    @FindBy(className = "complete-header")
    public WebElement completeHeader;

    //form bilgileri bitince sonraki sayfaya gecme
    public void fillCustomerInfo(String firstName, String lastName, String postalCode) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        postalCodeInput.sendKeys(postalCode);
        continueButton.click();
    }

    //finish butonu ekranda tıklanabilir olana kadar en fazla 10 saniye bekler ve tıklar
    public void clickFinish(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(finishButton)).click();
    }

    //onay mesajı görünür olana kadar bekler ve metni okur
    public String getCompleteMessage(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(completeHeader)).getText();
    }
    }

