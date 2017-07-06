import helpers.DriverSingleton;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.EmailsPageObjectPage;
import pages.LoginPageObjectPage;

public class PageObjectTest {

    public static final String BASE_URL = "https://mail.ru/";
    public String userName = "seleniumtests10";
    public String password = "060788avavav";
    public String domain = "mail.ru";

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
        loginPageObjectPage.login(userName, password, domain);
        Assert.assertTrue(DriverSingleton.getDriver().findElement(EmailsPageObjectPage.LOGINED_USERNAME_AT_TOP).isDisplayed(),
                "The user is not logged in");
    }

    @Test(dependsOnMethods = "login")
    public void logout() {
        EmailsPageObjectPage emailsPageObjectPage = new EmailsPageObjectPage();
        emailsPageObjectPage.logout();
        Assert.assertTrue(DriverSingleton.getDriver().findElement(LoginPageObjectPage.LOGIN_LINK).isDisplayed(),
                "User is not logged out");
    }
}
