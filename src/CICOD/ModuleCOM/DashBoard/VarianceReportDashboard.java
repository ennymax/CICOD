package CICOD.ModuleCOM.DashBoard;

import CICOD.base.TestBase;
import CICOD.utility.BrokenLink;
import CICOD.utility.Login;
import CICOD.utility.ScreenShot;
import CICOD.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class VarianceReportDashboard extends TestBase {

    @Test
    public void View_Variance_report_DashBoard() throws IOException, InterruptedException {
        test = extent.createTest("View Variance report DashBoard");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        BrokenLink brokenLink = new BrokenLink(driver);
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);

        login.Login();
        test.log(Status.PASS, "Login Was Successful");

        //Com
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
        test.log(Status.PASS, "COM button fully functional");

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("VarianceBTN_XPATH")))).click();

        Thread.sleep(2000);
        screenshot.ScreenShot();
        driver.findElement(By.xpath(Utility.fetchLocator("Datefrom_XPATH"))).clear();
        driver.findElement(By.xpath(Utility.fetchLocator("Datefrom_XPATH"))).sendKeys(Utility.fetchLocator("Datefrom_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("Dateto_XPATH"))).clear();
        driver.findElement(By.xpath(Utility.fetchLocator("Dateto_XPATH"))).sendKeys(Utility.fetchLocator("Dateto_TEXT"));

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("Dispalybtn_XPATH"))).click();
        test.log(Status.PASS, "Display button Clicked");

        Thread.sleep(2000);
        screenshot.ScreenShot();
        if (driver.findElements(By.xpath(Utility.fetchLocator("VarianceGraph1_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Variance Graph is Displayed and Fully Functional");

        } else {
            test.log(Status.FAIL, "Variance Graph is not Displayed");
        }

        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertSummary1_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Total Amount in Q1 is Displayed and enabled");
        } else {
            test.log(Status.FAIL, "Total Amount in Q1 is not Displayed and enabled");
        }

        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertSummary2_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Total Amount in Q2 is Displayed and enabled");
        } else {
            test.log(Status.FAIL, "Total Amount in Q2 is not Displayed and enabled");
        }

        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertSummary3_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Total Amount in Q3 is Displayed and enabled");
        } else {
            test.log(Status.FAIL, "Total Amount in Q3 is not Displayed and enabled");
        }

        System.out.println("********************View Variance report DashBoard Test is Completed********************");
        driver.quit();
    }
}
