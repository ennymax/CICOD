package com.Module.Settings;

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

public class ReasonForRefund extends TestBase {

    @Test
    public void REASON_FOR_REFUND() throws IOException, InterruptedException {
        test = extent.createTest("REASON FOR REFUND");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        ScreenShot screenShot = new ScreenShot(driver);
        Login login = new Login(driver);
        Randomstuff randomstuff = new Randomstuff();

        login.Login();
        test.log(Status.PASS, "Login Was Successful");

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Settings_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SystemSettings_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("ReasonforRedund_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CreateNewReason_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("EnterReason4Refund_XPATH"))).sendKeys(Utility.fetchLocator("dec_TEXT"));

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("CreteR_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(1000);
        screenShot.ScreenShotFullPage();
        WebElement msg11f = driver.findElement(By.xpath(Utility.fetchLocator("as_XPATH")));
        String text11f = msg11f.getText();
        if (msg11f.isEnabled() && text11f.contains("Reason created successfully")) {
            test.log(Status.PASS, "Reason for refund was created successfully");
        } else {
            test.log(Status.FAIL, "Reason for refund wasn't created");
        }

        System.out.println("********************REASON FOR REFUND********************");
        driver.quit();
    }
}
