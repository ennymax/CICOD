package CROWN.CICOD.COM.Administration;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.ScreenShot;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.IOException;

public class SUSPEND_UNSUSPEND_ROLE extends TestBase {

    @Test(priority = 1)
    public void login() throws IOException, InterruptedException {
        Login login = new Login(driver);
        login.Login();
    }

    @Test(priority = 2)
    public void CustomerOrderManagement() throws IOException, InterruptedException {
        Utility utility = new Utility(driver);
        utility.DoclickWhenReady("com_XPATH", "comm_TEXT", 60);
    }

    @Test(priority = 3)
    public void AdministrationModule() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Adminbtn_XPATH"))).click();
    }

    @Test(priority = 4)
    public void RoleManagement() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Rolemanagementbtn_XPATH"))).click();
    }

    @Test(priority = 5)
    public void SuspendRole() throws IOException, InterruptedException {
        Thread.sleep(2000);
        WebElement ti = driver.findElement(By.xpath(Utility.fetchLocator("SS_XPATH")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ti);
        driver.findElement(By.xpath(Utility.fetchLocator("RoleActionbtn_XPATH"))).click();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("suspend/unsuspendRole_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    @Test(priority = 6)
    public void AcceptAlertsus(){
        driver.switchTo().alert().accept();
    }

    @Test(priority = 7)
    public void AssertSuspendRole() throws IOException, InterruptedException {
        WebElement msg11l = driver.findElement(By.xpath(Utility.fetchLocator("ComfirmPOSPayment_XPATH")));
        String text11l = msg11l.getText();
        if (msg11l.isEnabled() && text11l.contains("Role suspended")) {
            test.log(Status.PASS, "Role suspended Successfully");
        } else {
            test.log(Status.FAIL, "Role suspension failed");
        }
    }

    @Test(priority = 8)
    public void UnsuspendRole() throws IOException, InterruptedException {
        Thread.sleep(2000);
        WebElement ti = driver.findElement(By.xpath(Utility.fetchLocator("SS_XPATH")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ti);

        driver.findElement(By.xpath(Utility.fetchLocator("RoleActionbtn_XPATH"))).click();

        Thread.sleep(2000);
        WebElement element2 = driver.findElement(By.xpath(Utility.fetchLocator("suspend/unsuspendRole_XPATH")));
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("arguments[0].click();", element2);
    }

    @Test(priority = 9)
    public void AcceptAlert() throws IOException, InterruptedException {
        driver.switchTo().alert().accept();
    }

    @Test(priority = 10)
    public void AssertUnsuspendRole() throws IOException, InterruptedException {
        Thread.sleep(2000);
        WebElement msg11l1 = driver.findElement(By.xpath(Utility.fetchLocator("ComfirmPOSPayment_XPATH")));
        String text11l1 = msg11l1.getText();
        if (msg11l1.isEnabled() && text11l1.contains("Role unsuspended")) {
            test.log(Status.PASS, "Role Unsuspended Successfully");
        } else {
            test.log(Status.FAIL, "Role Unsuspension failed");
        }
    }
}
