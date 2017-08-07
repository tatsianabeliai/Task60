package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginFactoryPage {
    @FindBy(id = "mailbox__login")
    private WebElement usernameField;

    @FindBy(id = "mailbox__password")
    private WebElement passwordField;

    @FindBy(id = "mailbox__auth__button")
    private WebElement loginButton;

    @FindBy(id = "mailbox__login__domain")
    private WebElement loginDomainDropDown;

    @FindBy(id = "PH_authLink")
    private WebElement loginLink;

    public LoginFactoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void login(String userName, String password, String domain) {
        usernameField.sendKeys(userName);
        passwordField.sendKeys(password);
        selectDomain(domain);
        loginButton.click();
    }

    private void selectDomain(String domain){
        Select loginDomainDrop = new Select(loginDomainDropDown);
        loginDomainDrop.selectByValue(domain);
    }

    public boolean isLoginLinkDisplayed() {
        return loginLink.isDisplayed();
    }
}
