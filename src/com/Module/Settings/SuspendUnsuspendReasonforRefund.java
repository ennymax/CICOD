package com.Module.Settings;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SuspendUnsuspendReasonforRefund extends TestBase {

    @Test
    public void SUSPEND_UNSUSPEND_REASON_FOR_REFUND() throws IOException, InterruptedException {
        test = extent.createTest("SUSPEND UNSUSPEND REASON FOR REFUND");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        Login login = new Login(driver);

        login.Login();
        test.log(Status.PASS, "Login Was Successful");

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

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
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("rsusend_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        driver.switchTo().alert().accept();
        test.log(Status.PASS, "Reason for Refund was suspended successfully");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("rActionBTN_XPATH"))).click();

        Thread.sleep(2000);
        WebElement elementz = driver.findElement(By.xpath(Utility.fetchLocator("rUnsuspend_XPATH")));
        JavascriptExecutor jsz = (JavascriptExecutor) driver;
        jsz.executeScript("arguments[0].click();", elementz);

        driver.switchTo().alert().accept();
        test.log(Status.PASS, "Reason for Refund was Unsuspended successfully");

        System.out.println("********************SUSPEND UNSUSPEND REASON FOR REFUND********************");
        driver.quit();
    }
}
