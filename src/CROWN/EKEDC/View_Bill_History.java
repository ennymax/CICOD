package CROWN.EKEDC;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.io.IOException;

public class View_Bill_History extends TestBase {
    @Test
    public void VIEW_BILLS_HISTORY() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.LoginEKEDC();

        driver.findElement(By.xpath(Utility.fetchLocator("Account_XPATH"))).click();
        driver.findElement(By.xpath(Utility.fetchLocator("BillHistory_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertBill_History_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Bill History Page was Displayed");
        } else {
            test.log(Status.FAIL, "Bill History page wasn't displayed");
        }
    }
}
