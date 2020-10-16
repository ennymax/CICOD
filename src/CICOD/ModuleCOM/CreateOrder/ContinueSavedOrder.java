package CICOD.ModuleCOM.CreateOrder;

import CICOD.base.TestBase;
import CICOD.utility.Login;
import CICOD.utility.RavePay;
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

import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class ContinueSavedOrder extends TestBase {
    @Test
    public void CONTINUE_SAVE_ORDER() throws IOException, InterruptedException {
        test = extent.createTest("CONTINUE SAVED ORDER");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        Login login = new Login(driver);
        RavePay ravePay = new RavePay(driver);
        SecureRandom rn = new SecureRandom();
        int st = rn.nextInt(3) + 1;

        login.Login();
        test.log(Status.PASS, "Login Was Successful");

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        //CREATE ORDER BUTTON
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Createorderbtn_XPATH"))).click();

        WebElement ti = driver.findElement(By.xpath(Utility.fetchLocator("SearchProductbtnq_XPATH")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ti);

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("ViewSavedOrder_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("SelectTheSavedOreder_XPATH")))).click();

        Thread.sleep(2000);
        WebElement msg1 = driver.findElement(By.xpath(Utility.fetchLocator("AssertSearchByProduct_XPATH")));
        String text1 = msg1.getText();
        if (msg1.isEnabled() && text1.contains("Product(s) added successfully")) {
            test.log(Status.PASS, "Product Added Successfully");
        } else {
            test.log(Status.FAIL, "Product can't be added");
        }

        driver.quit();
        System.out.println("********************CONTINUE SAVED ORDER********************");
    }
}