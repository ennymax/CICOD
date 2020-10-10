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

public class CreditHistory extends TestBase {
    @Test
    public void CREDIT_HISTORY() throws IOException, InterruptedException {
        test = extent.createTest("CREDIT HISTORY");
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
        test.log(Status.PASS, "Customer Management button fully Functional");

        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("CreditLimi_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        Thread.sleep(1200);
        screenshot.ScreenShotFullPage();
        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("AssertViewCreditLimi_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("Credit Limit")) {
            test.log(Status.PASS, "Credit Limit can Be Viewed");
        } else {
            test.log(Status.FAIL, "Credit Limit cant be viewed");
        }

        System.out.println("********************CREDIT HISTORY CUSTOMER********************");
        driver.quit();
    }
}
