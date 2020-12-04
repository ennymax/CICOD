package CROWN.CICOD.IMS.MaterialIssuanceReport;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.IOException;

public class RecieveDashBoardFilter extends TestBase {

    @Test
    public void DASHBOARD_FILTER() throws IOException, InterruptedException {
        test = extent.createTest("DASHBOARD FILTER");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        Login login = new Login(driver);

        login.LoginCorrectDetails();

        driver.findElement(By.xpath(Utility.fetchLocator("IMS_XPATH"))).click();

        WebElement element11 = driver.findElement(By.xpath(Utility.fetchLocator("FilterBTN_XPATH")));
        Actions action = new Actions(driver);
        action.moveToElement(element11).click();

        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("FilterBTN1_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        //START DATE
        WebElement jjl = driver.findElement(By.xpath(Utility.fetchLocator("Fdate_XPATH")));
        jjl.clear();
        jjl.sendKeys(Utility.fetchLocator("Date_TEXT"));

        //END DATE
        WebElement jjlK = driver.findElement(By.xpath(Utility.fetchLocator("Tdate_XPATH")));
        jjlK.clear();
        jjlK.sendKeys(Utility.fetchLocator("EDate_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ApplyFilterBTN_XPATH"))).click();

Thread.sleep(2000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertMaterialReport_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Material Report is Displayed");
        } else {
            test.log(Status.FAIL, "Material Report Not Displayed");
        }

        Thread.sleep(2000);
        WebElement ElementlNn = driver.findElement(By.xpath(Utility.fetchLocator("AssertTop10Inventry_XPATH")));
        JavascriptExecutor jsklNn = (JavascriptExecutor) driver;
        jsklNn.executeScript("arguments[0].scrollIntoView();", ElementlNn);

        Thread.sleep(2500);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertTop10Inventry_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Top 10 Inventory is Displayed");
        } else {
            test.log(Status.FAIL, "Top 10 Inventory isn't Displayed");
        }

        WebElement ElementlN = driver.findElement(By.xpath(Utility.fetchLocator("AssertIssuanceReport_XPATH")));
        JavascriptExecutor jsklN = (JavascriptExecutor) driver;
        jsklN.executeScript("arguments[0].scrollIntoView();", ElementlN);

        Thread.sleep(2500);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertIssuanceReport_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Issuance Report Displayed");
        } else {
            test.log(Status.FAIL, "Nop Issuance Report Isn't Displaying");
        }

        driver.quit();
        System.out.println("********************DASHBOARD FILTER********************");
    }
}
