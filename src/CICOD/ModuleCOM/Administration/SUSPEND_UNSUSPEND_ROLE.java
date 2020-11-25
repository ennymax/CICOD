package CICOD.ModuleCOM.Administration;

import CICOD.base.TestBase;
import CICOD.utility.Login;
import CICOD.utility.ScreenShot;
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

public class SUSPEND_UNSUSPEND_ROLE extends TestBase {

    @Test
    public void Suspend_Unsuspend_Role() throws IOException, InterruptedException {
        test = extent.createTest("SUSPEND UNSUSPEND ROLE");
        ScreenShot screenShot = new ScreenShot(driver);
        Login login = new Login(driver);

        login.Login();

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        Thread.sleep(2000);
        screenShot.ScreenShotFullPage();
        driver.findElement(By.xpath(Utility.fetchLocator("Adminbtn_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Rolemanagementbtn_XPATH"))).click();

        WebElement t = driver.findElement(By.xpath(Utility.fetchLocator("SS_XPATH")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", t);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("RoleActionbtn_XPATH"))).click();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("suspend/unsuspendRole_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        driver.switchTo().alert().accept();

        WebElement msg11l = driver.findElement(By.xpath(Utility.fetchLocator("ComfirmPOSPayment_XPATH")));
        String text11l = msg11l.getText();
        if (msg11l.isEnabled() && text11l.contains("Role suspended")) {
            test.log(Status.PASS, "Role suspended Successfully");
        } else {
            test.log(Status.FAIL, "Role suspension failed");
        }

        WebElement ti = driver.findElement(By.xpath(Utility.fetchLocator("SS_XPATH")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ti);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("RoleActionbtn_XPATH"))).click();

        Thread.sleep(2000);
        WebElement element2 = driver.findElement(By.xpath(Utility.fetchLocator("suspend/unsuspendRole_XPATH")));
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].click();", element2);

        driver.switchTo().alert().accept();

        Thread.sleep(2000);
        WebElement msg11l1 = driver.findElement(By.xpath(Utility.fetchLocator("ComfirmPOSPayment_XPATH")));
        String text11l1 = msg11l1.getText();
        if (msg11l1.isEnabled() && text11l1.contains("Role unsuspended")) {
            test.log(Status.PASS, "Role Unsuspended Successfully");
        } else {
            test.log(Status.FAIL, "Role Unsuspension failed");
        }

        driver.quit();
    }
}
