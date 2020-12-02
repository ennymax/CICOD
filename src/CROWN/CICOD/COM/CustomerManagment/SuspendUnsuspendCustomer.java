package CROWN.CICOD.COM.CustomerManagment;

import CROWN.base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.ScreenShot;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.IOException;

public class SuspendUnsuspendCustomer extends TestBase {

    @Test
    public void SUSPEND_UNSUSPEND_CUSTOMER() throws IOException, InterruptedException {
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);
        ScreenShot screenShot = new ScreenShot(driver);

        login.Login();

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        //CUSTOMER MANAGEMENT BUTTON
        Thread.sleep(2000);
        screenshot.ScreenShot();
        WebElement ti11z = driver.findElement(By.xpath(Utility.fetchLocator("Customermanagmentbtn_XPATH")));
        JavascriptExecutor jsez = (JavascriptExecutor) driver;
        jsez.executeScript("arguments[0].scrollIntoView();", ti11z);
        ti11z.click();

        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("SelectCustomerbtn_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        //SELECT ACTION
        Thread.sleep(2000);
        screenshot.ScreenShot();
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("ActionSuspend_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        WebElement elementq = driver.findElement(By.xpath(Utility.fetchLocator("SuspendCustomerBTN_XPATH")));
        JavascriptExecutor jsq = (JavascriptExecutor) driver;
        jsq.executeScript("arguments[0].click();", elementq);
        test.log(Status.PASS, "Customer Suspended Successfully");

        Thread.sleep(2000);
        WebElement elementl = driver.findElement(By.xpath(Utility.fetchLocator("ActionSuspend_XPATH")));
        JavascriptExecutor jsl = (JavascriptExecutor) driver;
        jsl.executeScript("arguments[0].click();", elementl);

        Thread.sleep(2000);
        WebElement elementqll = driver.findElement(By.xpath(Utility.fetchLocator("UnsuspendCustomer_XPATH")));
        JavascriptExecutor jsqll = (JavascriptExecutor) driver;
        jsqll.executeScript("arguments[0].click();", elementqll);
        test.log(Status.PASS, "Customer Unsuspended Successfully");

        Thread.sleep(2000);
        screenShot.ScreenShotFullPage();
    }
}
