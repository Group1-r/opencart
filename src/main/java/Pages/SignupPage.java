package Pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage extends BasePage {

    public SignupPage(WebDriver driver){ super(driver); }

    private By signUpLink = By.id("signin2");
    private By usernameField = By.id("sign-username");
    private By passwordField = By.id("sign-password");
    private By signUpBtn = By.xpath("//button[text()='Sign up']");

    public void openSignUpModal(){ click(signUpLink); }
    public void enterUsername(String username){ write(usernameField, username); }
    public void enterPassword(String password){ write(passwordField, password); }
    public void clickSignUpButton(){ click(signUpBtn); }
}
