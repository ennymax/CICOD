package com.Module.ValueChain;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class BuyersInsight extends TestBase {

    @Test
    public void BUYERS_INSIGHT() throws IOException, InterruptedException {
        test = extent.createTest("BUYERS INSIGHT");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        Login login = new Login(driver);
        SecureRandom rn = new SecureRandom();
        int st = rn.nextInt(1000000) + 1;

        login.Login();
        test.log(Status.PASS, "Login Was Successful");

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        //CUSTOMER MANAGEMENT BUTTON
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Customermanagmentbtn_XPATH"))).click();
        test.log(Status.PASS, "Customer Management button fully Functional");

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("ValuechainBTN_XPATH"))).click();

        Thread.sleep(1400);
        driver.findElement(By.xpath(Utility.fetchLocator("ValuechainByers_XPATH"))).click();

        Thread.sleep(1400);
        driver.findElement(By.xpath(Utility.fetchLocator("BuyerActionBTN_XPATH"))).click();

        Thread.sleep(1400);
        driver.findElement(By.xpath(Utility.fetchLocator("ProductAvailableForBuy_XPATH"))).click();

        Thread.sleep(1000);
        WebElement msgoo =(new WebDriverWait(driver, 45)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertProductCode_XPATH"))));
        String textoo = msgoo.getText();
        if (msgoo.isEnabled() && textoo.contains("T74623454")) {
            test.log(Status.PASS, "Products Of the Supplier Is Displayed and Enabled");
        } else {
            test.log(Status.FAIL, "Product Of Buyers is not displayed and enabled");
        }

        Thread.sleep(2000);
        driver.navigate().back();

        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("BuyerActionBTN_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        Thread.sleep(1400);
        driver.findElement(By.xpath(Utility.fetchLocator("BuyerOrderHistory_XPATH"))).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath(Utility.fetchLocator("ClickAnOrderHistry_XPATH"))).click();

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("SendConfirmationOrder_XPATH"))).click();

        Thread.sleep(1000);
        WebElement msgoom =(new WebDriverWait(driver, 12)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertSendConfirmationID_XPATH"))));
        String textoom = msgoom.getText();
        if (msgoom.isEnabled() && textoom.contains("Order confirmation sent")) {
            test.log(Status.PASS, "Confirmation Email was Sent");
        } else {
            test.log(Status.FAIL, "Failed to Send Confirmation Email");
        }

        Thread.sleep(2000);
        driver.navigate().back();

        Thread.sleep(2000);
        driver.navigate().back();

        Thread.sleep(2000);
        WebElement ti11h = driver.findElement(By.xpath(Utility.fetchLocator("BuyerActionBTN_XPATH")));
        JavascriptExecutor jseh = (JavascriptExecutor) driver;
        jseh.executeScript("arguments[0].scrollIntoView();", ti11h);
        ti11h.click();

        Thread.sleep(1400);
        driver.findElement(By.xpath(Utility.fetchLocator("UpdateProduct_XPATH"))).click();

        //Testing back BTN
        Thread.sleep(1400);
        driver.findElement(By.xpath(Utility.fetchLocator("BackBTN_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ti11m = driver.findElement(By.xpath(Utility.fetchLocator("BuyerActionBTN_XPATH")));
        JavascriptExecutor jsem = (JavascriptExecutor) driver;
        jsem.executeScript("arguments[0].scrollIntoView();", ti11m);
        ti11m.click();

        Thread.sleep(1400);
        driver.findElement(By.xpath(Utility.fetchLocator("UpdateProduct_XPATH"))).click();

        Thread.sleep(1400);
        driver.findElement(By.xpath(Utility.fetchLocator("UpdateProductAccessBTN_XPATH"))).click();

        Thread.sleep(1400);
        driver.findElement(By.xpath(Utility.fetchLocator("ConfirmProductAccess_XPATH"))).click();

        Thread.sleep(1000);
        WebElement msgoomm =(new WebDriverWait(driver, 12)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertProductUpdate_XPATH"))));
        String textoomm = msgoomm.getText();
        if (msgoomm.isEnabled() && textoomm.contains("Updated Successfully")) {
            test.log(Status.PASS, "Product Update was Successful");
        } else {
            test.log(Status.FAIL, "Product Update Failed");
        }

        System.out.println("********************BUYERS INSIGHT********************");
        driver.quit();
    }
}
