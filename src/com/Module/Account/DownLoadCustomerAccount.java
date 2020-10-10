package com.Module.Account;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DownLoadCustomerAccount extends TestBase {
    @Test
    public void DOWNLOAD_CUSTOMER_ACCOUNT() throws IOException, InterruptedException {
        test = extent.createTest("DOWNLOAD CUSTOMER ACCOUNT");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        Login login = new Login(driver);
        API_Watch_Service api_watch_service = new API_Watch_Service();

        login.Login();
        test.log(Status.PASS, "Login Was Successful");

        //Com
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("AccountBTN_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("CustomerAccount_XPATH")))).click();

        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertValueOfAccountInCredit_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Value of Account in Debit is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Value of Account in Debit is not displayed and enabled");
        }

        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertValueOfAccountInCredit_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Value of Account in Credit is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Value of Account in Credit is not displayed and enabled");
        }

        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("DownloadCustomerAccount_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        api_watch_service.ApiWatchService();

        System.out.println("**************************DOWNLOAD CUSTOMER ACCOUNT*********************************");
        driver.quit();
    }
}
