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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.security.SecureRandom;

public class CreateProductSpecificSpend extends TestBase {
    @Test
    public void CREATE_PRODUCT_SPECIFIC_SPEND() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("CREATE PRODUCT SPECIFIC SPEND");
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
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("CreateProductSpecificSpendBTN_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("CreateProductSpe_XPATH")))).click();


        Thread.sleep(2000);
        WebElement element11p = driver.findElement(By.xpath(Utility.fetchLocator("cd_XPATH")));
        Actions actionp = new Actions(driver);
        element11p.click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("Danny_XPATH")))).sendKeys("may");

        Robot r = new Robot();

        Thread.sleep(2000);
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyPress(KeyEvent.VK_ENTER);

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("A_XPATH")))).sendKeys(Utility.fetchLocator("Amount_TEXT"));

        Thread.sleep(2000);
        WebElement K = (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.name("ProductSpecificSpend[point]")));
        K.clear();
        K.sendKeys(Utility.fetchLocator("Empty_TEXT") + st);

        Thread.sleep(2000);
        WebElement ele11 = driver.findElement(By.xpath(Utility.fetchLocator("Period_XPATH")));
        Select sel1 = new Select(ele11);
        sel1.selectByIndex(1);

        Thread.sleep(2000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("SaveCreateProductSpecificSpend_XPATH")))).click();

        System.out.println("No Alert When Creating Product Specific Spend");
        Thread.sleep(2000);

        System.out.println("********************CREATE PRODUCT SPECIFIC SPEND********************");
        driver.quit();
    }
}
