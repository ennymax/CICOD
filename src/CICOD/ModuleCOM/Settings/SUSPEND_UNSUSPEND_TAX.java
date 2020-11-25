package CICOD.ModuleCOM.Settings;

import CICOD.base.TestBase;
import CICOD.utility.Login;
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

public class SUSPEND_UNSUSPEND_TAX extends TestBase {

    @Test
    public void SUSPEND_UNSUSPEND_TAX() throws IOException, InterruptedException {
        test = extent.createTest("SUSPEND UNSUSPEND TAX");
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

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("TaxActionbtn_XPATH"))).click();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("sUSPENDTax_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        driver.switchTo().alert().accept();

        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("as_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("Tax suspended")) {
            test.log(Status.PASS, "Tax suspended");
        } else {
            test.log(Status.FAIL, "Tax cannot be suspended");
        }

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("TaxActionbtn_XPATH"))).click();

        Thread.sleep(2000);
        WebElement elementz = driver.findElement(By.xpath(Utility.fetchLocator("UnsuspendTax_XPATH")));
        JavascriptExecutor jsz = (JavascriptExecutor) driver;
        jsz.executeScript("arguments[0].click();", elementz);

        driver.switchTo().alert().accept();

        Thread.sleep(2000);
        WebElement msg11f = driver.findElement(By.xpath(Utility.fetchLocator("as_XPATH")));
        String text11f = msg11f.getText();
        if (msg11f.isEnabled() && text11f.contains("Tax unsuspended")) {
            test.log(Status.PASS, "Tax Unsuspendsion Successful");
        } else {
            test.log(Status.FAIL, "Tax Unsuspension Failed");
        }
    }
}
