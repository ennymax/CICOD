package com.Module.Account;

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

public class ViewStatementOfAccount extends TestBase {

    @Test
    public void VIEW_STATEMENTOFACCOUNT() throws IOException, InterruptedException {
        test = extent.createTest("VIEW STATEMENT OF ACCOUNT");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        ScreenShot screenShot = new ScreenShot(driver);
        Login login = new Login(driver);

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

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertTotalnumberoftransaction_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Total number of transaction is displayed and Enabled");
        } else {
            test.log(Status.FAIL, "Total numbers of Transactions is no displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertTotalAomunt_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Total amount of customer is Displayed and enabled");
        } else {
            test.log(Status.FAIL, "Total Amount of customer is not displayed and enabled");
        }

        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("SendEmailtoCustomer_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        Thread.sleep(2000);
        WebElement msg111 = driver.findElement(By.xpath(Utility.fetchLocator("AssertSendEmail_XPATH")));
        String text111 = msg111.getText();
        if (msg111.isEnabled() && text111.contains("Statement of account sent to customer successfully.")) {
            test.log(Status.PASS, "Send Statement Of Account fully functional");
        } else {
            test.log(Status.FAIL, "Send Statement of account not fully Functional");
        }

        System.out.println("**************************VIEW STATEMENT OF ACCOUNT*********************************");
        driver.quit();
    }
}
