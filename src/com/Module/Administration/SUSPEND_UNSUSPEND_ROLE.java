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

public class SUSPEND_UNSUSPEND_ROLE extends TestBase {

    @Test
    public void Suspend_Unsuspend_Role() throws IOException, InterruptedException {
        test = extent.createTest("SUSPEND UNSUSPEND ROLE");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        ScreenShot screenShot = new ScreenShot(driver);
        Login login = new Login(driver);

        login.Login();
        test.log(Status.PASS, "Login Was Successful");

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        Thread.sleep(2000);
        screenShot.ScreenShotFullPage();
        driver.findElement(By.xpath(Utility.fetchLocator("Adminbtn_XPATH"))).click();
        test.log(Status.PASS, "Administration button Fully functional");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Rolemanagementbtn_XPATH"))).click();
        test.log(Status.PASS, "Role button fully Functional ");

        WebElement t = driver.findElement(By.xpath(Utility.fetchLocator("SS_XPATH")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", t);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("RoleActionbtn_XPATH"))).click();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("suspend/unsuspendRole_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        driver.switchTo().alert().accept();

        WebElement msg11l = driver.findElement(By.xpath(Utility.fetchLocator("ComfirmPOSPayment_XPATH")));
        String text11l = msg11l.getText();
        if (msg11l.isEnabled() && text11l.contains("Role suspended")) {
            test.log(Status.PASS, "Role suspended Successfully");
        } else {
            test.log(Status.FAIL, "Role suspension failed");
        }

        WebElement ti = driver.findElement(By.xpath(Utility.fetchLocator("SS_XPATH")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ti);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("RoleActionbtn_XPATH"))).click();

        Thread.sleep(2000);
        WebElement element2 = driver.findElement(By.xpath(Utility.fetchLocator("suspend/unsuspendRole_XPATH")));
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].click();", element2);

        driver.switchTo().alert().accept();

        Thread.sleep(2000);
        WebElement msg11l1 = driver.findElement(By.xpath(Utility.fetchLocator("ComfirmPOSPayment_XPATH")));
        String text11l1 = msg11l1.getText();
        if (msg11l1.isEnabled() && text11l1.contains("Role unsuspended")) {
            test.log(Status.PASS, "Role Unsuspended Successfully");
        } else {
            test.log(Status.FAIL, "Role Unsuspension failed");
        }

        Thread.sleep(2000);
        System.out.println("********************SUSPEND UNSUSPEND ROLE TEST IS COMPLETED********************");
        driver.quit();
    }
}
