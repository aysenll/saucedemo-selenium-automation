package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    private Driver(){}

    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver==null) {
            String browser = ConfigReader.getProperty("browser");

           switch(browser){
               case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--incognito");
                driver = new ChromeDriver(options);
                break;
               case "firefox":
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                break;
               case "edge":
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                break;
               default:
                   ChromeOptions defaultOptions = new ChromeOptions();
                   defaultOptions.addArguments("--start-maximized");
                   defaultOptions.addArguments("--incognito");
                   driver = new ChromeDriver(defaultOptions);
           }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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

