package CROWN.CICOD.LYTE.UpgradeSuscription;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class Pay_By_Bank_Transfer extends TestBase {
    @Test
    public void Pay_by_bank_transfer() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.LoginUpgrade();

        Thread.sleep(2000);
        WebElement element1 = (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("Billing1_XPATH"))));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", element1);

        Thread.sleep(2000);
        WebElement element11 = driver.findElement(By.xpath(Utility.fetchLocator("SuscriptionBTN_XPATH")));
        JavascriptExecutor js11 = (JavascriptExecutor) driver;
        js11.executeScript("arguments[0].click();", element11);

        Thread.sleep(2000);
        WebElement element111s = driver.findElement(By.xpath(Utility.fetchLocator("Upgrade_XPATH")));
        JavascriptExecutor js111s = (JavascriptExecutor) driver;
        js111s.executeScript("arguments[0].click();", element111s);

        Thread.sleep(2000);
        WebElement element111 = driver.findElement(By.xpath(Utility.fetchLocator("UpgradetoPremium_XPATH")));
        JavascriptExecutor js111 = (JavascriptExecutor) driver;
        js111.executeScript("arguments[0].click();", element111);

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("Paynow_XPATH")))).click();

        Thread.sleep(120);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("PaybyTransfer_XPATH")))).click();

        Thread.sleep(1000);
        assertEquals("Providus Bank", driver.findElement(By.xpath(Utility.fetchLocator("providousbank_XPATH"))).getText());
        test.log(Status.PASS, "Providus Bank Is Present");

        Thread.sleep(1000);
        assertEquals("Offer Subscription", driver.findElement(By.xpath(Utility.fetchLocator("AccountName_XPATH"))).getText());
        test.log(Status.PASS, "Account Name is Present");

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("BackNT_XPATH"))).click();

        Thread.sleep(120);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("PaybyTransfer_XPATH")))).click();

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("closebtn_XPATH"))).click();

        Thread.sleep(120);
        if (driver.findElements(By.xpath(Utility.fetchLocator("PaybyTransfer_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Closed Payment Page Successfully");
        } else {
            test.log(Status.FAIL, "Failed to close payment Page");
        }
    }
}
