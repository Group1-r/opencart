package tests;

import Pages.CartPage;
import Pages.HomepagePage;
import Pages.PlaceOrderPage;
import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends TestBase {

    @Test
    public void addProductAndCheckCart(){
        HomepagePage home = new HomepagePage(driver);
        home.openUrl("https://www.demoblaze.com/");
        home.openFirstProduct();
        home.addToCart();
        home.acceptAlert();
        home.goToCart();

        CartPage cart = new CartPage(driver);
        Assert.assertTrue(cart.isCartNotEmpty(), "Cart should not be empty");
        Assert.assertTrue(cart.getTotalPrice() > 0, "Total price should be greater than 0");
    }

    @Test
    public void deleteProductFromCart(){
        HomepagePage home = new HomepagePage(driver);
        home.openUrl("https://www.demoblaze.com/");
        home.openFirstProduct();
        home.addToCart();
        home.acceptAlert();
        home.goToCart();

        CartPage cart = new CartPage(driver);
        int totalBefore = cart.getTotalPrice();
        cart.deleteFirstProduct();
        int totalAfter = cart.isCartNotEmpty() ? cart.getTotalPrice() : 0;

        Assert.assertNotEquals(totalBefore, totalAfter, "Total price should update after deleting product");
    }

    @Test
    public void placeOrderTest(){
        HomepagePage home = new HomepagePage(driver);
        home.openUrl("https://www.demoblaze.com/");
        home.openFirstProduct();
        home.addToCart();
        home.acceptAlert();
        home.goToCart();

        CartPage cart = new CartPage(driver);
        cart.clickPlaceOrder();

        Assert.assertTrue(home.isPlaceOrderModalVisible(), "Place Order modal should be visible");

        PlaceOrderPage order = new PlaceOrderPage(driver);
        order.enterName("Rawan");
        order.enterCountry("Egypt");
        order.enterCity("Cairo");
        order.enterCard("1234567890123456");
        order.enterMonth("11");
        order.enterYear("2025");
        order.clickPurchase();
    }
}
