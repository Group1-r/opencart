package Pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage extends BasePage {

    public ContactPage(WebDriver driver){
        super(driver);
    }

    private By contactLink = By.linkText("Contact");
    private By emailField = By.id("recipient-email");
    private By nameField = By.id("recipient-name");
    private By messageField = By.id("message-text");
    private By sendMessageBtn = By.xpath("//button[text()='Send message']");

    public void openContactModal(){
        click(contactLink);
    }

    public void enterEmail(String email){
        write(emailField, email);
    }

    public void enterName(String name){
        write(nameField, name);
    }

    public void enterMessage(String message){
        write(messageField, message);
    }

    public void clickSendMessage(){
        click(sendMessageBtn);
    }
}
