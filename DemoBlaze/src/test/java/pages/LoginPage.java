package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    By usernameField = By.id("loginusername");
    By passwordField = By.id("loginpassword");
    By loginBtn = By.xpath("//button[text()='Log in']");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void enterUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(loginBtn).click();
    }
}
