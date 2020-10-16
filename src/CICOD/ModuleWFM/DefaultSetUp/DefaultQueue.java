package CICOD.ModuleWFM.DefaultSetUp;

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

public class DefaultQueue extends TestBase {

    @Test
    public void DEFAULT_QUEUE() throws IOException, InterruptedException {
        test = extent.createTest("DEFAULT QUEUE");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        Login login = new Login(driver);

        login.LoginDef1();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Wfm_XPATH"))).click();

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("WorkOrderManagement_XPATH"))).click();

        Thread.sleep(1500);
        driver.findElement(By.xpath(Utility.fetchLocator("Manage_Queue_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertOrderFufilment_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Order Fulfilment Queue is present as Default");
        } else {
            test.log(Status.FAIL, "Order Fulfilment Queue is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertComplaint_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Complaint Queue is present as Default");
        } else {
            test.log(Status.FAIL, "Complaint Queue is not present as Default");
        }

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertFinance_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Finance Queue is present as Default");
        } else {
            test.log(Status.FAIL, "Finance Queue is not present as Default");
        }

        driver.quit();
        System.out.println("********************DEFAULT QUEUE********************");
    }
}
