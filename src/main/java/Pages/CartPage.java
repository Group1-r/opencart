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

    // فتح صفحة الكارت
    public void openCart() {
        click(cartLink);
    }

    // هل الكارت فيه منتجات؟
    public boolean isCartNotEmpty() {
        List<WebElement> rows = driver.findElements(cartRows);
        return rows.size() > 1; // أول صف عنوان الجدول — المنتجات تبدأ من الصف الثاني
    }

    // الضغط على delete لأول منتج
    public void deleteFirstProduct() {
        List<WebElement> deletes = driver.findElements(deleteButtons);
        if (!deletes.isEmpty()) {
            deletes.get(0).click();
        }
    }

    // الضغط على Place Order
    public void clickPlaceOrder() {
        click(placeOrderBtn);
    }

    // جلب إجمالي السعر
    public int getTotalPrice() {
        String priceText = driver.findElement(totalPrice).getText();
        return Integer.parseInt(priceText);
    }
}
