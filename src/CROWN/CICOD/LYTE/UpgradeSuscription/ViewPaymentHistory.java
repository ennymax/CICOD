package CROWN.CICOD.LYTE.UpgradeSuscription;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;

public class ViewPaymentHistory extends TestBase {

    @Test
    public void VIEW_PAYMENT_HISTORY() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.LoginExpiredAccount();

        Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("Billing_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        WebElement element1 = driver.findElement(By.xpath(Utility.fetchLocator("BillandPaymentHistory_XPATH")));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", element1);

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertBillandPaymentHistoryPage_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Payment History was Displayed");
        } else {
            test.log(Status.FAIL, "Payment History wasn't Displayed");
        }
    }
}
