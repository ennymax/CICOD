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
import java.security.SecureRandom;

public class UpdateInventryStatusRule extends TestBase {

    @Test
    public void UPDATE_INVENTORY_STATUS_RULE() throws IOException, InterruptedException {
        test = extent.createTest("UPDATE INVENTORY STATUS RULE");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        Login login = new Login(driver);

        SecureRandom rn = new SecureRandom();
        int role = rn.nextInt(4) + 1;

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

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("InventoryStatusBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2200);
        WebElement elementt = driver.findElement(By.xpath(Utility.fetchLocator("AssertInventoryStatusRule_XPATH")));
        JavascriptExecutor jst = (JavascriptExecutor) driver;
        jst.executeScript("arguments[0].click();", elementt);

        Thread.sleep(2200);
        WebElement elementtg = driver.findElement(By.xpath(Utility.fetchLocator("ActionStatustorule_XPATH")));
        JavascriptExecutor jstg = (JavascriptExecutor) driver;
        jstg.executeScript("arguments[0].click();", elementtg);

        Thread.sleep(2200);
        WebElement elementtgn = driver.findElement(By.xpath(Utility.fetchLocator("UpdateStatusrule_XPATH")));
        JavascriptExecutor jstgn = (JavascriptExecutor) driver;
        jstgn.executeScript("arguments[0].click();", elementtgn);

        driver.findElement(By.xpath(Utility.fetchLocator("Desedes_XPATH"))).sendKeys(Utility.fetchLocator("Decrib_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("SubmitStatustorole_XPATH"))).click();

        Thread.sleep(500);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertNewStatusCreation_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Status added Successfully");
        } else {
            test.log(Status.FAIL, "Status Cant be added");
        }

        driver.quit();
        System.out.println("********************UPDATE INVENTORY STATUS RULE********************");
    }
}
