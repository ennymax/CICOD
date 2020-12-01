package CROWN.CICOD.ModuleCOM.Filter;

import CROWN.base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;

public class FILTER_DISCOUNT_PAGE extends TestBase {
    @Test
    public void FILTER_DISCOUNT_PAGE() throws IOException, InterruptedException, AWTException {
        Login login = new Login(driver);
        Utility utility = new Utility(driver);

        login.Login();
        utility.DoclickWhenReady("com_XPATH", "comm_TEXT", 60);
        utility.DoclickWhenReady("DIscountBTN_XPATH", "Disbtn_TEXT", 40);

        //Regiom
        utility.DoSendKeysWhenReadyEnter("DiscountRegion_XPATH", "DiscountRegion_TEXT", "DiscountRegion_TEXT", 40);
        utility.DoAssertXpathPresentWhenReady("AssertRegionagegePresent_XPATH", "Regpassmsg_TEXT", "RegFailmsg_TEXT", 15);
        utility.DoAssertXpathAbsentWhenReady("Assertabs_XPATH", "Regpassmsg_TEXT", "RegFailmsg_TEXT", 15);
        driver.findElement(By.xpath(Utility.fetchLocator("DiscountRegion_XPATH"))).clear();

        //Percentage
        utility.DoSendKeysWhenReadyEnter("DiscountPercentage_XPATH", "DPercent_TEXT", "DPercent_TEXT", 40);
        utility.DoAssertXpathPresentWhenReady("AssertRegionagegePresent_XPATH", "percpassmsg_TEXT", "percFailmsg_TEXT", 15);
        utility.DoAssertXpathAbsentWhenReady("Assertabs_XPATH", "percpassmsg_TEXT", "percFailmsg_TEXT", 15);
        driver.findElement(By.xpath(Utility.fetchLocator("DiscountPercentage_XPATH"))).clear();

        //Date
        utility.DoSendKeysWhenReadyEnter("Disp_XPATH", "Disp_TEXT", "Disp_TEXT", 40);
        utility.DoAssertXpathPresentWhenReady("AssertRegionagegePresent_XPATH", "Disppassmsg_TEXT", "DispFailmsg_TEXT", 15);
        utility.DoAssertXpathAbsentWhenReady("Assertabs_XPATH", "Disppassmsg_TEXT", "DispFailmsg_TEXT", 15);
        driver.findElement(By.xpath(Utility.fetchLocator("Disp_XPATH"))).clear();

        //Status Active
        utility.DoSelectValuesByVisibleText("FStatus_XPATH","vv_TEXT","vv_TEXT",6);
        utility.DoAssertXpathPresentWhenReady("Activests_XPATH", "fstapassmsg_TEXT", "fstaFailmsg_TEXT", 5);
        utility.DoSelectValuesByIndex("FStatus_XPATH","vv_TEXT",0,6);

        //Status Suspended
        utility.DoSelectValuesByVisibleText("FStatus_XPATH","sus_TEXT","vv_TEXT",6);
        utility.DoAssertXpathAbsentWhenReady("AssertRegionagegePresent_XPATH", "fstapassmsg1_TEXT", "fstaFailmsg1_TEXT", 5);
        utility.DoAssertXpathAbsentWhenReady("Assertabs_XPATH", "fstapassmsg1_TEXT", "fstaFailmsg1_TEXT", 1);
        utility.DoSelectValuesByIndex("FStatus_XPATH","vv_TEXT",0,6);

        //Created By
        utility.DoSendKeysWhenReadyEnter("DCreatedby_XPATH", "DCreatedby_TEXT", "DCreatedby_TEXT", 4);
        utility.DoAssertXpathPresentWhenReady("AssertRegionagegePresent_XPATH", "Dcreatedbypassmsg_TEXT", "DcreatedbyFailmsg_TEXT", 5);
        utility.DoAssertXpathAbsentWhenReady("Assertabs_XPATH", "Dcreatedbypassmsg_TEXT", "DcreatedbyFailmsg_TEXT", 5);
        driver.findElement(By.xpath(Utility.fetchLocator("DCreatedby_XPATH"))).clear();

        //Created Date
        utility.DoSendKeysWhenReadyEnter("Fcreateddate_XPATH", "Fcreateddate_TEXT", "Fcreateddate_TEXT", 4);
        utility.DoAssertXpathPresentWhenReady("AssertRegionagegePresent_XPATH", "Fcreateddatepassmsg_TEXT", "FcreateddateFailmsg_TEXT", 5);
        driver.findElement(By.xpath(Utility.fetchLocator("Fcreateddate_XPATH"))).clear();
    }
}
