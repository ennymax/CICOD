package CICOD.ModuleCOM.CreateOrder;

import CICOD.base.TestBase;
import CICOD.utility.Login;
import CICOD.utility.ScreenShot;
import CICOD.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class VIEW_CUSTOMER_DETAIL extends TestBase {

    @Test
    public void VIEW_CUSTOMER_DETAILS() throws IOException, InterruptedException {
        test = extent.createTest("VIEW CUSTOMER");
        ScreenShot screenshot = new ScreenShot(driver);
        Login login = new Login(driver);
        Utility utility = new Utility(driver);

        login.Login();

        utility.DoclickWhenReady("com_XPATH", "comm_TEXT",60);
        utility.DoclickWhenReady("Createorderbtn_XPATH", "CreateOrder_TEXT",40);
        screenshot.ScreenShotWebElement("SearchByName_XPATH", 30);
        utility.DoclickWhenReady("SearchByName_XPATH", "SearchBox_TEXT",40);
        utility.DoSendKeysWhenReady("SeaerchInput_XPATH","CustomerFirstname_TEXT","CustomerFirstname_TEXT", 40);
        utility.DoclickWhenReady("Searchbtn_XPATH", "SearchBTN_TEXT",40);
        utility.DoAssertXpathPresentWhenReady("SearchByNameAssertion_XPATH","Searched_TEXT","Sbynamepass_TEXT", 40);
        utility.DoscrolltoViewClickWhenReady("ViewDetails_XPATH", "Cus_TEXT",40);
        utility.DoAssertXpathPresentWhenReady("assertdisplayeddetails_XPATH","Cus_TEXT","DisMessag_TEXT", 20);
        screenshot.ScreenShotWebElement("assertdisplayeddetails_XPATH", 30);
    }
}