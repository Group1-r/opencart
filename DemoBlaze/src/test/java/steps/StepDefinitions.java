package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

public class StepDefinitions {

    WebDriver driver;
    HomePage home;
    LoginPage login;
    SignupPage signup;
    ProductPage product;
    CartPage cart;

    @Given("user is on home page")
    public void user_is_on_home_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        home = new HomePage(driver);
        home.openSite();
    }

    @When("user clicks login")
    public void user_clicks_login() {
        home.clickLogin();
        login = new LoginPage(driver);
    }

    @When("user clicks signup")
    public void user_clicks_signup() {
        home.clickSignup();
        signup = new SignupPage(driver);
    }

    @When("user enters username {string}")
    public void user_enters_username(String username) {
        if (login != null) login.enterUsername(username);
        else if (signup != null) signup.enterUsername(username);
    }

    @When("user enters password {string}")
    public void user_enters_password(String password) {
        if (login != null) login.enterPassword(password);
        else if (signup != null) signup.enterPassword(password);
    }

    @When("user clicks login button")
    public void user_clicks_login_button() {
        login.clickLogin();
    }

    @When("user clicks signup button")
    public void user_clicks_signup_button() {
        signup.clickSignup();
    }

    @Then("user should see signup success alert")
    public void user_should_see_signup_success_alert() throws InterruptedException {
        Thread.sleep(2000); // Wait for alert
        driver.switchTo().alert().accept();
    }

    @Then("user should be logged in")
    public void user_should_be_logged_in() {
        // يمكن إضافة assert حسب username
    }

    @Given("user is logged in")
    public void user_is_logged_in() {
        home.openSite();
        home.clickLogin();
        login = new LoginPage(driver);
        login.enterUsername("test123");
        login.enterPassword("test123");
        login.clickLogin();
    }

    @When("user selects product {string}")
    public void user_selects_product(String productName) {
        product = new ProductPage(driver);
        product.selectProduct(productName);
    }

    @When("user clicks add to cart")
    public void user_clicks_add_to_cart() throws InterruptedException {
        product.addToCart();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
    }

    @Then("product should be added to cart")
    public void product_should_be_added_to_cart() {
        // يمكن إضافة assert على صفحة الكارت
    }

    @Given("user is on cart page")
    public void user_is_on_cart_page() {
        driver.get("https://www.demoblaze.com/cart.html");
        cart = new CartPage(driver);
    }

    @When("user clicks place order")
    public void user_clicks_place_order() {
        cart.placeOrder();
    }

    @When("user enters order details")
    public void user_enters_order_details() {
        cart.enterOrderDetails("Rawan", "Egypt", "Cairo", "123456789", "11", "2025");
    }

    @When("user confirms purchase")
    public void user_confirms_purchase() {
        cart.confirmPurchase();
    }

    @Then("order should be successful")
    public void order_should_be_successful() {
        // يمكن إضافة assert حسب confirmation
        driver.quit();
    }

    @When("user clicks logout")
    public void user_clicks_logout() {
        driver.findElement(By.id("logout2")).click();
        driver.quit();
    }
}
