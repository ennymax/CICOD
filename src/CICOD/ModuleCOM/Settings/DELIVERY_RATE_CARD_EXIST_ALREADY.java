package CICOD.ModuleCOM.Settings;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DELIVERY_RATE_CARD_EXIST_ALREADY extends TestBase {

    @Test
    public void DELIVERY_RATE_CARD_SETUP() throws IOException, InterruptedException {
        test = extent.createTest("DELIVERY RATE CARD SETUP");
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);

        login.Login();

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Settings_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SystemSettings_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("DeliveryRatebtn_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        Thread.sleep(1700);
        driver.findElement(By.xpath(Utility.fetchLocator("DelAdd_XPATH"))).click();

        Thread.sleep(1000);
        screenshot.ScreenShot();
        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("marchantLocation_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByIndex(1);

        Thread.sleep(1000);
        WebElement ele11 = driver.findElement(By.xpath(Utility.fetchLocator("SelectCountry_XPATH")));
        Select sel1 = new Select(ele11);
        sel1.selectByIndex(3);

        Thread.sleep(1000);
        WebElement ele111j = driver.findElement(By.xpath(Utility.fetchLocator("MarchantState_XPATH")));
        Select sel11j = new Select(ele111j);
        sel11j.selectByIndex(25);

        Thread.sleep(1000);
        WebElement ele111c = driver.findElement(By.xpath(Utility.fetchLocator("MarchantLGA_XPATH")));
        Select sel11c = new Select(ele111c);
        sel11c.selectByIndex(10);

        driver.findElement(By.xpath(Utility.fetchLocator("MiniDeliveryCharge_XPATH"))).sendKeys(Utility.fetchLocator("MiniDeliveryRate_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("PercentDeliveryRate_XPATH"))).sendKeys(Utility.fetchLocator("PercentageDeliveryCharge_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("FreeDeliveryPrice_XPATH"))).sendKeys(Utility.fetchLocator("FreeeDeliveryPrice_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("DeliverySavebtn_XPATH"))).click();

        Thread.sleep(2000);
        screenshot.ScreenShotFullPage();
        WebElement msg11f = driver.findElement(By.xpath(Utility.fetchLocator("as_XPATH")));
        String text11f = msg11f.getText();
        if (msg11f.isEnabled() && text11f.contains("Delivery Rate Card exists already")) {
            test.log(Status.PASS, "Delivery Rate Card was setup");
        } else {
            test.log(Status.FAIL, "Delivery Rate Card wasn't setUp");
        }
    }
}
