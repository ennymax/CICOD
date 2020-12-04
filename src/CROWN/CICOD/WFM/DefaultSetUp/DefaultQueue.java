package CROWN.CICOD.WFM.DefaultSetUp;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class DefaultQueue extends TestBase {

    @Test
    public void DEFAULT_QUEUE() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.LoginDef1();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("WorkOrderManagement_XPATH"))).click();

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("Manage_Queue_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertOrderFufilment_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Order Fulfilment Queue is present as Default");
        } else {
            test.log(Status.FAIL, "Order Fulfilment Queue is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertComplaint_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Complaint Queue is present as Default");
        } else {
            test.log(Status.FAIL, "Complaint Queue is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertFinance_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Finance Queue is present as Default");
        } else {
            test.log(Status.FAIL, "Finance Queue is not present as Default");
        }
    }
}
