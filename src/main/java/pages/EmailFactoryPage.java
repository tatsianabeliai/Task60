package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFactoryPage {
    @FindBy(id = "PH_logoutLink")
    private WebElement logoutLink;

    @FindBy(id = "PH_user-email")
    private WebElement loginedUserNameAtTop;

    public void logout() {
        logoutLink.click();
    }

    public boolean isLoginedUserNameDisplayed() {
        return loginedUserNameAtTop.isDisplayed();
    }
}
