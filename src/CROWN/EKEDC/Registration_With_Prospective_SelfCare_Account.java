package CROWN.EKEDC;

import CROWN.Base.TestBase;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.IOException;

public class Registration_With_Prospective_SelfCare_Account extends TestBase {

    @Test
    public void REGISTRATION_WITH_PROSPECTIVE_SELFCARE_ACCOUNT() throws IOException, InterruptedException {
        driver.findElement(By.xpath(Utility.fetchLocator("RegisterBTN_XPATH"))).click();

        driver.findElement(By.xpath(Utility.fetchLocator("RegEmail_XPATH"))).sendKeys(Utility.fetchLocator("PemailEKE_TEXT"));

        driver.findElement(By.xpath(Utility.fetchLocator("RegNumber_XPATH"))).sendKeys(Utility.fetchLocator("RegNumber_TEXT"));

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("RegCheckBox_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        driver.findElement(By.xpath(Utility.fetchLocator("ActualRegisterBTN_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("UserAlreadyExist_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Already Exist message was displayed Successfully");
        } else {
            test.log(Status.FAIL, "Already Exist message was not displayed Successfully");
        }
    }
}
