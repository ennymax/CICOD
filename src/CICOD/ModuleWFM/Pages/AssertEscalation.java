package CICOD.ModuleWFM.Pages;

import CICOD.base.TestBase;
import CICOD.utility.Login;
import CICOD.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class AssertEscalation extends TestBase {

    @Test
    public void ASSERT_ESCALATION() throws IOException, InterruptedException {
        test = extent.createTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        Login login = new Login(driver);

        login.LoginPremium();

        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("EscalationMainMenue_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("EscalationTorole_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertWalkThrough_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Walk through is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Walk through is not displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("PageBar_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Page bar is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Page bar is not displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertProductToggler_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Product toggle is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Product toggle is not displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertUsename_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Username is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Username is not displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertHeader_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Header is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Header is not displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertSetUpWiz_XPATH"))).size() != 0) {
            test.log(Status.PASS, "SetUp Wizard is displayed and enabled");
        } else {
            test.log(Status.FAIL, "SetUp Wizard is not displayed and enabled");
        }
    }
}
