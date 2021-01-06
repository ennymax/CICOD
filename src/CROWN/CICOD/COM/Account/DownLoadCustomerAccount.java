package CROWN.CICOD.COM.Account;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Description;
import org.testng.annotations.Test;
import java.io.IOException;

public class DownLoadCustomerAccount extends TestBase {

    @Description("login")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority=1)
    public void login() throws IOException, InterruptedException {
        Login login = new Login(driver);
        login.Login();
    }

    @Description("Customer Order Management")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority=2)
    public void CustomerOrderManagement() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
    }

    @Description("Account Button")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority=3)
    public void AccountButton() throws IOException, InterruptedException {
        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("AccountBTN_XPATH")))).click();
    }

    @Description("Customer Account Button")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority=4)
    public void CustomerAccountButton() throws IOException, InterruptedException {
        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("CustomerAccount_XPATH")))).click();
    }

    @Description("Assert ValueIn Customer Account")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority=5)
    public void AssertValueInCustomerAccount() throws IOException, InterruptedException {
        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertValueOfAccountInCredit_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Value of Account in Debit is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Value of Account in Debit is not displayed and enabled");
        }
    }

    @Description("Assert Value In Credit Note")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority=6)
    public void AssertValueInCreditNote() throws IOException, InterruptedException {
        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertValueOfAccountInCredit_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Value of Account in Credit is displayed and enabled");
        } else {
            test.log(Status.FAIL, "Value of Account in Credit is not displayed and enabled");
        }
    }

    @Description("DOWNLOAD CUSTOMER ACCOUNT")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority=7)
    public void DOWNLOAD_CUSTOMER_ACCOUNT() throws IOException, InterruptedException {
        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("DownloadCustomerAccount_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();
    }
}
