package Pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class HomepagePage extends BasePage {

    public HomepagePage(WebDriver driver){
        super(driver);
    }

    private By loginLink = By.id("login2");
    private By usernameField = By.id("loginusername");
    private By passwordField = By.id("loginpassword");
    private By loginBtn = By.xpath("//button[text()='Log in']");
    private By firstProduct = By.cssSelector(".card h4 a");
    private By addToCartBtn = By.linkText("Add to cart");
    private By cartLink = By.id("cartur");
    private By placeOrderModal = By.id("orderModal");

    public void openUrl(String url){
        driver.get(url);
    }

    public void clickLogin(){
        click(loginLink);
    }

    public void enterUsername(String username){
        write(usernameField, username);
    }

    public void enterPassword(String password){
        write(passwordField, password);
    }

    public void clickLoginButton(){
        click(loginBtn);
    }

    public void openFirstProduct(){
        click(firstProduct);
    }

    public void addToCart(){
        click(addToCartBtn);
    }

    public void acceptAlert(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void goToCart(){
        click(cartLink);
    }

    public boolean isPlaceOrderModalVisible(){
        return isDisplayed(placeOrderModal);
    }

    public String getTitle(){
        return driver.getTitle();
    }
}

