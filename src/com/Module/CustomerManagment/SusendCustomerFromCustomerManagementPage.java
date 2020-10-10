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
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SusendCustomerFromCustomerManagementPage extends TestBase {
    @Test
    public void SUSPEND_UNSUSPEND_CUSTOMER_FROM_CUSTOMER_MANAGEMENT_PAGE() throws IOException, InterruptedException {
        test = extent.createTest("SUSPEND UNSUSPEND CUSTOMER FROM CUSTOMER MANAGEMENT PAGE");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);

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
        WebElement elementqj = driver.findElement(By.xpath(Utility.fetchLocator("SuspendFromCustomerPage_XPATH")));
        JavascriptExecutor jsqj = (JavascriptExecutor) driver;
        jsqj.executeScript("arguments[0].click();", elementqj);

        login.AcceptAlert();

        Thread.sleep(2000);
        test.log(Status.PASS, "Customer Suspended Successfully");

        Thread.sleep(2000);
        WebElement elementqll = driver.findElement(By.xpath(Utility.fetchLocator("UnsuspendfromCustomerPage_XPATH")));
        JavascriptExecutor jsqll = (JavascriptExecutor) driver;
        jsqll.executeScript("arguments[0].click();", elementqll);

        login.AcceptAlert();

        Thread.sleep(2000);
        test.log(Status.PASS, "Customer Unsuspended Successfully");

        Thread.sleep(2000);
        System.out.println("********************SUSPEND UNSUSPEND CUSTOMER FROM CUSTOMER MANAGEMENT PAGE********************");
        driver.quit();
    }
}
