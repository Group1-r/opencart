package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    By loginBtn = By.id("login2");
    By signupBtn = By.id("signin2");

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void openSite(){
        driver.get("https://www.demoblaze.com/");
    }

    public void clickLogin(){
        driver.findElement(loginBtn).click();
    }

    public void clickSignup(){
        driver.findElement(signupBtn).click();
    }
}
