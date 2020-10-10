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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class CREATEDELIVERYRATE extends TestBase {
    @Test
    public void DELIVERY_RATE_CARD_SETUP() throws IOException, InterruptedException {
        test = extent.createTest("CREATE DELIVERY RATE CARD SETUP");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);
        SecureRandom rn = new SecureRandom();
        int stt = rn.nextInt(34) + 1;
        int sttt = rn.nextInt(7) + 1;
        Randomstuff randomstuff = new Randomstuff();

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

        Thread.sleep(1700);
        driver.findElement(By.xpath(Utility.fetchLocator("DelAdd_XPATH"))).click();

        Thread.sleep(1000);
        screenshot.ScreenShot();
        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("marchantLocation_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByIndex(1);

        Thread.sleep(1000);
        WebElement ele11 = driver.findElement(By.xpath(Utility.fetchLocator("SelectCountry_XPATH")));
        Select sel1 = new Select(ele11);
        sel1.selectByIndex(3);

        Thread.sleep(1000);
        WebElement ele111j = driver.findElement(By.xpath(Utility.fetchLocator("MarchantState_XPATH")));
        Select sel11j = new Select(ele111j);
        sel11j.selectByIndex(stt);

        Thread.sleep(1000);
        WebElement ele111c = driver.findElement(By.xpath(Utility.fetchLocator("MarchantLGA_XPATH")));
        Select sel11c = new Select(ele111c);
        sel11c.selectByIndex(sttt);

        driver.findElement(By.xpath(Utility.fetchLocator("MiniDeliveryCharge_XPATH"))).sendKeys(Utility.fetchLocator("h_TEXT") + randomstuff.RandomNumbers());
        driver.findElement(By.xpath(Utility.fetchLocator("PercentDeliveryRate_XPATH"))).sendKeys(Utility.fetchLocator("PercentageDeliveryCharge_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("FreeDeliveryPrice_XPATH"))).sendKeys(Utility.fetchLocator("FreeeDeliveryPrice_TEXT"));

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("DeliverySavebtn_XPATH"))).click();

        Thread.sleep(1500);
        screenshot.ScreenShotFullPage();
        WebElement msg11f = driver.findElement(By.xpath(Utility.fetchLocator("as_XPATH")));
        String text11f = msg11f.getText();
        if (msg11f.isEnabled() && text11f.contains("Delivery Rate Card created successfully")) {
            test.log(Status.PASS, "Delivery Rate Card was Created");
        } else {
            test.log(Status.FAIL, "Delivery Rate Card wasn't Created");
        }

        System.out.println("********************DELIVERY RATE CARD SETUP TEST IS COMPLETED********************");
        driver.quit();
    }
}
