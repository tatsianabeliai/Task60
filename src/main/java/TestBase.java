import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {
    private static final int DEFAULT_TIMEOUT = 10;
    WebDriver driver;
    private String baseUrl;

    TestBase(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    void waitForAllElements() {
        WebDriverWait waitElements = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        waitElements.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*")));
    }

    @BeforeSuite
    public void init() {
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterSuite
    public void quit() {
        driver.quit();
    }
}
