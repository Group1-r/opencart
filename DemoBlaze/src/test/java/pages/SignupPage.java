package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage extends BasePage {

    By usernameField = By.id("sign-username");
    By passwordField = By.id("sign-password");
    By signupBtn = By.xpath("//button[text()='Sign up']");

    public SignupPage(WebDriver driver){
        super(driver);
    }

    public void enterUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignup(){
        driver.findElement(signupBtn).click();
    }
}
