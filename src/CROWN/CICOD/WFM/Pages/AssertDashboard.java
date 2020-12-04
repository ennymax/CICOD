package CROWN.CICOD.WFM.Pages;

import CROWN.Base.TestBase;
import CROWN.utility.*;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class AssertDashboard extends TestBase {

    @Test
    public void ASSERT_DASHBOARD() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.LoginPremium();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("assersetUpescalation_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Set Up Escalation is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Set Up escalation is not displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertConfigureResources_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Configure Resources is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Configure Resources is not displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertCreateTypesAndAccess_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Create Type and access is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Create Type and access is displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertSetUpBusiness_XPATH"))).size() != 0) {
            test.log(Status.PASS, "SetUp Business Life Cycle is displayed abd enabled");
        } else {
            test.log(Status.FAIL, "SetUp Business Life Cycle is not displayed and Enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertSetUpBusinessLifeCycle_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Business Life Cycle is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Business life Cycle is not displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertSetUpWoflow_XPATH"))).size() != 0) {
            test.log(Status.PASS, "SetUp workflow is displayed and enabled");
        } else {
            test.log(Status.FAIL, "SetUp workflow is not displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertWatchVideo_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Watch Video Feature is displayed and enabled");
        } else {
            test.log(Status.FAIL, "RavePayment Page wasn't displayed");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AsserLearnMoreCicodSupport_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Learn more cicod support is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Learn more cicod support is not displayed and enabled");
        }
    }
}
