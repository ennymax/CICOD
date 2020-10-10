package com.Module.DashBoard;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.BrokenLink;
import com.utility.Login;
import com.utility.ScreenShot;
import com.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ProductDashboard extends TestBase {

    @Test
    public void PRODUCT_DASHBOARD() throws IOException, InterruptedException {
        test = extent.createTest("PRODUCT DASHBOARD");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);

        login.Login();
        test.log(Status.PASS, "Login Was Successful");

        //Com
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        Thread.sleep(2000);
        (new WebDriverWait(driver, 15)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("OrderfufilmentBTN_XPATH")))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AsertTotalOrder_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Total Order is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Total Order is not displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertPaidOrders_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Total Paid Orders is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Total Paid is not displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertTotalPendingOrders_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Total Pending Orders is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Top Pending Orders is not displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertTotalCancelledOrder_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Total canceled Order is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Total canceled Order is not displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertExpiredAndCreditOrders_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Expired and Credit Orders is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Expired and Credit Orders is not displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertAnnualsaleTarget_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Annual Sale Target is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Annual Sale is not displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("assertTotalCashAndTotalReturn_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Total cash and total return is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Total cash and total is not displayed and enabled");
        }

        Thread.sleep(2000);
        screenshot.ScreenShot();
        System.out.println("********************PRODUCT DASHBOARD********************");
        driver.quit();
    }
}
