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
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OrderFufilment extends TestBase {

    @Test
    public void ORDER_FUFILLMENT() throws IOException, InterruptedException {
        test = extent.createTest("ORDER FULFILMENT");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        Login login = new Login(driver);

        login.Login();
        test.log(Status.PASS, "Login Was Successful");

        //Com
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        //DashBoard
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Dashboard_XPATH"))).click();
        test.log(Status.PASS, "Dashboard button fully functional");

        driver.findElement(By.xpath(Utility.fetchLocator("Datefrom_XPATH"))).clear();
        driver.findElement(By.xpath(Utility.fetchLocator("Datefrom_XPATH"))).sendKeys(Utility.fetchLocator("Datefrom_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("Dateto_XPATH"))).clear();
        driver.findElement(By.xpath(Utility.fetchLocator("Dateto_XPATH"))).sendKeys(Utility.fetchLocator("Dateto_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Dispalybtn_XPATH"))).click();

        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("TotalOrder_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Total Order was displayed and enabled");
        } else {
            test.log(Status.FAIL, "Total order wasnt displayed and enabled");
        }

        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("PaidOrder_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Paid Order was displayed and enabled");
        } else {
            test.log(Status.FAIL, "Paid Order wasn't displayed and enabled");
        }

        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("TotalPendingOeder_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Total Pending Order was displayed and enabled");
        } else {
            test.log(Status.FAIL, "Total Pending Order wasn't displayed and enabled");
        }

        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("TotalCancelOrder_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Total cancel Order is Displayed and Enabled");
        } else {
            test.log(Status.FAIL, "Total Canceled Order is not displayed and enabled");
        }

        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("ExpiredAndCreditOrders_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Expired and Credit Order is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Expired and Credit Order is not displayed and Enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AnnualSalesTarget_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Annual Sales Target is Displayed and enabled");
        } else {
            test.log(Status.FAIL, "Annual Sales Target is not displayed and ebabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("Top10Customers_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Top 10 Customers is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Top 10 customer is not Displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("Top10Product_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Top 10 Product is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Top 10 Product is not displayed and Enabled");
        }

        System.out.println("********************Order fulfillment Test is Completed********************");
        driver.quit();
    }
}

