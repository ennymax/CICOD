package CROWN.CICOD.WFM.DefaultSetUp;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class DefaultResourceLevel extends TestBase {

    @Test
    public void DEFAULT_RESOURCE_LEVEL() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.LoginDef1();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ResourceManagemnet_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ManageResouceLevel_XPATH"))).click();

        Thread.sleep(1500);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertLead_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Lead is present as Default");
        } else {
            test.log(Status.FAIL, "Lead is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertExecutive_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Executive is present as Default");
        } else {
            test.log(Status.FAIL, "Executive is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertSuppervisor_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Supervisor is present as Default");
        } else {
            test.log(Status.FAIL, "Supervisor is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertRegional_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Regional is present as Default");
        } else {
            test.log(Status.FAIL, "Regional Manager is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertOfficer_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Officer is present as Default");
        } else {
            test.log(Status.FAIL, "Officer is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertSenior_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Senior is present as Default");
        } else {
            test.log(Status.FAIL, "Senior is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertJunior_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Junior is present as Default");
        } else {
            test.log(Status.FAIL, "Junior is not present as Default");
        }
    }
}
