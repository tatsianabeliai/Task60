package pages;

import helpers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class LoginPageObjectPage {
    private static final By USERNAME_FIELD = By.id("mailbox__login");
    private static final By DOMAIN_LIST = By.id("mailbox__login__domain");
    private static final By PASSWORD_FIELD = By.id("mailbox__password");
    private static final By LOGIN_BUTTON = By.id("mailbox__auth__button");
    private static final By LOGIN_LINK = By.id("PH_authLink");
    private static WebDriver driver;

    public void login(String userName, String password, String domain) {
        driver = DriverSingleton.getDriver();
        driver.findElement(USERNAME_FIELD).sendKeys(userName);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        selectDomain(domain);
        driver.findElement(LOGIN_BUTTON).click();
    }

    private void selectDomain(String domain) {
        Select loginDomainDrop = new Select(driver.findElement(DOMAIN_LIST));
        loginDomainDrop.selectByValue(domain);
    }

    public boolean isLoginLinkDisplayed() {
        return driver.findElement(LOGIN_LINK).isDisplayed();
    }
}
