package CICOD.ModuleLYTE.SettingUpWorkShop;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class THEME_AND_CONFIG extends TestBase {
    @Test
    public void THEME_CONFIG() throws IOException, InterruptedException {
        test = extent.createTest("THEME AND CONFIG");
        Login login = new Login(driver);

        login.LoginTestAccount();

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("WebshopandConfLyte_XPATH"))).click();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("ThemeandConfigLyte_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
        element.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("UpdateThemeLyte_XPATH"))).click();
        test.log(Status.PASS, "Theme Update page was Displayed successfully");

        Thread.sleep(2000);
        WebElement ele111c = driver.findElement(By.xpath(Utility.fetchLocator("StoreLocation_XPATH")));
        Select sel11c = new Select(ele111c);
        sel11c.selectByIndex(1);

        Thread.sleep(2000);
        WebElement elements = driver.findElement(By.xpath(Utility.fetchLocator("ThemeSaveBTN_XPATH")));
        JavascriptExecutor jss = (JavascriptExecutor) driver;
        jss.executeScript("arguments[0].click();", elements);

        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("assertThemeUpdate_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Theme was saved Successfully");
        } else {
            test.log(Status.FAIL, "Theme cant be updated");
        }
    }
}