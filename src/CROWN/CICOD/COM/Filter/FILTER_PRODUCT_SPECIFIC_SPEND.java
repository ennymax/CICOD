package CROWN.CICOD.COM.Filter;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;

public class FILTER_PRODUCT_SPECIFIC_SPEND extends TestBase {
    @Test
    public void FILTER_PRODUCT_SPECIFIC_SPEND() throws IOException, InterruptedException, AWTException {
        test = extent.createTest("FILTER PRODUCT SPECIFIC SPEND");
        Login login = new Login(driver);
        Utility utility = new Utility(driver);

        login.Login();
        utility.DoclickWhenReady("com_XPATH", "comm_TEXT", 60);
        utility.DoclickWhenReady("LoyaltyBTN_XPATH", "LoyaltyBTN_TEXT", 40);
        utility.DoclickWhenReady("CreateProductSpecificSpendBTN_XPATH", "pss_TEXT", 40);

        //Product
        utility.DoSendKeysWhenReadyEnter("Fproduct_XPATH", "Fproduct_TEXT", "Fproduct_TEXT", 40);
        utility.DoAssertXpathPresentWhenReady("AssertPa_XPATH", "Fpassmsg_TEXT", "FFailmsg_TEXT", 15);
        driver.findElement(By.xpath(Utility.fetchLocator("Fproduct_XPATH"))).clear();

        //Product Spend
        utility.DoSendKeysWhenReadyEnter("ProductPoint_XPATH", "Productpoint_XPATH", "Productpoint_XPATH", 40);
        utility.DoAssertXpathPresentWhenReady("AssertPa_XPATH", "pppassmsg_TEXT", "ppailmsg_TEXT", 15);
        driver.findElement(By.xpath(Utility.fetchLocator("Productspend_XPATH"))).clear();

        //Product Point
        utility.DoSendKeysWhenReadyEnter("ProductPoint_XPATH", "Productpoint_XPATH", "Productpoint_XPATH", 40);
        utility.DoAssertXpathPresentWhenReady("AssertPa_XPATH", "pppassmsg_TEXT", "ppailmsg_TEXT", 15);
        driver.findElement(By.xpath(Utility.fetchLocator("Productspend_XPATH"))).clear();
    }
}
