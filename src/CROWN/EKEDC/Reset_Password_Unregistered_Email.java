package CROWN.EKEDC;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.io.IOException;

public class Reset_Password_Unregistered_Email extends TestBase {

    @Test
    public void RESET_PASSWORD_UNREGISTERED_EMAIL() throws IOException {
        Login login = new Login(driver);

        driver.findElement(By.xpath(Utility.fetchLocator("Loginbtn_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("ResetPasswordBTNEKE_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("ResetEmail_XPATH"))).sendKeys(Utility.fetchLocator("UnregisteredEmail_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("SubmitRemail_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("ReAssert_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Invalid Email Address was displayed successfully");
        } else {
            test.log(Status.FAIL, "Invalid Email address was not displayed");
        }
    }
}
