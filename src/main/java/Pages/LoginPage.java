package Pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    private By loginLink = By.id("login2");
    private By usernameField = By.id("loginusername");
    private By passwordField = By.id("loginpassword");
    private By loginBtn = By.xpath("//button[text()='Log in']");
    private By logoutLink = By.id("logout2");

    public void openLoginModal(){ click(loginLink); }
    public void enterUsername(String username){ write(usernameField, username); }
    public void enterPassword(String password){ write(passwordField, password); }
    public void clickLoginButton(){ click(loginBtn); }
    public boolean isLoginSuccessful(){ return isDisplayed(logoutLink); }
}
