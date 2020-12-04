package CROWN.EKEDC;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class Track_Ticket_With_Wrong_Billing_ID extends TestBase {
    @Test
    public void TRACK_VALID_ID_WITH_WRONG_ID() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.LoginEKEDC();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("NavigatetoHomepageBTN_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("TIcketIDinput_XPATH"))).sendKeys(Utility.fetchLocator("InvalidTicketID_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("TrackTicketIDBTN_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("IvalidTicket_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Invalid Ticket Error Message was displayed");
        } else {
            test.log(Status.FAIL, "Invalid Ticket Error ID was not displayed");
        }
    }
}
