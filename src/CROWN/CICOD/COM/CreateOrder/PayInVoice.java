package CROWN.CICOD.COM.CreateOrder;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.ScreenShot;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.io.IOException;
import java.security.SecureRandom;

public class PayInVoice extends TestBase {

    @Test
    public void Pay_Invoice() throws IOException, InterruptedException {
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);
        SecureRandom rn = new SecureRandom();
        int st = rn.nextInt(3) + 1;

        login.Login();

        //COM
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("com_XPATH"))).click();

        //CREATE ORDER BUTTON
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Createorderbtn_XPATH"))).click();

        //SEARCH BY NAME
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SearchByName_XPATH"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SeaerchInput_XPATH"))).sendKeys(Utility.fetchLocator("CustomerName_TEXT"));
        driver.findElement(By.xpath(Utility.fetchLocator("Searchbtn_XPATH"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("ViewDetails_XPATH"))).click();

        //SEARCH PRODUCT
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SearchProductinput_XPATH"))).sendKeys(Utility.fetchLocator("ID_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SearchProductbtnq_XPATH"))).click();

        //Add button
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AddBTN_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("jjregion_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        Thread.sleep(2000);
        WebElement ele111 = driver.findElement(By.xpath(Utility.fetchLocator("SelectRegion_XPATH")));
        Select sel11 = new Select(ele111);
        sel11.selectByIndex(st);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PaymentOptions_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayInVoice_XPATH"))).click();

        WebElement tid = driver.findElement(By.xpath(Utility.fetchLocator("PaymentOptions_XPATH")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", tid);

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("GenerateOrderCode_XPATH"))).click();
        test.log(Status.PASS, "Order Code Was Generated Successfully");

        Thread.sleep(2000);
        login.AcceptAlert();

        Thread.sleep(1500);
        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("SendOrderConfirmation_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("Send Order Confirmation")) {
            test.log(Status.PASS, "Order Confirmation page is Functional");
        } else {
            test.log(Status.FAIL, "Failed to Load Order confirmation Page");
        }

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SendOrderConfirmation_XPATH"))).click();

        Thread.sleep(1300);
        driver.findElement(By.xpath(Utility.fetchLocator("PayNowPayAccount_XPATH"))).click();

        Thread.sleep(1300);
        screenshot.ScreenShot();
        driver.findElement(By.xpath(Utility.fetchLocator("PayfromAccount_XPATH"))).click();
        test.log(Status.PASS, "Pay from Account Fully Functional");

        Thread.sleep(2000);
        login.AcceptAlert();

    }
}
