import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmailFactoryPage;
import pages.LoginFactoryPage;

public class PageFactoryTest extends TestBase {
    private static final String SITE_URL = "https://mail.ru/";
    private static final String USER_NAME = "seleniumtests10";
    private static final String PASSWORD = "060788avavav";
    private static final String DOMAIN = "mail.ru";

    public PageFactoryTest() {
        super(SITE_URL);
    }

    @Test
    public void login() {
        LoginFactoryPage loginFactoryPage = PageFactory.initElements(driver, LoginFactoryPage.class);
        loginFactoryPage.login(USER_NAME, PASSWORD, DOMAIN);
        EmailFactoryPage emailFactoryPage = PageFactory.initElements(driver, EmailFactoryPage.class);
        Assert.assertTrue(emailFactoryPage.isLoginedUserNameDisplayed(), "Logout link is displayed so user is not logged in");
    }

    @Test(dependsOnMethods = "login")
    public void logout() {
        EmailFactoryPage emailFactoryPage = PageFactory.initElements(driver, EmailFactoryPage.class);
        emailFactoryPage.logout();
        LoginFactoryPage loginFactoryPage = PageFactory.initElements(driver, LoginFactoryPage.class);
        Assert.assertTrue(loginFactoryPage.isLoginLinkDisplayed(), "No Login link so the user is logined");
    }
}
