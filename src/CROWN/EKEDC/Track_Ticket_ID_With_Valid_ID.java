package CROWN.EKEDC;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.IOException;

public class Track_Ticket_ID_With_Valid_ID extends TestBase {

    @Test
    public void TRACK_VALID_ID_WITH_VALID_ID() throws InterruptedException, IOException {

        Login login = new Login(driver);

        login.LoginEKEDC();

        driver.findElement(By.xpath(Utility.fetchLocator("NavigatetoHomepageBTN_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("TIcketIDinput_XPATH"))).sendKeys(Utility.fetchLocator("ValidTicketID_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("TrackTicketIDBTN_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertTicketID_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Details of the Ticket ID was dispalyed");
        } else {
            test.log(Status.FAIL, "Details of the Ticket ID was not displayed");
        }

        // Create instance of Javascript executor
        JavascriptExecutor je = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("Scrowl1_XPATH")));
        je.executeScript("arguments[0].scrollIntoView(true);", element);

        Thread.sleep(100);
        JavascriptExecutor jej = (JavascriptExecutor) driver;
        WebElement element11 = driver.findElement(By.xpath(Utility.fetchLocator("Scrowl2_XPATH")));
        jej.executeScript("arguments[0].scrollIntoView(true);", element11);
    }
}
