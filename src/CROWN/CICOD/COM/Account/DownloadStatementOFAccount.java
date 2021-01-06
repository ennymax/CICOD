package CROWN.CICOD.COM.Account;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.ScreenShot;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Description;
import org.testng.annotations.Test;

import java.io.IOException;

public class DownloadStatementOFAccount extends TestBase {

    @Description("login")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1)
    public void login() throws IOException, InterruptedException {
        Login login = new Login(driver);
        login.Login();
    }

    @Description("Customer Order Management")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void CustomerOrderManagement() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();
    }

    @Description("Customer Management Module")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void CustomerManagementModule() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Customermanagmentbtn_XPATH"))).click();
    }

    @Description("Select Customer")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void SelectCustomer() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SelectCustomerbtn_XPATH"))).click();
    }

    @Description("View Customer")
    @Severity(SeverityLevel.CRITICAL)
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

    @Description("View Statement Of Account")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 6)
    public void ViewStatementOfAccount() throws IOException, InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ViewStatementOfAccount_XPATH"))).click();
    }

    @Description("Assert Statement Of Account")
    @Severity(SeverityLevel.CRITICAL)
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

    @Description("Filter Date Range")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 8)
    public void FilterDateRange() throws IOException, InterruptedException {
        WebElement tt = driver.findElement(By.xpath(Utility.fetchLocator("FilterDateFrom_XPATH")));
        tt.clear();
        tt.sendKeys(Utility.fetchLocator("Datefrom_TEXT"));

        WebElement ttv = driver.findElement(By.xpath(Utility.fetchLocator("FilterDateto_XPATH")));
        ttv.clear();
        ttv.sendKeys(Utility.fetchLocator("Dateto_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("FilterfilterBTN_XPATH"))).click();
    }

    @Description("Download Statement Of Account As PDF")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 9)
    public void DownloadStatementOfAccountAsPDF() throws IOException, InterruptedException {
        Thread.sleep(2000);
        WebElement ti11z = driver.findElement(By.xpath(Utility.fetchLocator("dOWNLOADSttatementOfAccount_XPATH")));
        JavascriptExecutor jsez = (JavascriptExecutor) driver;
        jsez.executeScript("arguments[0].scrollIntoView();", ti11z);
        ti11z.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("DownloadAsPDF_XPATH"))).click();
    }

    @Description("Download Statement Of Account As Excel")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 10)
    public void DownloadStatementOfAccountAsExcel() throws IOException, InterruptedException {
        driver.navigate().back();
        Thread.sleep(2000);
        WebElement ti11zz = driver.findElement(By.xpath(Utility.fetchLocator("dOWNLOADSttatementOfAccount_XPATH")));
        JavascriptExecutor jsezz = (JavascriptExecutor) driver;
        jsezz.executeScript("arguments[0].scrollIntoView();", ti11zz);
        ti11zz.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("DownloadAsSpreadSheet_XPATH"))).click();
    }
}
