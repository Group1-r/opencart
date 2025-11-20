package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver){
        super(driver);
    }

    public void selectProduct(String productName){
        driver.findElement(By.linkText(productName)).click();
    }

    public void addToCart(){
        driver.findElement(By.linkText("Add to cart")).click();
    }
}
