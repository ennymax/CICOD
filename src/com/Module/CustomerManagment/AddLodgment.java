package com.Module.CustomerManagment;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.Login;
import com.utility.ScreenShot;
import com.utility.Utility;
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

public class AddLodgment extends TestBase {
    @Test
    public void ADD_lODGMENT() throws IOException, InterruptedException {
        test = extent.createTest("ADD LODGMENT");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        ScreenShot screenshot = new ScreenShot(driver);
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
        screenshot.ScreenShot();
        driver.findElement(By.xpath(Utility.fetchLocator("Customermanagmentbtn_XPATH"))).click();
        test.log(Status.PASS, "Customer Management button fully Functionsl");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SelectCustomerbtn_XPATH"))).click();

        //SELECT ACTION
        Thread.sleep(2000);
        screenshot.ScreenShot();
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("ActionSuspend_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        WebElement elementq = driver.findElement(By.xpath(Utility.fetchLocator("VIEWCustomer_XPATH")));
        JavascriptExecutor jsq = (JavascriptExecutor) driver;
        jsq.executeScript("arguments[0].click();", elementq);

        Thread.sleep(2000);
        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("AssertViewCustomer_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("View Customer")) {
            test.log(Status.PASS, "Customer can Be Viewed");
        } else {
            test.log(Status.FAIL, "Customer cant be viewed");
        }

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("AddLodgement_XPATH")))).click();

        Thread.sleep(2000);
        WebElement fg = driver.findElement(By.xpath(Utility.fetchLocator("LodgementAmount_XPATH")));
        fg.clear();
        fg.sendKeys(Utility.fetchLocator("aaaa_XPATH") + st);

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("SaveLodgement_XPATH")))).click();

        Thread.sleep(2000);
        WebElement msg11l = driver.findElement(By.xpath(Utility.fetchLocator("AssertPendingOrders_XPATH")));
        String text11l = msg11l.getText();
        if (msg11l.isEnabled() && text11l.contains("Pending Orders")) {
            test.log(Status.PASS, "Pending Order Was Displayed After Making Lodgement");
        } else {
            test.log(Status.FAIL, "Pending Order Wasn't Displayed After Making Lodgement");
        }

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("ClosePendingPayemtAfterLodgement_XPATH")))).click();

        Thread.sleep(2000);
        screenshot.ScreenShotFullPage();
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertLogement_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Lodgement was made");
        } else {
            test.log(Status.FAIL, "Lodgement Failed");
        }

        System.out.println("********************ADD LODGEMENT********************");
        driver.quit();
    }
}
