package CROWN.CICOD.LYTE.UpgradeSuscription;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.RavePay;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;

public class FailedSubscriptionRenewal extends TestBase {

    @Test
    public void FAILED_SUBSCRIPTION_RENEWAL() throws IOException, InterruptedException {
        RavePay ravePay = new RavePay(driver);
        Login login = new Login(driver);
        Utility utility = new Utility(driver);

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

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("SubPayOnline_XPATH")))).click();

        ravePay.RavePay1();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("CloseFluterWave_XPATH")))).click();

        utility.DowaitandAcceptAlerwhenReady(60);

        Thread.sleep(2000);
        driver.switchTo().defaultContent();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/section/div/div/div/div[2]/div/div/a")));
        if (driver.findElements(By.linkText("Try again")).size() != 0) {
            test.log(Status.PASS, "Failed SubSubscription Page was successfully Displayed");
        } else {
            test.log(Status.FAIL, "Failed SubSubscription Page wasn't displayed");
        }
    }
}
