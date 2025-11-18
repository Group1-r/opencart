package tests;

import Pages.HomepagePage;
import Pages.LoginPage;
import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginWithValidCredentials() throws InterruptedException {
        HomepagePage home = new HomepagePage(driver);
        home.openUrl("https://www.demoblaze.com/");

        LoginPage login = new LoginPage(driver);
        login.openLoginModal();
        Thread.sleep(500);

        login.enterUsername("rawan123");
        login.enterPassword("123456");
        login.clickLoginButton();
        Thread.sleep(1000);

        Assert.assertTrue(login.isLoginSuccessful(), "Login should be successful");
    }
}
