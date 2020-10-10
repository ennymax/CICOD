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

public class View_DashBoard_By_Date extends TestBase {

    @Test
    public void VIEW_DASHBOARD() throws IOException, InterruptedException {
        test = extent.createTest("VIEW DASHBOARD BY DATE");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        ScreenShot screenshot = new ScreenShot(driver);
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
        test.log(Status.PASS, "Display button Clicked");

        Thread.sleep(2000);
        screenshot.ScreenShot();
        if (driver.findElements(By.xpath(Utility.fetchLocator("Rtotalorder_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Total Orders for selected period is displayed");
        } else {
            test.log(Status.FAIL, "Total Orders for selected period is not displayed");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("Rpaidorder_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Paid Orders for selected period is displayed");
        } else {
            test.log(Status.FAIL, "Unpaid Orders for selected period is not displayed");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("Runpaid_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Pending Orders for selected period is displayed");
        } else {
            test.log(Status.FAIL, "Pending Orders for selected period is not displayed");
        }

        System.out.println("********************View DashBoard Test is Completed********************");
        driver.quit();
    }
}
