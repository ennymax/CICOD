package CROWN.CICOD.ModuleCOM.DashBoard;

import CROWN.base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.ScreenShot;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.IOException;

public class VarianceReportDashboard extends TestBase {

    @Test
    public void View_Variance_report_DashBoard() throws IOException, InterruptedException {
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);

        login.Login();

        //Com
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

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
    }
}
