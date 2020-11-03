package CICOD.ModuleCOM.CustomerManagment;

import CICOD.base.TestBase;
import CICOD.utility.Login;
import CICOD.utility.ScreenShot;
import CICOD.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class Lodgment extends TestBase {
    @Test
    public void Update_lODGMENT() throws IOException, InterruptedException {
        test = extent.createTest("UPDATE LODGMENT");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);
        SecureRandom rn = new SecureRandom();
        int st = rn.nextInt(1000000) + 1;

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

        Thread.sleep(2000);
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
        Actions builder = new Actions(driver);
        WebElement element1 = driver.findElement(By.xpath(Utility.fetchLocator("Lodg_XPATH")));
        builder.moveToElement(element1).build().perform();

        if (driver.findElements(By.xpath(Utility.fetchLocator("UpateLodgenebt_XPATH"))).size() != 0) {
            Thread.sleep(2000);
            driver.findElement(By.xpath(Utility.fetchLocator("UpateLodgenebt_XPATH"))).click();
            Thread.sleep(2000);
            WebElement fg = driver.findElement(By.xpath(Utility.fetchLocator("Up_XPATH")));
            fg.clear();
            fg.sendKeys("1000000");

            Thread.sleep(2000);
            driver.findElement(By.xpath(Utility.fetchLocator("UpdateBTNLOdgement_XPATH"))).click();

            Thread.sleep(100);
            assertEquals("×\n" + "N1,000,000.00 successfully updated on customer account", driver.findElement(By.xpath(Utility.fetchLocator("AssertLodgment_XPATH"))).getText());
            test.log(Status.PASS, "Update Lodgement was successful");

            Thread.sleep(200);
            screenshot.ScreenShotFullPage();
        }

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ADDLOG_XPATH"))).click();

        Thread.sleep(2000);
        WebElement fg = driver.findElement(By.xpath(Utility.fetchLocator("LodgementAmount_XPATH")));
        fg.clear();
        fg.sendKeys(Utility.fetchLocator("aaaa_XPATH") + st);

        Thread.sleep(2000);
        WebElement fgg = driver.findElement(By.xpath(Utility.fetchLocator("EnterDate_XPATH")));
        fgg.click();
        fgg.clear();
        fgg.sendKeys(Utility.fetchLocator("Dateto_TEXT"));

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("SaveLodgement_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("ClosePendingOrder_XPATH")))).click();

        Thread.sleep(2000);
        screenshot.ScreenShotFullPage();
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertLogement_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Lodgement was made");
        } else {
            test.log(Status.FAIL, "Lodgement Failed");
        }

        System.out.println("********************UPDATE LODGEMENT********************");
        driver.quit();
    }
}
