package pages;

import helpers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailsPageObjectPage {
    public static final By LOGOUT_LINK = By.id("PH_logoutLink");
    public static final By LOGINED_USERNAME_AT_TOP = By.id("PH_user-email");
    public static WebDriver driver;

    public void logout() {
        driver = DriverSingleton.getDriver();
        driver.findElement(LOGOUT_LINK).click();
    }
}
