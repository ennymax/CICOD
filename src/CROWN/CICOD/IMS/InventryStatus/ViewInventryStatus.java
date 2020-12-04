package CROWN.CICOD.IMS.InventryStatus;

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

public class ViewInventryStatus extends TestBase {

    @Test
    public void VIEW_INVENTORY_STATUS() throws IOException, InterruptedException {
        test = extent.createTest("VIEW INVENTORY STATUS");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        Login login = new Login(driver);

        login.LoginCorrectDetails();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertLogin_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Login was successful");
        } else {
            test.log(Status.FAIL, "Login failed");
        }

        driver.findElement(By.xpath(Utility.fetchLocator("IMS_XPATH"))).click();

        Thread.sleep(2000);
        WebElement element11 = driver.findElement(By.xpath(Utility.fetchLocator("InventoryStatusBTN_XPATH")));
        Actions action = new Actions(driver);
        action.moveToElement(element11).click();

        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("InventoryStatusBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(500);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertInventStatus_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Inventory Status is present");
        } else {
            test.log(Status.FAIL, "Inventory Status is not present");
        }

        Thread.sleep(500);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertInventoryStatusRule_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Inventory Status rule is present");
        } else {
            test.log(Status.FAIL, "Supplier rule Not Created");
        }

        Thread.sleep(500);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertUpdateInventoryStatus_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Update Inventory Status rule is present");
        } else {
            test.log(Status.FAIL, "Update Inventory Status rule is not present");
        }

        Thread.sleep(2000);
        WebElement elementt = driver.findElement(By.xpath(Utility.fetchLocator("InVentoryStatus_XPATH")));
        JavascriptExecutor jst = (JavascriptExecutor) driver;
        jst.executeScript("arguments[0].click();", elementt);

        Thread.sleep(500);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertManageItemStatusPage_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Manage Item Status page displayed");
        } else {
            test.log(Status.FAIL, "Manage Item Status page Failed");
        }

        driver.quit();
        System.out.println("********************VIEW INVENTORY STATUS********************");
    }
}
