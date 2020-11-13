package CICOD.ModuleCOM.Settings;

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
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class UPDATE_TAX extends TestBase {

    @Test
    public void UPDATE_Tax() throws IOException, InterruptedException {
        test = extent.createTest("UPDATE TAX");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        BrokenLink brokenLink = new BrokenLink(driver);
        ScreenShot screenShot = new ScreenShot(driver);
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
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("Vt_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("TaxActionbtn_XPATH"))).click();

        Thread.sleep(1700);
        driver.findElement(By.xpath(Utility.fetchLocator("TaxUdatebtn_XPATH"))).click();
        test.log(Status.PASS, "Tax Update Button fully Functional");

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("TaxName_XPATH"))).clear();
        driver.findElement(By.xpath(Utility.fetchLocator("TaxName_XPATH"))).sendKeys(Utility.fetchLocator("TaxName_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("TaxValue_XPATH"))).clear();
        driver.findElement(By.xpath(Utility.fetchLocator("TaxValue_XPATH"))).sendKeys(Utility.fetchLocator("TaxValue_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("TaxSavebtn_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertUpdateTax_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Tax was Updated Successfully");
        } else {
            test.log(Status.FAIL, "Tax Want Updated");
        }

        driver.quit();
    }
}
