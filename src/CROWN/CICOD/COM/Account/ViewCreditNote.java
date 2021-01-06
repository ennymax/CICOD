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
import java.awt.*;
import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class ViewCreditNote extends TestBase {

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

    @Description("Account Module")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority=3)
    public void AccountModule() throws IOException, InterruptedException {
        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("AccountBTN_XPATH")))).click();
    }

    @Description("Credit Note Button")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority=4)
    public void CreditNoteButton() throws IOException, InterruptedException {
        Thread.sleep(2000);
        (new WebDriverWait(driver, 45)).until(ExpectedConditions.elementToBeClickable(By.xpath(Utility.fetchLocator("CreditNote_XPATH")))).click();
    }

    @Description("View Credit Note")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority=5)
    public void ViewCreditNote() throws IOException, InterruptedException {
        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("cAction_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        Thread.sleep(1200);
        driver.findElement(By.xpath(Utility.fetchLocator("CView_XPATH"))).click();
    }

    @Description("Assert View Credit Note")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority=6)
    public void AssertViewCreditNote() throws IOException, InterruptedException {
        Thread.sleep(2000);
        assertEquals("Credit Note", driver.findElement(By.xpath(Utility.fetchLocator("AssertViewCrerditNote_XPATH"))).getText());
    }
}
