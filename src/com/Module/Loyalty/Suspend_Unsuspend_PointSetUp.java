package com.Module.Loyalty;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.Login;
import com.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.IOException;
import java.security.SecureRandom;

public class Suspend_Unsuspend_PointSetUp extends TestBase {

    @Test
    public void USUSPEND_UNSUSPEND_POINT_SETUP() throws IOException, InterruptedException {
        test = extent.createTest("SUSPEND UNSUSPEND POINT SETUP");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        Login login = new Login(driver);
        SecureRandom rn = new SecureRandom();
        int st = rn.nextInt(50) + 1;

        login.Login();
        test.log(Status.PASS, "Login Was Successful");

        //COM
        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("com_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("LoyaltyBTN_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("PointSetup_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("ActionPointSetUp_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("SuspendPointSetUp_XPATH")))).click();

        login.AcceptAlert();

        Thread.sleep(2000);
        WebElement msg1 = driver.findElement(By.xpath(Utility.fetchLocator("AssertProductCate_XPATH")));
        String text1 = msg1.getText();
        if (msg1.isEnabled() && text1.contains("Points setup suspended")) {
            test.log(Status.PASS, "Point SetUp Suspended Successfully");
        } else {
            test.log(Status.FAIL, "Suspension Point SetUp Failed");
        }

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("ActionPointSetUp_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("UnsuspendPointSetUp_XPATH")))).click();

        login.AcceptAlert();

        Thread.sleep(2000);
        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("Asser_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("Points setup unsuspended")) {
            test.log(Status.PASS, "Point SetUp UnSuspended Successfully");
        } else {
            test.log(Status.FAIL, "Unsuspend Point SetUp Failed");
        }

        Thread.sleep(2000);
        System.out.println("********************SUSPEND UNSUSPEND POINT SETUP********************");
        driver.quit();
    }
}
