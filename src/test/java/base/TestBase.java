package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utilities.Driver;

import java.time.Duration;

public class TestBase {

    protected static ExtentReports extentReports;
    protected static ExtentSparkReporter extentSparkReporter;
    protected static ExtentTest extentTest;

    @BeforeTest
    public void setUpReport() {
        // Sistemi Türkçe karakter bug'ından korumak için dili İngilizceye sabitliyoruz
        java.util.Locale.setDefault(java.util.Locale.ENGLISH);

        //raporun kaydeilecegi tes-output klasoru icindeki rapor.html dosyası
        String path = System.getProperty("user.dir") + "/test-output/Rapor.html";

        //tasarimciyi dosya yoluna baglama
        extentSparkReporter = new ExtentSparkReporter(path);
        extentSparkReporter.config().setDocumentTitle("E-Ticaret Test Raporu");
        extentSparkReporter.config().setReportName("Regresyon Test Sonuçları");

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        //raporda gorunecek ortam bilgileri
        extentReports.setSystemInfo("Test Ortamı", "QA Ortamı");
        extentReports.setSystemInfo("Tarayıcı", "Chrome");
        extentReports.setSystemInfo("Test Mühendisi", "Ayşen Altındiş");

    }
    @BeforeMethod
    public void setUp(){
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

    @AfterTest
    public void tearDownReport(){
        extentReports.flush();
    }

}
