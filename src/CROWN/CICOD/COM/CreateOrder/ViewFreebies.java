package CROWN.CICOD.COM.CreateOrder;

import CROWN.Base.TestBase;
import CROWN.utility.Assertion;
import CROWN.utility.JavaScriptUtil;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.io.IOException;
import java.security.SecureRandom;

import static org.testng.AssertJUnit.assertEquals;

public class ViewFreebies extends TestBase {
    @Test
    public void VIEW_FREEBIES() throws IOException, InterruptedException {
        Login login = new Login(driver);
        SecureRandom rn = new SecureRandom();
        int st = rn.nextInt(3) + 1;
        Utility utility = new Utility(driver);
        Assertion assertion = new Assertion(driver);
        JavaScriptUtil actionsClass = new JavaScriptUtil(driver);

        login.Login();

        utility.DoclickWhenReady("com_XPATH", "comm_TEXT",60);
        utility.DoclickWhenReady("Createorderbtn_XPATH", "CreateOrder_TEXT",40);
        utility.DoclickWhenReady("SearchByName_XPATH", "SearchBox_TEXT",40);
        utility.DoSendKeysWhenReady("SeaerchInput_XPATH","CustomerFirstname_TEXT" ,"CustomerName_TEXT", 40);
        utility.DoclickWhenReady("Searchbtn_XPATH", "SearchBTN_TEXT",40);
        actionsClass.DoscrolltoViewClickWhenReady("ViewDetails_XPATH", "Cus_TEXT",40);


        assertion.DoAssertContainsWhenReady("AssertSearchByName_XPATH", "Searched_TEXT","em_TEXT", "SBN_TEXT",30);

        //SEARCH PRODUCT
        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SearchProductinput_XPATH"))).sendKeys(Utility.fetchLocator("ql_TEXT"));

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("SearchProductbtnq_XPATH"))).click();

        Thread.sleep(2000);
        WebElement ti11z = driver.findElement(By.xpath(Utility.fetchLocator("AddBTNQ_XPATH")));
        JavascriptExecutor jsez = (JavascriptExecutor) driver;
        jsez.executeScript("arguments[0].scrollIntoView();", ti11z);
        ti11z.click();

        Thread.sleep(2000);
        WebElement ti11 = driver.findElement(By.xpath(Utility.fetchLocator("ViewFreebies_XPATH")));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", ti11);
        ti11.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("quiCheck_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("AddQui_XPATH"))).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("Offer1_XPATH"))).click();

        Thread.sleep(900);
        if (driver.findElements(By.xpath(Utility.fetchLocator("assFreebies_XPATH"))).size() != 0) {
            test.log(Status.PASS, "FreeBies can be Viewed");
        } else {
            test.log(Status.FAIL, "FeeBies cant be viewed");
        }

        Thread.sleep(2000);
        assertEquals("quill (Soft drinks)\n" + "Delete\n" + "Quantity\n" + "1\n" + "₦0.00", driver.findElement(By.xpath(Utility.fetchLocator("Assertfreebies_XPATH"))).getText());
        test.log(Status.PASS, "Confirmed Freebies was added Successfully");

        Thread.sleep(2000);
        WebElement ti11kk = driver.findElement(By.xpath(Utility.fetchLocator("jjregion_XPATH")));
        JavascriptExecutor jsekk = (JavascriptExecutor) driver;jse.executeScript("arguments[0].scrollIntoView();", ti11kk);
        ti11kk.click();

        Thread.sleep(2000);
        WebElement ele111ll = driver.findElement(By.xpath(Utility.fetchLocator("SelectRegion_XPATH")));
        Select sel11ll = new Select(ele111ll);
        sel11ll.selectByIndex(st);

        Thread.sleep(2000);
        WebElement ti112lll = driver.findElement(By.xpath(Utility.fetchLocator("MakePayment_XPATH")));
        JavascriptExecutor jse2lll = (JavascriptExecutor) driver;
        jse2lll.executeScript("arguments[0].scrollIntoView();", ti112lll);
        ti112lll.click();

        Thread.sleep(2000);
        driver.findElement(By.xpath(Utility.fetchLocator("PayPoS_XPATH"))).click();

        Thread.sleep(4000);
        driver.findElement(By.xpath(Utility.fetchLocator("ConfirmPAymantPOS_XPATH"))).click();

        Thread.sleep(200);
        WebElement msg11 = driver.findElement(By.xpath(Utility.fetchLocator("ComfirmPOSPayment_XPATH")));
        String text11 = msg11.getText();
        if (msg11.isEnabled() && text11.contains("Payment yet to be received on Order")) {
            test.log(Status.PASS, "Pay with POS Functional");
        } else {
            test.log(Status.FAIL, "Pay with POS Failed");
        }

        Thread.sleep(2000);
        WebElement ti11kkp = driver.findElement(By.xpath(Utility.fetchLocator("jjregion_XPATH")));
        JavascriptExecutor jsekkp = (JavascriptExecutor) driver;
        jsekkp.executeScript("arguments[0].scrollIntoView();", ti11kkp);
        ti11kkp.click();

        Thread.sleep(2000);
        WebElement ele111llq = driver.findElement(By.xpath(Utility.fetchLocator("SelectRegion_XPATH")));
        Select sel11lla = new Select(ele111llq);
        sel11lla.selectByIndex(2);

        actionsClass.DoscrolltoViewClickWhenReady("PaymentOptions_XPATH","PaymentOPT_TEXT",50);
        utility.DoclickWhenReady("NewPayAccount_XPATH", "Payno_TEXT",40);
        actionsClass.DoscrolltoViewClickWhenReady("MakePayment_XPATH", "MakePayment_TEXT",40);
        utility.DowaitandAcceptAlerwhenReady(60);
        assertion.DoAssertContainsWhenReady("AssertOrdeIDgenerated_XPATH", "OrDerID_TEXT","OrDerID_TEXT", "OrderIDPass_TEXT",30);
    }
}
