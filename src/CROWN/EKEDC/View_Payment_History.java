package CROWN.EKEDC;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.IOException;

public class View_Payment_History extends TestBase {

    @Test
    public void VIEW_PAYMENT_HISTORY() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.LoginEKEDC();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PaymentHistory_XPATH"))).click();

        WebElement element11 = driver.findElement(By.xpath(Utility.fetchLocator("Scroll1_XPATH")));
        JavascriptExecutor jej = (JavascriptExecutor) driver;
        jej.executeScript("arguments[0].scrollIntoView(true);", element11);

        if (driver.findElements(By.xpath(Utility.fetchLocator("PaymentHistoryAssertion_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Payment History was displayed was displayed");
        } else {
            test.log(Status.FAIL, "Payment History  was not displayed");
        }
    }
}
