package CROWN.EKEDC;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Make_Payment_Single_Account_Pay_By_Bank_PostPaid extends TestBase {

    @Test
    public void MAKE_PAYMENT_SINGLE_ACCOUNT_BY_BANK_POST_PAID() throws IOException, InterruptedException {
        Login login = new Login(driver);
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

        login.LoginEKEDC();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("MakepAYMENTbtn_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SingleAccountPayment_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ss1_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PrepaidPayByCard_XPATH"))).click();

        if (driver.findElements(By.xpath(Utility.fetchLocator("AssertBuyTokenpage_XPATH"))).size() != 0) {
            test.log(Status.PASS, "Buy Token Page was Displayed");
        } else {
            test.log(Status.FAIL, "Buy Token Page wasn't Displayed");
        }

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayMakePAyment_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PaymentNowBTN_XPATH"))).click();

        Thread.sleep(2000);
        String title = driver.getTitle();
        System.out.println(title);

        if (driver.getTitle() == "Welcome to Central Pay") {
            test.log(Status.PASS, "Central Pay was Displayed and Enabled");
        } else {
            test.log(Status.FAIL, "Central Pay page wasnt displayed and enabled");
        }

        driver.quit();
    }
}
