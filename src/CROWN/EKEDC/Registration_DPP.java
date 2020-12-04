package CROWN.EKEDC;

import CROWN.Base.TestBase;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.io.IOException;

public class Registration_DPP extends TestBase {
    @Test
    public void REGISTRATION() throws IOException, InterruptedException {

        driver.findElement(By.xpath(Utility.fetchLocator("RegisterBTN_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("RegEmail_XPATH"))).sendKeys(Utility.fetchLocator("Regemail_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("RegNumber_XPATH"))).sendKeys(Utility.fetchLocator("RegNumber_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("ActualRegisterBTN_XPATH"))).click();
        driver.findElement(By.xpath(Utility.fetchLocator("ActualRegisterBTN_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("Pleaseagree_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Error Message Agree to customer was Displayed");
        } else {
            test.log(Status.FAIL, "Error Message Agree to customer was not Displayed");
        }
    }
}
