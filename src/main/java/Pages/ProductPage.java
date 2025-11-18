package Pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By addToCartBtn = By.xpath("//a[text()='Add to cart']");
    private By productTitle = By.cssSelector(".name");
    private By productPrice = By.cssSelector(".price-container");

    // Actions
    public void clickAddToCart() {
        click(addToCartBtn);
    }

    public String getProductTitle() {
        return read(productTitle);
    }

    public String getProductPrice() {
        return read(productPrice);
    }
}
