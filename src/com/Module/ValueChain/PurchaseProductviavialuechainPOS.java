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

public class PurchaseProductviavialuechainPOS extends TestBase {
    @Test
    public void PURCHASE_PRODUCT_VIA_VALUE_CHAIN_POS() throws IOException, InterruptedException {

        test = extent.createTest("PURCHASE PRODUCT VIA VALUE CHAIN PAY POS");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);
        Login login = new Login(driver);
        SecureRandom rn = new SecureRandom();
        int st = rn.nextInt(1000000) + 1;
        RavePay ravePay = new RavePay(driver);
        ScreenShot screenShot = new ScreenShot(driver);

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

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ValuchainPay_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ti112 = driver.findElement(By.xpath(Utility.fetchLocator("POS_XPATH")));
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView();", ti112);
        ti112.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ConfirmPAymantPOS_XPATH"))).click();

        Thread.sleep(3000);
        screenShot.ScreenShotFullPage();

        System.out.println("********************PURCHASE PRODUCT VIA VALUE CHAIN POS********************");
        driver.quit();
    }
}
