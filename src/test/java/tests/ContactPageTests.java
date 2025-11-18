package tests;

import Pages.ContactPage;
import Pages.HomepagePage;
import base.TestBase;
import org.testng.annotations.Test;

public class ContactPageTests extends TestBase{

    @Test
    public void sendMessageTest() throws InterruptedException {
        HomepagePage home = new HomepagePage(driver);
        home.openUrl("https://www.demoblaze.com/");

        ContactPage contact = new ContactPage(driver);
        contact.openContactModal();
        Thread.sleep(500); // انتظر Modal للظهور

        contact.enterEmail("rawan@example.com");
        contact.enterName("Rawan Ashraf");
        contact.enterMessage("Hello, this is a test message.");
        contact.clickSendMessage();

        // قبول Alert بعد الإرسال
        home.acceptAlert();
    }
}
