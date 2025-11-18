package tests;

import Pages.HomepagePage;
import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

public class HomepageTests extends TestBase {

    @Test
    public void verifyHomepageTitle(){
        HomepagePage home = new HomepagePage(driver);
        home.openUrl("https://www.demoblaze.com/");
        Assert.assertTrue(home.getTitle().contains("STORE"));
    }

    @Test
    public void verifyLoginModal(){
        HomepagePage home = new HomepagePage(driver);
        home.openUrl("https://www.demoblaze.com/");
        home.clickLogin();
        Assert.assertTrue(Objects.requireNonNull(driver.getPageSource()).contains("Login"));
    }
}
