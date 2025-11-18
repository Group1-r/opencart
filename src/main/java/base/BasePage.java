package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Alert;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }
    protected void click(By locator){
        driver.findElement(locator).click();
    }
    protected void write(By locator, String text){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }
    protected String read(By locator){
        return driver.findElement(locator).getText();
    }

    protected boolean isDisplayed(By locator){
        return driver.findElement(locator).isDisplayed();
    }

    public void openUrl(String url){
        driver.get(url);
    }

    public void acceptAlert(){
        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            System.out.println("No alert found to accept!");
        }
    }

    public String getAlertText(){
        try {
            Alert alert = driver.switchTo().alert();
            return alert.getText();
        } catch (Exception e) {
            return null;
        }
    }
}
