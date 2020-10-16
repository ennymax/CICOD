package CICOD.ModuleCOM.ValueChain;

import CICOD.base.TestBase;
import CICOD.utility.BrokenLink;
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

import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class ViewOrderHistoryViaValueChain extends TestBase {

    @Test
    public void VIEW_OREDER_HISTORY() throws IOException, InterruptedException {
        test = extent.createTest("VIEW ORDER HISTORY VALUE CHAIN");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);
        BrokenLink brokenLink = new BrokenLink(driver);
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
        driver.findElement(By.xpath(Utility.fetchLocator("Customermanagmentbtn_XPATH"))).click();
        test.log(Status.PASS, "Customer Management button fully Functional");

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("ValuechainBTN_XPATH"))).click();

        Thread.sleep(1400);
        driver.findElement(By.xpath(Utility.fetchLocator("ValuechainByers_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("BuyerActionBTN_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        Thread.sleep(1400);
        driver.findElement(By.xpath(Utility.fetchLocator("BuyerOrderHistory_XPATH"))).click();

        Thread.sleep(1000);
        WebElement msgoommmm =(new WebDriverWait(driver, 12)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Utility.fetchLocator("AssertOrderhistoryBTN_XPATH"))));
        String textoommmm = msgoommmm.getText();
        if (msgoommmm.isEnabled() && textoommmm.contains("Order History - emaxkemiyop")) {
            test.log(Status.PASS, "Order History Page can be Viewed");
        } else {
            test.log(Status.FAIL, "Failed to view Order History Page");
        }

        System.out.println("********************VIEW ORDER HISTORY********************");
        driver.quit();
    }
}
