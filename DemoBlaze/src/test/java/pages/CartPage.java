package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    By placeOrderBtn = By.xpath("//button[text()='Place Order']");
    By nameField = By.id("name");
    By countryField = By.id("country");
    By cityField = By.id("city");
    By cardField = By.id("card");
    By monthField = By.id("month");
    By yearField = By.id("year");
    By purchaseBtn = By.xpath("//button[text()='Purchase']");

    public CartPage(WebDriver driver){
        super(driver);
    }

    public void placeOrder(){
        driver.findElement(placeOrderBtn).click();
    }

    public void enterOrderDetails(String name, String country, String city, String card, String month, String year){
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(countryField).sendKeys(country);
        driver.findElement(cityField).sendKeys(city);
        driver.findElement(cardField).sendKeys(card);
        driver.findElement(monthField).sendKeys(month);
        driver.findElement(yearField).sendKeys(year);
    }

    public void confirmPurchase(){
        driver.findElement(purchaseBtn).click();
    }
}
