package tests;

import Pages.ProductPage;
import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTests extends TestBase {

    @Test
    public void verifyProductDetails() {
        ProductPage product = new ProductPage(driver);
        product.openUrl("https://www.demoblaze.com/prod.html?idp_=1");

        String title = product.getProductTitle();
        Assert.assertTrue(title.contains("Samsung"), "Title should contain Samsung");

        String price = product.getProductPrice();
        Assert.assertTrue(price.contains("$"), "Price should contain $");
    }

    @Test
    public void addProductToCart() {
        ProductPage product = new ProductPage(driver);
        product.openUrl("https://www.demoblaze.com/prod.html?idp_=1");

        product.clickAddToCart();

        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, "Product added.", "Alert text should confirm product added");
        driver.switchTo().alert().accept();
    }
}
