package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailsFactoryPage {
    @FindBy(id = "PH_logoutLink")
    public WebElement logoutLink;

    @FindBy(id = "PH_user-email")
    public WebElement loginedUserNameAtTop;

    public void logout(){
        logoutLink.click();
    }
}
