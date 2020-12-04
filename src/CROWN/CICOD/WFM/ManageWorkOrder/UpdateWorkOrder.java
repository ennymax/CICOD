package CROWN.CICOD.WFM.ManageWorkOrder;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class UpdateWorkOrder extends TestBase {

    @Test
    public void UPDATE_WORKORDER() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.LoginPremium();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("WorkOrderManager_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ManageWorkOrder_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("All_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ActionBTN_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("UpdateWorkOrder_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("CreateBtn_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertTrue_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Update WorkOrder was Successful SuccessFULLY");
        } else {
            test.log(Status.FAIL, "Update Work Order Failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("OkBTN_XPATH"))).click();
    }
}
