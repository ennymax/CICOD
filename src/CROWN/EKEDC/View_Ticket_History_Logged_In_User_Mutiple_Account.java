package CROWN.EKEDC;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.io.IOException;

public class View_Ticket_History_Logged_In_User_Mutiple_Account extends TestBase {

    @Test
    public void VIEW_TICKET_HISTORY_LOGGED_IN_MULTIPLE_USER() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.LoginMultipleAccountEKEDC();

        driver.findElement(By.xpath(Utility.fetchLocator("ComplaintsBTN_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("ClickOnTicketID2756127_XPATH"))).click();
        test.log(Status.FAIL, "Check ScreeShot below");

        driver.navigate().back();

        driver.findElement(By.xpath(Utility.fetchLocator("ClickOnTicketID3031683_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertTictIDPr4sent_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Details Of the selected Ticket ID was Displayed");
        } else {
            test.log(Status.FAIL, "Details of the selected Ticket ID was not Displayed");
        }
    }
}
