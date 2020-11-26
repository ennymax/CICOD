package CICOD.ModuleLYTE.OrderHistory;

import CICOD.base.TestBase;
import CICOD.utility.Login;
import CICOD.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class VIEW_ORDER_HISTORY extends TestBase {
    @Test
    public void VIEW_ORDER_history() throws IOException, InterruptedException {
        test = extent.createTest("VIEW ORDER HISTORY");
        Login login = new Login(driver);

        login.LoginTestAccount();

        //COM
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.findElement(By.xpath(Utility.fetchLocator("OrderHistorybtn_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("ClickOnOrderRecordsbtn_XPATH"))).click();

        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertRecord_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Order history can be Viewed");
        } else {
            test.log(Status.FAIL, "The Order history cant be viewed");
        }
    }
}
