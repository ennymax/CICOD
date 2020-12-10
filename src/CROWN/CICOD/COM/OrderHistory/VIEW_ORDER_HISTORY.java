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
    ScreenShot screenshot = new ScreenShot(driver);

    @Test(priority=1)
    public void loginAsAdmin() throws IOException, InterruptedException {
        Login login = new Login(driver);
        login.Login();
    }

    @Test(priority=2)
    public void CustomerOrderManagement() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
    }

    @Test(priority=3)
    public void OrderHistoryButton() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("OrderHistorybtn_XPATH"))).click();
    }

    @Test(priority=4)
    public void OrderRecord() throws IOException, InterruptedException {
        Thread.sleep(2000);
        screenshot.ScreenShot();
        driver.findElement(By.xpath(Utility.fetchLocator("ClickOnOrderRecordsbtn_XPATH"))).click();
    }

    @Test(priority=5)
    public void Assert_ORDER_history() throws IOException, InterruptedException {
        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertRecord_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Order history can be Viewed");
        } else {
            test.log(Status.FAIL, "The Order history cant be viewed");
        }
    }
}
