package CROWN.CICOD.COM.CreateOrder;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.RavePay;
import CROWN.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.io.IOException;

public class PayAccount extends TestBase {
    @Test
    public void Pay_Account() throws IOException, InterruptedException {
        test = extent.createTest("PAY ACCOUNT");
        Login login = new Login(driver);
        RavePay ravePay = new RavePay(driver);
        Utility utility = new Utility(driver);

        login.Login();

        utility.DoclickWhenReady("com_XPATH", "comm_TEXT",60);
        utility.DoclickWhenReady("Createorderbtn_XPATH", "CreateOrder_TEXT",40);
        utility.DoclickWhenReady("SearchByName_XPATH", "SearchBox_TEXT",40);
        utility.DoSendKeysWhenReady("SeaerchInput_XPATH", "CustomerName_TEXT","CustomerName_TEXT", 40);
        utility.DoclickWhenReady("Searchbtn_XPATH", "SearchBTN_TEXT",40);
        utility.DoclickWhenReady("ViewDetails_XPATH", "ViewD_TEXT",40);
        utility.DoSendKeysWhenReady("SearchProductinput_XPATH", "ID_TEXT","ID_TEXT", 40);
        utility.DoclickWhenReady("SearchProductbtnq_XPATH", "SearchProductBTN_TEXT",40);
        utility.DoclickWhenReady("AddBTN_XPATH", "add_TEXT",40);

        Thread.sleep(2000);
        WebElement ti11kk = driver.findElement(By.xpath(Utility.fetchLocator("jjregion_XPATH")));
        JavascriptExecutor jsekk = (JavascriptExecutor) driver;
        jsekk.executeScript("arguments[0].scrollIntoView();", ti11kk);
        ti11kk.click();

        Thread.sleep(2000);
        WebElement ele111ll = driver.findElement(By.xpath(Utility.fetchLocator("SelectRegion_XPATH")));
        Select sel11ll = new Select(ele111ll);
        sel11ll.selectByIndex(2);

        utility.DoscrolltoViewClickWhenReady("PaymentOptions_XPATH","PaymentOPT_TEXT",50);
        utility.DoclickWhenReady("NewPayAccount_XPATH", "Payno_TEXT",40);
        utility.DoscrolltoViewClickWhenReady("MakePayment_XPATH", "MakePayment_TEXT",40);
        utility.DowaitandAcceptAlerwhenReady(60);
        utility.DoAssertContainsWhenReady("AssertOrdeIDgenerated_XPATH", "OrDerID_TEXT","OrDerID_TEXT", "OrderIDPass_TEXT",30);
        utility.DoclickWhenReady("PayNowPayAccount_XPATH", "PayAcct_TEXT",40);
        utility.DoclickWhenReady("PayOnline_XPATH", "PAyOnline_TEXT",40);
        utility.DoswitchtoframeWhenReady(0, 13000);
        ravePay.RavePay3();
    }
}