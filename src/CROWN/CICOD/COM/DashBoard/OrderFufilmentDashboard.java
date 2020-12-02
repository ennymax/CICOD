package CROWN.CICOD.COM.DashBoard;

import CROWN.base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class OrderFufilmentDashboard extends TestBase {

    @Test
    public void ORDER_FUFILLMENT() throws IOException, InterruptedException {
        Login login = new Login(driver);
        Utility utility = new Utility(driver);

        login.Login();

        utility.DoclickWhenReady("com_XPATH", "comm_TEXT",60);
        utility.DoclickWhenReady("Dashboard_XPATH", "DashBoardBTN_TEXT",50);
        utility.DoSendKeysWhenReady("Datefrom_XPATH", "Datefrom_TEXT","Datefrom_TEXT", 50);
        utility.DoSendKeysWhenReady("Dateto_XPATH", "Dateto_TEXT","Dateto_TEXT", 50);
        utility.DoclickWhenReady("Dispalybtn_XPATH", "DD_TEXT",50);
        utility.DoAssertXpathPresentWhenReady("TotalOrder_XPATH", "TotalOrderPassMsg_TEXT","TotalOrderPassMsg_TEXT", 20);

        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("PaidOrder_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Paid Order was displayed and enabled");
        } else {
            test.log(Status.FAIL, "Paid Order wasn't displayed and enabled");
        }

        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("TotalPendingOeder_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Total Pending Order was displayed and enabled");
        } else {
            test.log(Status.FAIL, "Total Pending Order wasn't displayed and enabled");
        }

        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("TotalCancelOrder_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Total cancel Order is Displayed and Enabled");
        } else {
            test.log(Status.FAIL, "Total Canceled Order is not displayed and enabled");
        }

        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("ExpiredAndCreditOrders_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Expired and Credit Order is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Expired and Credit Order is not displayed and Enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AnnualSalesTarget_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Annual Sales Target is Displayed and enabled");
        } else {
            test.log(Status.FAIL, "Annual Sales Target is not displayed and ebabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("Top10Customers_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Top 10 Customers is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Top 10 customer is not Displayed and enabled");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("Top10Product_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Top 10 Product is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Top 10 Product is not displayed and Enabled");
        }
    }
}

