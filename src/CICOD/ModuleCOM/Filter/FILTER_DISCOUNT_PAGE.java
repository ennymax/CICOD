package CICOD.ModuleCOM.Filter;

import CICOD.base.TestBase;
import CICOD.utility.Login;
import CICOD.utility.RavePay;
import CICOD.utility.Utility;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

public class FILTER_DISCOUNT_PAGE extends TestBase {
    @Test
    public void FILTER_DISCOUNT_PAGE() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("FILTER DISCOUNT PAGE");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.cicod.com/login");

        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        Login login = new Login(driver);
        Utility utility = new Utility(driver);

        login.Login();
        utility.DoclickWhenReady("com_XPATH", "comm_TEXT", 60);
        utility.DoclickWhenReady("DIscountBTN_XPATH", "Disbtn_TEXT", 40);

        //Regiom
        utility.DoSendKeysWhenReadyEnter("DiscountRegion_XPATH", "DiscountRegion_TEXT", "DiscountRegion_TEXT", 40);
        utility.DoAssertXpathPresentWhenReady("AssertRegionagegePresent_XPATH", "Regpassmsg_TEXT", "RegFailmsg_TEXT", 15);
        driver.findElement(By.xpath(Utility.fetchLocator("DiscountRegion_XPATH"))).clear();

        //Percentage
        utility.DoSendKeysWhenReadyEnter("DiscountPercentage_XPATH", "DPercent_TEXT", "DPercent_TEXT", 40);
        utility.DoAssertXpathPresentWhenReady("AssertRegionagegePresent_XPATH", "percpassmsg_TEXT", "percpassmsg_TEXT", 15);
        driver.findElement(By.xpath(Utility.fetchLocator("DiscountPercentage_XPATH"))).clear();

        //Date
        utility.DoSendKeysWhenReadyEnter("Disp_XPATH", "Disp_TEXT", "Disp_TEXT", 40);
        utility.DoAssertXpathPresentWhenReady("AssertRegionagegePresent_XPATH", "Disppassmsg_TEXT", "DispFailmsg_TEXT", 15);
        driver.findElement(By.xpath(Utility.fetchLocator("Disp_XPATH"))).clear();

        //Status
        utility.DoSelectValuesByVisibleText("FStatus_XPATH","vv_TEXT","vv_TEXT",60);
        utility.DoAssertXpathPresentWhenReady("AssertRegionagegePresent_XPATH", "fstapassmsg_TEXT", "fstaFailmsg_TEXT", 15);
        utility.DoSelectValuesByIndex("FStatus_XPATH","vv_TEXT",0,60);

        //Created By
        utility.DoSendKeysWhenReadyEnter("DCreatedby_XPATH", "DCreatedby_TEXT", "DCreatedby_TEXT", 40);
        utility.DoAssertXpathPresentWhenReady("AssertRegionagegePresent_XPATH", "Dcreatedbypassmsg_TEXT", "DcreatedbyFailmsg_TEXT", 15);
        driver.findElement(By.xpath(Utility.fetchLocator("DCreatedby_XPATH"))).clear();

        //Created Date
        utility.DoSendKeysWhenReadyEnter("Fcreateddate_XPATH", "Fcreateddate_TEXT", "Fcreateddate_TEXT", 40);
        utility.DoAssertXpathPresentWhenReady("AssertRegionagegePresent_XPATH", "Fcreateddatepassmsg_TEXT", "FcreateddateFailmsg_TEXT", 15);
        driver.findElement(By.xpath(Utility.fetchLocator("Fcreateddate_XPATH"))).clear();

        driver.quit();
    }
}
