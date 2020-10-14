package com.Module.CustomerManagment;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DownLoadCreditLimit extends TestBase {

    @Test
    public void DOWNLOAD_CREDIT_HISTORY() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("DOWNLOAD CREDIT HISTORY");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        Login login = new Login(driver);
        API_Watch_Service api_watch_service_c = new API_Watch_Service();

        login.Login();
        test.log(Status.PASS, "Login Was Successful");

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        //CUSTOMER MANAGEMENT BUTTON
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Customermanagmentbtn_XPATH"))).click();
        test.log(Status.PASS, "Customer Management button fully Functional");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CreditLimi_XPATH"))).click();

        WebElement k = driver.findElement(By.xpath(Utility.fetchLocator("AssertViewCreditLimi_XPATH")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", k);

        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("AssertViewCreditLimi_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("Credit Limit")) {
            test.log(Status.PASS, "Credit Limit can Be Viewed");
        } else {
            test.log(Status.FAIL, "Credit Limit cant be viewed");
        }

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("DownloadCreditHistory_XPATH"))).click();
        test.log(Status.PASS, "Download Credit Limit was Successful");

        System.out.println("********************DOWNLOAD CREDIT HISTORY********************");
        driver.quit();
    }
}
