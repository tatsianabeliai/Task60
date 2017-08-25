import helpers.DriverSingleton;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.EmailsPageObjectPage;
import pages.LoginPageObjectPage;

public class PageObjectTest {

    private static final String BASE_URL = "https://mail.ru/";
    private static final String USERNAME = "seleniumtests10";
    private static final String PASSWORD = "060788avavav";
    private static final String DOMAIN = "mail.ru";

    @BeforeSuite(alwaysRun = true)
    public void setup() {
        DriverSingleton.getDriver().get(BASE_URL);
    }

    @AfterSuite(alwaysRun = true)
    public void teardown() {
        DriverSingleton.quit();
    }

    @Test
    public void login() {
        LoginPageObjectPage loginPageObjectPage = new LoginPageObjectPage();
        EmailsPageObjectPage emailsPageObjectPage = loginPageObjectPage.login(USERNAME, PASSWORD, DOMAIN);
        Assert.assertTrue(emailsPageObjectPage.isLoginedUsernameDisplayedAtTop(),
                "The user is not logged in");
    }

    @Test(dependsOnMethods = "login")
    public void logout() {
        EmailsPageObjectPage emailsPageObjectPage = new EmailsPageObjectPage();
        LoginPageObjectPage loginPageObjectPage = emailsPageObjectPage.logout();
        Assert.assertTrue(loginPageObjectPage.isLoginLinkDisplayed(),
                "User is not logged out");
    }
}
