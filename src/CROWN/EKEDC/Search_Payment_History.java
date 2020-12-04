package CROWN.EKEDC;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.IOException;

public class Search_Payment_History extends TestBase {
    @Test
    public void SEARCH_PAYMENT_HISTORY() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.LoginEKEDC();

        driver.findElement(By.xpath(Utility.fetchLocator("PaymentHistory_XPATH"))).click();

        WebElement PayH = driver.findElement(By.xpath(Utility.fetchLocator("SearchPaymentHistory_XPATH")));
        PayH.clear();
        PayH.sendKeys(Utility.fetchLocator("TransactionIDEKE_TEXT"));
        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertTransactionID_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Search Payment History By Transaction ID Passed");
        } else {
            test.log(Status.FAIL, "Search Payment History By Transaction ID Failed");
        }

        PayH.clear();
        PayH.sendKeys(Utility.fetchLocator("AmountEKE_TEXT"));
        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertAmount_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Search Payment History By Amount Passed");
        } else {
            test.log(Status.FAIL, "Search Payment History By Amount Failed");
        }

        PayH.clear();
        PayH.sendKeys(Utility.fetchLocator("TransactionReference_TEXT"));
        Thread.sleep(1000);
        if (driver.findElements(By.xpath(Utility.fetchLocator("PaymentHistoryAssertion_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Search Payment History By Transaction Reference was successful");
        } else {
            test.log(Status.FAIL, "Search Payment History By Transaction Reference Failed");
        }
    }
}
