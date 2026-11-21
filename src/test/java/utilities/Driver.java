package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

    private Driver(){}

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver==null) {
            String browser = ConfigReader.getProperty("browser");

           switch(browser){
               case "chrome":
                driver = new ChromeDriver();
                break;
               case "firefox":
                driver = new FirefoxDriver();
                break;
               case "edge":
                driver = new EdgeDriver();
                break;
               default:
                   driver = new ChromeDriver();
           }
            driver.manage().window().maximize();
        }
        return driver;
    }


    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            driver=null;
        }
    }
}

