package com.Module.Account;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.FileUpload;
import com.utility.Login;
import com.utility.ScreenShot;
import com.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class CreateCreditNote extends TestBase {
    @Test
    public void Create_Credit_Note() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("Create Credit Note");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);
        SecureRandom rn = new SecureRandom();
        int a = rn.nextInt(60000) + 1;
        int aa = rn.nextInt(60000) + 1;
        FileUpload fileUpload = new FileUpload();

        login.Login();
        test.log(Status.PASS, "Login Was Successful");

        //Com
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("AccountBTN_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("CreditNote_XPATH")))).click();


        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("CreateCreditNote_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();


        Thread.sleep(2000);
        WebElement element11p = driver.findElement(By.xpath(Utility.fetchLocator("CCustomer_XPATH")));
        element11p.click();
        Actions actionp = new Actions(driver);
        actionp.moveToElement(element11p).doubleClick().perform();

        Robot r = new Robot();
        String text =  "Tope";
        StringSelection stringSelection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);

        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_CONTROL);

        Thread.sleep(2000);
        r.keyPress(KeyEvent.VK_ENTER);

        Thread.sleep(1000);
        WebElement ele111j = driver.findElement(By.xpath(Utility.fetchLocator("cReason_XPATH")));
        Select sel11j = new Select(ele111j);
        sel11j.selectByIndex(2);

        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("InvoiceNum_XPATH"))).sendKeys(Utility.fetchLocator("h_TEXT") + aa );

        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("Quant_XPATH"))).sendKeys("2000");

        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("Amount_XPATH"))).sendKeys(Utility.fetchLocator("h_TEXT") + a );

        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("Cdes_XPATH"))).sendKeys("Testing Credit note");

        Thread.sleep(2000);
        WebElement ti11s = driver.findElement(By.xpath("//input[@type='file']"));
        JavascriptExecutor jses = (JavascriptExecutor) driver;
        jses.executeScript("arguments[0].scrollIntoView();", ti11s);

        Thread.sleep(2000);
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.xpath("//input[@type='file']"))).click().build().perform();

        Thread.sleep(4000);
        fileUpload.UploadFileImage3MB();
        test.log(Status.PASS, "Attach Image for Credit Note was Successful");

        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("Senddd_XPATH"))).click();

        Thread.sleep(2000);
        assertEquals("×\n" + "Credit note created successfully", driver.findElement(By.xpath(Utility.fetchLocator("AssertBanner_XPATH"))).getText());
        test.log(Status.PASS, "Credit Note was Created");

        System.out.println("**************************Create Credit Note*********************************");
        driver.quit();
    }
}
