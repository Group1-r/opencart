package tests;

import Pages.PlaceOrderPage;
import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceOrderTests extends TestBase {

    @Test
    public void testPlaceOrder() {
        PlaceOrderPage orderPage = new PlaceOrderPage(driver);
        orderPage.openUrl("https://www.demoblaze.com/cart.html");

        orderPage.fillOrderForm("Rawan", "Egypt", "Cairo", "123456789", "11", "2025");

        orderPage.clickPurchase();

        String message = orderPage.confirmPurchase();
        Assert.assertTrue(message.contains("Thank you"), "Purchase should be successful");
    }
}
