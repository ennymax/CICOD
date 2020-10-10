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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class CreateOfferSettings extends TestBase {
    @Test
    public void CREATE_OFFER_SETTINGS() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("CREATE OFFER SETTINGS");
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

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("AddProductOfferBTN_XPATH")))).click();

        Thread.sleep(2000);
        WebElement ele11 = driver.findElement(By.xpath(Utility.fetchLocator("Promotype_XPATH")));
        Select sel1 = new Select(ele11);
        sel1.selectByIndex(0);

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("TargetTotalValue_XPATH")))).sendKeys("5");

        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("SelectProduct_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByIndex(st);

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("OfferOfTargetVlue_XPATH")))).sendKeys(Utility.fetchLocator("Price_TEXT"));

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("SaveOffer_XPATH")))).click();

        Thread.sleep(2000);
        WebElement msg1 = driver.findElement(By.xpath(Utility.fetchLocator("m_XPATH")));
        String text1 = msg1.getText();
        if (msg1.isEnabled() && text1.contains("Created")) {
            test.log(Status.PASS, "Offer settings Created");
        } else {
            test.log(Status.FAIL, "Offer settings not Created");
        }

        System.out.println("********************CREATE OFFERS SETTINGS*******************");
        driver.quit();
    }
}
