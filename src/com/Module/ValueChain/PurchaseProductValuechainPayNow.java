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
import org.testng.annotations.Test;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;
import static org.testng.AssertJUnit.assertEquals;

public class PurchaseProductValuechainPayNow extends TestBase {
    @Test
    public void PURCHASE_PRODUCT_VIA_VALUE_CHAIN_PAYNOW() throws IOException, InterruptedException {

        test = extent.createTest("PURCHASE PRODUCT VIA VALUE CHAIN PAY NOW");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);
        BrokenLink brokenLink = new BrokenLink(driver);
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);
        SecureRandom rn = new SecureRandom();
        int st = rn.nextInt(1000000) + 1;
        RavePay ravePay = new RavePay(driver);

        login.LoginDefault();
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
        driver.findElement(By.xpath(Utility.fetchLocator("Suppliers_XPATH"))).click();

        Thread.sleep(1000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("BuyerActionBTN_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("SuppliersProduct_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("CreateOrderfromSuppler_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("ProductCategoryPlus_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("SelectBeverages_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ti11l = driver.findElement(By.xpath(Utility.fetchLocator("mdd_XPATH")));
        JavascriptExecutor jsel = (JavascriptExecutor) driver;
        jsel.executeScript("arguments[0].scrollIntoView();", ti11l);

        WebElement ti112 = driver.findElement(By.xpath(Utility.fetchLocator("MakePayment_XPATH")));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView();", ti112);
        ti112.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayOnline_XPATH"))).click();
        test.log(Status.PASS, "PayOnline Button is displayed and enabled");

        Thread.sleep(7000);
        driver.switchTo().frame(0);

        Thread.sleep(7000);
        System.out.println(driver.findElement(By.id("option-payment-amount-xs")).getText());
        assertEquals("NGN609.00", driver.findElement(By.id("option-payment-amount-xs")).getText());
        test.log(Status.PASS, "PayOnline Was Successful");

        Thread.sleep(2000);
        screenshot.ScreenShotFullPage();
        test.log(Status.INFO, "MAKE PAYMENT WITH POS");

        Thread.sleep(2000);
        driver.get("https://emaxkemiyop.cicod.com/cuorma/web/value-chain/order?id=10147");

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("ProductCategoryPlus_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("SelectBeverages_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("AddProduct_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ti11lxx = driver.findElement(By.xpath(Utility.fetchLocator("mdd_XPATH")));
        JavascriptExecutor jselxx = (JavascriptExecutor) driver;
        jselxx.executeScript("arguments[0].scrollIntoView();", ti11lxx);

        WebElement ti112aa = driver.findElement(By.xpath(Utility.fetchLocator("MakePayment_XPATH")));
        JavascriptExecutor jse2aa = (JavascriptExecutor) driver;
        jse2aa.executeScript("arguments[0].scrollIntoView();", ti112aa);
        ti112aa.click();

        Thread.sleep(2000);
        WebElement ti112ll = driver.findElement(By.xpath(Utility.fetchLocator("POS_XPATH")));
        JavascriptExecutor jse2ll = (JavascriptExecutor) driver;
        jse2ll.executeScript("arguments[0].scrollIntoView();", ti112ll);
        ti112ll.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ConfirmPAymantPOS_XPATH"))).click();
        test.log(Status.PASS, "Payment Via POS Successful");

        System.out.println("********************PURCHASE PRODUCT VIA VALUE CHAIN PAY NOW********************");
        driver.quit();
    }
}
