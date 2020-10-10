package com.Module.Administration;

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

public class UPDATE_ROLE extends TestBase {

    @Test
    public void UPDATE_ROLE() throws IOException, InterruptedException {
        test = extent.createTest("UPDATE ROLE");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        Login login = new Login(driver);
        ScreenShot screenShot = new ScreenShot(driver);

        login.Login();
        test.log(Status.PASS, "Login Was Successful");

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Adminbtn_XPATH"))).click();
        test.log(Status.PASS, "Administration button Fully functional");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Rolemanagementbtn_XPATH"))).click();
        test.log(Status.PASS, "Role button fully Functional ");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("RoleActionbtn_XPATH"))).click();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("RoleUpdatebtn_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SaveRoleBTN_XPATH"))).click();

        Thread.sleep(2000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("assertUpdateRole_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Role was successfully Updated");
        } else {
            test.log(Status.FAIL, "Role cant be update");
        }

        Thread.sleep(4000);
        screenShot.ScreenShotFullPage();

        System.out.println("********************UPDATE ROLE TEST IS COMPLETED********************");
        driver.quit();
    }
}
