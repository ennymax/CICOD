package com.Module.CustomerManagment;

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
import java.util.concurrent.TimeUnit;

public class UpdateCustomer extends TestBase {

    @Test
    public void UPDATE_CUSTOMER() throws IOException, InterruptedException {
        test = extent.createTest("UPDATE CUSTOMER");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);
        Randomstuff randomstuff = new Randomstuff();

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
        screenshot.ScreenShot();

        //SELECT ACTION
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("ActionSuspend_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        WebElement elementq = driver.findElement(By.xpath(Utility.fetchLocator("UpdateCustoo_XPATH")));
        JavascriptExecutor jsq = (JavascriptExecutor) driver;
        jsq.executeScript("arguments[0].click();", elementq);

        Thread.sleep(2000);
        WebElement ch = driver.findElement(By.xpath(Utility.fetchLocator("FirstName_XPATH")));
        JavascriptExecutor jsex = (JavascriptExecutor) driver;
        jsex.executeScript("arguments[0].scrollIntoView();", ch);
        ch.clear();
        ch.sendKeys(randomstuff.ListRandom());

        WebElement tt = driver.findElement(By.xpath(Utility.fetchLocator("LastName_XPATH")));
        tt.clear();
        tt.sendKeys(randomstuff.ListRandom());

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SameAddressAsCustomer_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("ASS_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        Thread.sleep(2000);
        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("cccg_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("Customer updated")) {
            test.log(Status.PASS, "Customer Updated Successfully");
        } else {
            test.log(Status.FAIL, "Customer Update failed");
        }

        System.out.println("********************UPDATE CUSTOMER********************");
        driver.quit();
    }

}
