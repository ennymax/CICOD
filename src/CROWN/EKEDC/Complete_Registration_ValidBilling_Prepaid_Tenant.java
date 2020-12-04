package CROWN.EKEDC;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.IOException;

public class Complete_Registration_ValidBilling_Prepaid_Tenant extends TestBase {

    @Test
    public void COMPLETE_REG_VALID_BILLING_PREPAID_TENANT() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.Login_PostPaidLandlordEKEDC();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AccountNumberEKE_XPATH"))).sendKeys(Utility.fetchLocator("PpAccountNumber_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SubmitAccountNumber_XPATH"))).click();

        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("TenantCheckBox_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("FirstNameEKE_XPATH"))).sendKeys(Utility.fetchLocator("FirstName_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("LastNameEKE_XPATH"))).sendKeys(Utility.fetchLocator("LastNAme_TEXT"));
        // driver.findElement(By.xpath(Utility.fetchLocator("AddAccountBTN_XPATH"))).click();

        driver.quit();
    }
}
