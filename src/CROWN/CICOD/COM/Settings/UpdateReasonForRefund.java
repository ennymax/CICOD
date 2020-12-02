package CROWN.CICOD.COM.Settings;

import CROWN.base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class UpdateReasonForRefund extends TestBase {
    @Test
    public void UPDATE_REASON_FOR_REFUND() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.Login();

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Settings_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SystemSettings_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("ReasonforRedund_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("rActionBTN_XPATH"))).click();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("UpdateReasonForRefund_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        WebElement ttt = driver.findElement(By.xpath(Utility.fetchLocator("NewR_XPATH")));
        ttt.clear();
        ttt.sendKeys(Utility.fetchLocator("dec_TEXT"));

        Thread.sleep(2000);
        WebElement elementl = driver.findElement(By.xpath(Utility.fetchLocator("NewSave_XPATH")));
        JavascriptExecutor jsl = (JavascriptExecutor) driver;
        jsl.executeScript("arguments[0].click();", elementl);

        Thread.sleep(2000);
        assertEquals("×\n" + "Reason updated successfully", driver.findElement(By.xpath(Utility.fetchLocator("as_XPATH"))).getText());
        test.log(Status.PASS, "Reason for refund was Updated successfully");
    }
}