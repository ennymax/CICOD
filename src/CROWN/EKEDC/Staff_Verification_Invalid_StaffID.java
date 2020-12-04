package CROWN.EKEDC;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.io.IOException;

public class Staff_Verification_Invalid_StaffID extends TestBase {
    @Test
    public void STAFF_VERIFICATION_INVALID_STAFFID() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.LoginEKEDC();

        driver.findElement(By.xpath(Utility.fetchLocator("NavigatetoHomepageBTN_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("StaffID_XPATH"))).sendKeys(Utility.fetchLocator("StaffIDINVALID_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("VerifyBTN_XPATH"))).click();


        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertWrongStaffID_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Incorrect Staff ID Error Message was displayed");
        } else {
            test.log(Status.FAIL, "Incorrect Staff ID Error Message was not displayed");
        }
    }
}
