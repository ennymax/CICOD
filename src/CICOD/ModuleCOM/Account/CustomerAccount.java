package CICOD.ModuleCOM.Account;

import CICOD.base.TestBase;
import CICOD.utility.Login;
import CICOD.utility.ScreenShot;
import CICOD.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CustomerAccount extends TestBase {

    @Test
    public void CUSTOMER_ACCOUNT() throws IOException, InterruptedException {
        test = extent.createTest(Thread.currentThread().getStackTrace()[1].getMethodName());
        Login login = new Login(driver);

        login.Login();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("AccountBTN_XPATH")))).click();

        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("CustomerAccount_XPATH")))).click();

        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertValueOfAccountInCredit_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Value of Account in Debit is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Value of Account in Debit is not displayed and enabled");
        }

        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertValueOfAccountInCredit_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Value of Account in Credit is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Value of Account in Credit is not displayed and enabled");
        }
    }
}
