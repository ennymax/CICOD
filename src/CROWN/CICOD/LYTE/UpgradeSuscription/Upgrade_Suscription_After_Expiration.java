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

public class Upgrade_Suscription_After_Expiration extends TestBase {

    @Test
    public void UPGRADE_SUBSCRIPTION_AFTER_EXPIRATION() throws IOException, InterruptedException {
        RavePay ravePay = new RavePay(driver);
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

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("SubPayOnline_XPATH")))).click();

        ravePay.RavePay1();

        Thread.sleep(2000);
        WebElement msg =(new WebDriverWait(driver, 45)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("Assssss_XPATH"))));
        String text = msg.getText();
        if (msg.isEnabled() && text.contains("Enter your 4-digit card pin to authorize this payment")) {
            test.log(Status.PASS, "Flutter wave Page fully Functional");
        } else {
            test.log(Status.FAIL, "Flutter wave page not Functional");
        }
    }
}
