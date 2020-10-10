package com.Module.Account;

import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.utility.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DownloadStatementOFAccount extends TestBase {
    @Test
    public void DOWNLOAD_STATEMENT_OF_ACCOUNT() throws IOException, InterruptedException {
        test = extent.createTest("DOWNLOAD STATEMENT OF ACCOUNT");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        Login login = new Login(driver);
        API_Watch_Service api_watch_service = new API_Watch_Service();
        ScreenShot screenShot = new ScreenShot(driver);

        login.Login();
        test.log(Status.PASS, "Login Was Successful");

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        //CUSTOMER MANAGEMENT BUTTON
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Customermanagmentbtn_XPATH"))).click();
        test.log(Status.PASS, "Customer Management button fully Functionsl");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SelectCustomerbtn_XPATH"))).click();
        screenShot.ScreenShot();

        //SELECT ACTION
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("ActionSuspend_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        WebElement elementq = driver.findElement(By.xpath(Utility.fetchLocator("VIEWCustomer_XPATH")));
        JavascriptExecutor jsq = (JavascriptExecutor) driver;
        jsq.executeScript("arguments[0].click();", elementq);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ViewStatementOfAccount_XPATH"))).click();
        screenShot.ScreenShot();

        Thread.sleep(2000);
        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("AssertstatmentOfAccount_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("Statement of Account")) {
            test.log(Status.PASS, "Statement Of account can be Viewed");
        } else {
            test.log(Status.FAIL, "Statement of account cant be viewedd");
        }

        WebElement tt = driver.findElement(By.xpath(Utility.fetchLocator("FilterDateFrom_XPATH")));
        tt.clear();
        tt.sendKeys(Utility.fetchLocator("Datefrom_TEXT"));

        WebElement ttv = driver.findElement(By.xpath(Utility.fetchLocator("FilterDateto_XPATH")));
        ttv.clear();
        ttv.sendKeys(Utility.fetchLocator("Dateto_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("FilterfilterBTN_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ti11z = driver.findElement(By.xpath(Utility.fetchLocator("dOWNLOADSttatementOfAccount_XPATH")));
        JavascriptExecutor jsez = (JavascriptExecutor) driver;
        jsez.executeScript("arguments[0].scrollIntoView();", ti11z);
        ti11z.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("DownloadAsPDF_XPATH"))).click();

        screenShot.ScreenShot();
        test.log(Status.PASS, "Download as PDF was Successful");

        driver.navigate().back();

        Thread.sleep(2000);
        WebElement ti11zz = driver.findElement(By.xpath(Utility.fetchLocator("dOWNLOADSttatementOfAccount_XPATH")));
        JavascriptExecutor jsezz = (JavascriptExecutor) driver;
        jsezz.executeScript("arguments[0].scrollIntoView();", ti11zz);
        ti11zz.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("DownloadAsSpreadSheet_XPATH"))).click();

        api_watch_service.ApiWatchService();
        test.log(Status.PASS, "Download as SpreadSheet was Successful");

        System.out.println("**************************DOWNLOAD STATEMENT OF ACCOUNT*********************************");
        driver.quit();
    }
}
