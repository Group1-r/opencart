package Pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By cartRows = By.xpath("//tr");
    private By placeOrderBtn = By.xpath("//button[text()='Place Order']");
    private By deleteButtons = By.xpath("//a[text()='Delete']");
    private By totalPrice = By.id("totalp");
    private By cartLink = By.id("cartur"); // رابط الكارت

    // ---------- Actions ----------


    public void openCart() {
        click(cartLink);
    }


    public boolean isCartNotEmpty() {
        List<WebElement> rows = driver.findElements(cartRows);
        return rows.size() > 1; 
    }
l
    public void deleteFirstProduct() {
        List<WebElement> deletes = driver.findElements(deleteButtons);
        if (!deletes.isEmpty()) {
            deletes.get(0).click();
        }
    }

     Place Order
    public void clickPlaceOrder() {
        click(placeOrderBtn);
    }

 
    public int getTotalPrice() {
        String priceText = driver.findElement(totalPrice).getText();
        return Integer.parseInt(priceText);
    }
}
