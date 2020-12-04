package CROWN.EKEDC;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.IOException;

public class Staff_Verification_Valid_StaffID extends TestBase {

    @Test
    public void STAFF_VERIFICATION_VALID_STAFF() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.LoginEKEDC();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("NavigatetoHomepageBTN_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("StaffID_XPATH"))).sendKeys(Utility.fetchLocator("StaffIDEKE_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("VerifyBTN_XPATH"))).click();

        Thread.sleep(1000);
        JavascriptExecutor jej = (JavascriptExecutor) driver;
        WebElement element11 = driver.findElement(By.xpath(Utility.fetchLocator("SrowltoViewStaff_XPATH")));
        jej.executeScript("arguments[0].scrollIntoView(true);", element11);
    }
}
