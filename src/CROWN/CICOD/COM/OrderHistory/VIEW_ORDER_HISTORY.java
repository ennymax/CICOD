package CROWN.CICOD.COM.OrderHistory;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.ScreenShot;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.io.IOException;

public class VIEW_ORDER_HISTORY extends TestBase {
    @Test
    public void VIEW_ORDER_history() throws IOException, InterruptedException {
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);

        login.Login();

        //COM
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("OrderHistorybtn_XPATH"))).click();

        Thread.sleep(2000);
        screenshot.ScreenShot();
        driver.findElement(By.xpath(Utility.fetchLocator("ClickOnOrderRecordsbtn_XPATH"))).click();

        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertRecord_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Order history can be Viewed");

        } else {
            test.log(Status.FAIL, "The Order history cant be viewed");
        }
    }
}
