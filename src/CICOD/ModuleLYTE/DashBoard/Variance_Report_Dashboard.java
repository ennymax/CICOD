package CICOD.ModuleLYTE.DashBoard;

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

public class Variance_Report_Dashboard extends TestBase {

    @Test
    public void VARIANCE_REPORT() throws IOException, InterruptedException {
        test = extent.createTest("VARIANCE REPORT DASHBOARD");
        Login login = new Login(driver);

        login.LoginTestAccount();

        //Com
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        //Variance
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Variance_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("Datefrom_XPATH"))).clear();
        driver.findElement(By.xpath(Utility.fetchLocator("Datefrom_XPATH"))).sendKeys(Utility.fetchLocator("Datefrom_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("Dateto_XPATH"))).clear();
        driver.findElement(By.xpath(Utility.fetchLocator("Dateto_XPATH"))).sendKeys(Utility.fetchLocator("Dateto_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Vdisplaybtn_XPATH"))).click();

        WebElement menuOption = driver.findElement(By.xpath(Utility.fetchLocator("VarianceGraph_XPATH")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", menuOption);

        //Region in Pacentage
        Thread.sleep(2000);
        WebElement menuOption1 = driver.findElement(By.xpath(Utility.fetchLocator("RVariancePercentage_XPATH")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", menuOption1);
    }
}

