package CROWN.CICOD.COM.CustomerManagment;

import CROWN.base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;

public class DownLoadCreditLimit extends TestBase {

    @Test
    public void DOWNLOAD_CREDIT_HISTORY() throws IOException, InterruptedException, AWTException {
        Login login = new Login(driver);

        login.Login();

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        //CUSTOMER MANAGEMENT BUTTON
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Customermanagmentbtn_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("CreditLimi_XPATH"))).click();

        WebElement k = driver.findElement(By.xpath(Utility.fetchLocator("AssertViewCreditLimi_XPATH")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", k);

        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("AssertViewCreditLimi_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("Credit Limit")) {
            test.log(Status.PASS, "Credit Limit can Be Viewed");
        } else {
            test.log(Status.FAIL, "Credit Limit cant be viewed");
        }

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("DownloadCreditHistory_XPATH"))).click();
    }
}
