package CROWN.CICOD.COM.DashBoard;

import CROWN.base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.ScreenShot;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.io.IOException;

public class View_DashBoard_By_Date extends TestBase {

    @Test
    public void VIEW_DASHBOARD() throws IOException, InterruptedException {
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);

        login.Login();

        //Com
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        //DashBoard
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Dashboard_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("Datefrom_XPATH"))).clear();
        driver.findElement(By.xpath(Utility.fetchLocator("Datefrom_XPATH"))).sendKeys(Utility.fetchLocator("Datefrom_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("Dateto_XPATH"))).clear();
        driver.findElement(By.xpath(Utility.fetchLocator("Dateto_XPATH"))).sendKeys(Utility.fetchLocator("Dateto_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Dispalybtn_XPATH"))).click();
        test.log(Status.PASS, "Display button Clicked");

        Thread.sleep(2000);
        screenshot.ScreenShot();
        if (driver.findElements(By.xpath(Utility.fetchLocator("Rtotalorder_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Total Orders for selected period is displayed");
        } else {
            test.log(Status.FAIL, "Total Orders for selected period is not displayed");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("Rpaidorder_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Paid Orders for selected period is displayed");
        } else {
            test.log(Status.FAIL, "Unpaid Orders for selected period is not displayed");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("Runpaid_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Pending Orders for selected period is displayed");
        } else {
            test.log(Status.FAIL, "Pending Orders for selected period is not displayed");
        }
    }
}
