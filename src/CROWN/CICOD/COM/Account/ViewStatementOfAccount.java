package CROWN.CICOD.COM.Account;

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

public class ViewStatementOfAccount extends TestBase {


    @Test(priority = 1)
    public void login() throws IOException, InterruptedException {
        Login login = new Login(driver);
        login.Login();
    }

    @Test(priority = 2)
    public void CustomerOrderManagement() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
    }

    @Test(priority = 3)
    public void CustomerManagementModule() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Customermanagmentbtn_XPATH"))).click();
    }

    @Test(priority = 4)
    public void SelectCustomer() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SelectCustomerbtn_XPATH"))).click();
    }

    @Test(priority = 5)
    public void ViewCustomer() throws IOException, InterruptedException {
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("ActionSuspend_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        WebElement elementq = driver.findElement(By.xpath(Utility.fetchLocator("VIEWCustomer_XPATH")));
        JavascriptExecutor jsq = (JavascriptExecutor) driver;
        jsq.executeScript("arguments[0].click();", elementq);
    }

    @Test(priority = 6)
    public void ViewStatementOfAccount() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ViewStatementOfAccount_XPATH"))).click();
    }


    @Test(priority = 7)
    public void AssertStatementOfAccount() throws IOException, InterruptedException {
        Thread.sleep(2000);
        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("AssertstatmentOfAccount_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("Statement of Account")) {
            test.log(Status.PASS, "Statement Of account can be Viewed");
        } else {
            test.log(Status.FAIL, "Statement of account cant be viewedd");
        }
    }
}
