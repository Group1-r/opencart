package tests;

import Pages.CartPage;
import Pages.HomepagePage;
import Pages.PlaceOrderPage;
import Pages.ProductPage;
import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTests extends TestBase {

    @Test
    public void completePurchaseSuccessfully() {
        HomepagePage home = new HomepagePage(driver);
        home.openUrl("https://www.demoblaze.com/");
        home.openFirstProduct();

        ProductPage product = new ProductPage(driver);
        product.clickAddToCart();
        product.acceptAlert();

        CartPage cart = new CartPage(driver);
        cart.openCart();
        cart.clickPlaceOrder();

        PlaceOrderPage order = new PlaceOrderPage(driver);
        order.fillOrderForm("Rawan", "Egypt", "Cairo", "123456789", "12", "2025");
        order.confirmPurchase();

        Assert.assertTrue(order.isSuccessMessageDisplayed());
    }
}
