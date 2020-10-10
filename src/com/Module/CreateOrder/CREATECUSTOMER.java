package com.Module.CreateOrder;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class CREATECUSTOMER extends TestBase {

    @Test
    public void CREATE_CUSTOMER() throws IOException, InterruptedException {
        test = extent.createTest("CREATE CUSTOMER");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);
        Randomstuff randomstuff =new Randomstuff();
        SecureRandom rn = new SecureRandom();
        int st = rn.nextInt(1000000) + 1;

        login.Login();
        test.log(Status.PASS, "Login Was Successful");

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        //CREATE ORDER BUTTON
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Createorderbtn_XPATH"))).click();

        Thread.sleep(2000);
        screenshot.ScreenShotFullPage();
        driver.findElement(By.xpath(Utility.fetchLocator("Newcustomerbtn_XPATH"))).click();

        //NEW CUSTOMER FORM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("FirstName_XPATH"))).sendKeys(randomstuff.ListRandom());

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("LastName_XPATH"))).sendKeys(randomstuff.ListRandom());

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CustomerCode_XPATH"))).sendKeys("12" + st);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CustomerEmail_XPATH"))).sendKeys(randomstuff.ListRandom() +"@gmail.com");

       Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PhoneNumber_XPATH"))).sendKeys(Utility.fetchLocator("CustomerPhoneNumber_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("HouseNumber_XPATH"))).sendKeys(Utility.fetchLocator("CustomerHouseNo_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Street_XPATH"))).sendKeys(Utility.fetchLocator("CustomerStreet_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("LandMark_XPATH"))).sendKeys(Utility.fetchLocator("CustomerLandMark_TEXT"));

        Thread.sleep(1500);
        WebElement ele11 = driver.findElement(By.xpath(Utility.fetchLocator("CustomerCountry_XPATH")));
        Select sel1 = new Select(ele11);
        sel1.selectByIndex(3);

        Thread.sleep(1500);
        screenshot.ScreenShotFullPage();
        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("CustomerState_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByIndex(25);

        Thread.sleep(1500);
        WebElement ele112 = driver.findElement(By.xpath(Utility.fetchLocator("CustomerLGA_XPATH")));
        Select sel12 = new Select(ele112);
        sel12.selectByIndex(15);

        Thread.sleep(2000);
        screenshot.ScreenShotFullPage();
        driver.findElement(By.xpath(Utility.fetchLocator("SameAddressAsCustomer_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CustomerSavebtn_XPATH"))).click();

        Thread.sleep(2000);
        screenshot.ScreenShotFullPage();
        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("AssertCustomerCreation_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("Customer added")) {
            test.log(Status.PASS, "Customer was Created Successfully");
        } else {
            test.log(Status.FAIL, "Failed to create Customer");
        }
        System.out.println("********************CREATE CUSTOMER********************");
        driver.quit();
    }
}
