package Pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlaceOrderPage extends BasePage {

    public PlaceOrderPage(WebDriver driver) {
        super(driver);
    }

    // ---------- Locators ----------
    private By nameField = By.id("name");
    private By countryField = By.id("country");
    private By cityField = By.id("city");
    private By cardField = By.id("card");
    private By monthField = By.id("month");
    private By yearField = By.id("year");
    private By purchaseBtn = By.xpath("//button[text()='Purchase']");
    private By successMessage = By.xpath("//h2[contains(text(),'Thank you for your purchase!')]");

    // ---------- Actions ----------
    public void enterName(String name) {
        write(nameField, name);
    }

    public void enterCountry(String country) {
        write(countryField, country);
    }

    public void enterCity(String city) {
        write(cityField, city);
    }

    public void enterCard(String card) {
        write(cardField, card);
    }

    public void enterMonth(String month) {
        write(monthField, month);
    }

    public void enterYear(String year) {
        write(yearField, year);
    }

    public void clickPurchase() {
        click(purchaseBtn);
    }

    // ---------- confirmPurchase ----------
    public String confirmPurchase() {
        click(purchaseBtn);

    
        return read(successMessage);
    }

    // ---------- isSuccessMessageDisplayed ----------
    public boolean isSuccessMessageDisplayed() {
        return isDisplayed(successMessage);
    }

    // ---------- Fill whole form ----------
    public void fillOrderForm(
            String name,
            String country,
            String city,
            String card,
            String month,
            String year
    ) {
        enterName(name);
        enterCountry(country);
        enterCity(city);
        enterCard(card);
        enterMonth(month);
        enterYear(year);
    }
}

