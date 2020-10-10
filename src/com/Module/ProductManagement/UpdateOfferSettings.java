package com.Module.ProductManagement;

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
import java.awt.*;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class UpdateOfferSettings extends TestBase {

    @Test
    public void Update_Offer_settings() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("Update Offer settings");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        Login login = new Login(driver);
        FileUpload fileUpload = new FileUpload();
        Randomstuff randomstuff = new Randomstuff();
        SecureRandom rn = new SecureRandom();
        int st = rn.nextInt(9) + 1;

        login.Login();
        test.log(Status.PASS, "Login Was Successful");

        //Com
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        //product Management
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ProductManagementbtn_XPATH"))).click();
        test.log(Status.PASS, "Product Management button fully functional");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("OffersBTN_XPATH"))).click();

        WebElement ti = driver.findElement(By.xpath(Utility.fetchLocator("AssertOfferList_XPATH")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ti);

        driver.findElement(By.xpath(Utility.fetchLocator("OfferActionBTN_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("UpdateBTN_XPAH"))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("OfferOfTargetVlue_XPATH")))).sendKeys(Utility.fetchLocator("Price_TEXT"));

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("SaveOffer_XPATH")))).click();

        WebElement msg1 = driver.findElement(By.xpath(Utility.fetchLocator("AssertOfferList_XPATH")));
        String text1 = msg1.getText();
        if (msg1.isEnabled() && text1.contains("Updated")) {
            test.log(Status.PASS, "Offer settings Update");
        } else {
            test.log(Status.FAIL, "Offer settings not Update");
        }

        System.out.println("********************Update Offer settings*******************");
        driver.quit();
    }
}
