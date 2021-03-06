package CROWN.CICOD.WFM.EscalationConfiguration;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;

public class Suspend_UnsuspendRegionToRole extends TestBase {
    @Test
    public void SUSPEND_UNSUSPEND_ESCALATION_ROLE() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.LoginPremium();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("EscalationMainMenue_XPATH"))).click();

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("RegionToRoleBTN_XPATH"))).click();

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("RegiontoRoleActionBTN_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SuspendEscalationRole_XPATH"))).click();

        driver.switchTo().alert().accept();

        Thread.sleep(2000);
        WebElement msg =(new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertRoleSuspension_XPATH"))));
        String text = msg.getText();
        if (msg.isEnabled() && text.contains("Suspended")) {
            test.log(Status.PASS, "Suspension/Unsuspension was successful");
        } else {
            test.log(Status.FAIL, "suspension failed");
        }

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("OKBTN6_XPATH"))).click();

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("RegiontoRoleActionBTN_XPATH"))).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath(Utility.fetchLocator("UnsuspendEscalationRole_XPATH"))).click();

        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("OKBTN6_XPATH"))).click();
    }
}
