package CICOD.ModuleCOM.Account;

import CICOD.base.TestBase;
import CICOD.utility.FileUpload;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class ViewCreditNote extends TestBase {
    @Test
    public void View_Credit_Note() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("View Credit Note");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);
        SecureRandom rn = new SecureRandom();
        int a = rn.nextInt(60000) + 1;
        int aa = rn.nextInt(60000) + 1;
        FileUpload fileUpload = new FileUpload();

        login.Login();
        test.log(Status.PASS, "Login Was Successful");

        //Com
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("AccountBTN_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("CreditNote_XPATH")))).click();


        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("cAction_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("CView_XPATH"))).click();

        Thread.sleep(2000);
        assertEquals("Credit Note", driver.findElement(By.xpath(Utility.fetchLocator("AssertViewCrerditNote_XPATH"))).getText());
        test.log(Status.PASS, "Credit Note can be Viewed");

        Thread.sleep(2000);
        screenshot.ScreenShotFullPage();

        System.out.println("**************************View Credit Note*********************************");
        driver.quit();
    }
}
