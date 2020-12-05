package CROWN.EKEDC;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.io.IOException;

public class Make_Payment_Single_Acount_PrePaid_Bank_Transfer extends TestBase {

    @Test
    public void MAKE_PAYMENT_SINGLE_ACCOUNT_BY_BANK_PREPAID() throws IOException, InterruptedException {
        Login login = new Login(driver);

        login.LoginPrePaidEKEDC();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("MakepAYMENTbtn_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SingleAccountPayment_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ss1_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PrepaidPayByCard_XPATH"))).click();

        Thread.sleep(1200);
        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("PayByBankTr_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByIndex(3);

        Thread.sleep(3000);
        driver.findElement(By.xpath(Utility.fetchLocator("SingleAccountMake_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayNowBajEKE_XPATH"))).click();

        Thread.sleep(2000);
        String title = driver.getTitle();
        System.out.println(title);
        if (driver.getTitle() == "Welcome to Central Pay") {
            test.log(Status.PASS, "Central Pay was Displayed and Enabled");
        } else {
            test.log(Status.FAIL, "Central Pay page wasnt displayed and enabled");
        }
    }
}
