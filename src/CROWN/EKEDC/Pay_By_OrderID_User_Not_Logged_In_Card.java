package CROWN.EKEDC;

import CROWN.Base.TestBase;
import CROWN.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Pay_By_OrderID_User_Not_Logged_In_Card extends TestBase {

    @Test
    public void PAY_ORDER_ID_USER_NOT_LOGGED_IN_CARD() throws IOException, InterruptedException {
        //driver.get("https://staging-ekedp.convergenceondemand.net/");
        driver.manage().timeouts().implicitlyWait(39, TimeUnit.SECONDS);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("MakePaymentBTNnotLogedIN_XPATH"))).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayOrderID_XPATH"))).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath(Utility.fetchLocator("InputPayOrderID_XPATH"))).sendKeys(Utility.fetchLocator("OrderID_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("SubmitPaymentIDBTN_XPATH"))).click();

        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath(Utility.fetchLocator("MakePayementBTN_XPATH")));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        /*
        Thread.sleep(3000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayByCard_XPATH"))).click();

        Thread.sleep(4000);
        driver.findElement(By.xpath(Utility.fetchLocator("PaymentEmail_XPATH"))).sendKeys(Utility.fetchLocator("Pemail_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("PaymentNumber_XPATH"))).sendKeys(Utility.fetchLocator("RegNumber_TEXT"));

        Thread.sleep(3000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayPayBTN_XPATH"))).click();
*/
        driver.quit();
    }
}
