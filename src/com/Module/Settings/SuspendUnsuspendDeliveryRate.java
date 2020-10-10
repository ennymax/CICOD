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
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;


public class SuspendUnsuspendDeliveryRate extends TestBase {
    @Test
    public void DELIVERY_RATE_CARD_SETUP() throws IOException, InterruptedException {
        test = extent.createTest("SUSPEND UNSUSPEND DELIVERY RATE");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        Login login = new Login(driver);
        Randomstuff randomstuff = new Randomstuff();
        ScreenShot screenShot = new ScreenShot(driver);

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
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("DeliveryRatebtn_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("delveryRateActionBNT_XPATH"))).click();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("SuspendDe_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(1400);
        driver.switchTo().alert().accept();
        test.log(Status.PASS, "suspend Delivery Rate was successful");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("delveryRateActionBNT_XPATH"))).click();

        Thread.sleep(2000);
        WebElement elementz = driver.findElement(By.xpath(Utility.fetchLocator("UnsuspendDe_XPATH")));
        JavascriptExecutor jsz = (JavascriptExecutor) driver;
        jsz.executeScript("arguments[0].click();", elementz);

        driver.switchTo().alert().accept();
        test.log(Status.PASS, "Unsuspend Delivery Rate Successful");

        Thread.sleep(2000);
        screenShot.ScreenShotFullPage();

        System.out.println("********************SUSPEND UNSUSPEND DELIVERY RATE********************");
        driver.quit();
    }
}
