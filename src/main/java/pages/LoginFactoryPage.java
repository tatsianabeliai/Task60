package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginFactoryPage {
    @FindBy(id = "mailbox__login")
    public WebElement usernameField;

    @FindBy(id = "mailbox__password")
    public WebElement passwordField;

    @FindBy(id = "mailbox__auth__button")
    public WebElement loginButton;

    @FindBy(id = "mailbox__login__domain")
    public WebElement loginDomainDropDown;

    @FindBy(id = "PH_authLink")
    public WebElement loginLink;

    public LoginFactoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void login(String userName, String password, String domain) {
        usernameField.sendKeys(userName);
        passwordField.sendKeys(password);
        Select loginDomainDrop = new Select(loginDomainDropDown);
        loginDomainDrop.selectByValue(domain);
        loginButton.click();
    }
}
