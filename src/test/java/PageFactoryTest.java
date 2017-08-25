import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmailsFactoryPage;
import pages.LoginFactoryPage;

public class PageFactoryTest extends TestBase {
    public static String siteURL = "https://mail.ru/";
    public String userName = "seleniumtests10";
    public String password = "060788avavav";
    public String domain = "mail.ru";

    public PageFactoryTest() {
        super(siteURL);
    }

    @Test
    public void login() {
        LoginFactoryPage loginFactoryPage = PageFactory.initElements(driver, LoginFactoryPage.class);
        loginFactoryPage.login(userName, password, domain);
        EmailsFactoryPage emailsFactoryPage = PageFactory.initElements(driver, EmailsFactoryPage.class);
        Assert.assertTrue(emailsFactoryPage.loginedUserNameAtTop.isDisplayed(), "Logout link is displayed so user is not logged in");
    }

    @Test(dependsOnMethods = "login")
    public void logout() {
        EmailsFactoryPage emailsFactoryPage = PageFactory.initElements(driver, EmailsFactoryPage.class);
        emailsFactoryPage.logout();
        LoginFactoryPage loginFactoryPage = PageFactory.initElements(driver, LoginFactoryPage.class);
        Assert.assertTrue(loginFactoryPage.loginLink.isDisplayed(), "No Login link so the user is logined");
    }
}
