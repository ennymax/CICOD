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

public class Suspend_UnsuspendCustomerFromCustomerManagementPage extends TestBase {
    @Test
    public void SUSPEND_UNSUSPEND_CUSTOMER_FROM_CUSTOMER_MANAGEMENT_PAGE() throws IOException, InterruptedException {
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);

        login.Login();

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        //CUSTOMER MANAGEMENT BUTTON
        Thread.sleep(2000);
        screenshot.ScreenShot();
        driver.findElement(By.xpath(Utility.fetchLocator("Customermanagmentbtn_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SelectCustomerbtn_XPATH"))).click();

        //SELECT ACTION
        Thread.sleep(2000);
        screenshot.ScreenShot();
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("ActionSuspend_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        WebElement elementq = driver.findElement(By.xpath(Utility.fetchLocator("VIEWCustomer_XPATH")));
        JavascriptExecutor jsq = (JavascriptExecutor) driver;
        jsq.executeScript("arguments[0].click();", elementq);

        Thread.sleep(2000);
        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("AssertViewCustomer_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("View Customer")) {
            test.log(Status.PASS, "Customer can Be Viewed");
        } else {
            test.log(Status.FAIL, "Customer cant be viewed");
        }

        Thread.sleep(2000);
        WebElement elementqj = driver.findElement(By.xpath(Utility.fetchLocator("SuspendFromCustomerPage_XPATH")));
        JavascriptExecutor jsqj = (JavascriptExecutor) driver;
        jsqj.executeScript("arguments[0].click();", elementqj);

        login.AcceptAlert();

        Thread.sleep(2000);
        WebElement elementqll = driver.findElement(By.xpath(Utility.fetchLocator("UnsuspendfromCustomerPage_XPATH")));
        JavascriptExecutor jsqll = (JavascriptExecutor) driver;
        jsqll.executeScript("arguments[0].click();", elementqll);

        login.AcceptAlert();
    }
}
