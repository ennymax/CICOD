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

public class UpdatePointSetUp extends TestBase {

    @Test
    public void UPDATE_POINT_SETUP() throws IOException, InterruptedException {
        test = extent.createTest("UPDATE POINT SETUP");
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
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("UpdateActionPoint_XPATH")))).click();

        Thread.sleep(2000);
        WebElement y = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("AmountPoint_XPATH"))));
        y.clear();
        y.sendKeys(Utility.fetchLocator("Empty_TEXT") + st);

        Thread.sleep(2000);
        WebElement K = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("Points_XPATH"))));
        K.clear();
        K.sendKeys(Utility.fetchLocator("Empty_TEXT") + st);

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("SavePointSetUp_XPATH")))).click();

        WebElement msg1 = driver.findElement(By.xpath(Utility.fetchLocator("AssertProductCate_XPATH")));
        String text1 = msg1.getText();
        if (msg1.isEnabled() && text1.contains("Points setup updated")) {
            test.log(Status.PASS, "Point SetUp Updated Successfully");
        } else {
            test.log(Status.FAIL, "Update Point SetUp Failed");
        }

        System.out.println("********************UPDATE POINT SETUP********************");
        driver.quit();
    }
}
