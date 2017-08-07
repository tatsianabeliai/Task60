package pages;

import helpers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailsPageObjectPage {
    private static final By LOGOUT_LINK = By.id("PH_logoutLink");
    private static final By LOGINED_USERNAME_AT_TOP = By.id("PH_user-email");
    private static WebDriver driver;

    public void logout() {
        driver = DriverSingleton.getDriver();
        driver.findElement(LOGOUT_LINK).click();
    }

    public boolean isLoginedUsernameDisplayedAtTop() {
        return driver.findElement(LOGINED_USERNAME_AT_TOP).isDisplayed();
    }
}
