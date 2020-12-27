package CROWN.CICOD.COM.ValueChain;

import CROWN.Base.TestBase;
import CROWN.utility.Assertion;
import CROWN.utility.JavaScriptUtil;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.io.IOException;

public class Set_Minimum_Order_and_Assert_Minimum_Order extends TestBase {
    @Test
    public void Set_Minimum_Order_and_Assert_Minimum_Order() throws IOException, InterruptedException {
        Login login = new Login(driver);
        Utility utility = new Utility(driver);
        JavaScriptUtil javaScriptUtil = new JavaScriptUtil(driver);
        Assertion assertion = new Assertion(driver);


        login.Login();

        utility.DoclickWhenReady("com_XPATH", "comm_TEXT",60);
        utility.DoclickWhenReady("ValuechainBTN_XPATH", "VChainbtn_TEXT",60);
        utility.DoclickWhenReady("ValuechainByers_XPATH", "Buyersbtn_TEXT",60);
        utility.DoclickWhenReady("BuyerActionBTN_XPATH", "BuyerActbtn_TEXT",60);
        javaScriptUtil.DoscrolltoViewClickWhenReady("setminimumOrderBTN_XPATH","mii_TEXT",60);
        javaScriptUtil.DoscrolltoViewClickWhenReady("updatemini_XPATH","updatemini_TEXT",60);
        utility.DoSendKeysWhenReady("enterminiOre_XPATH","inputmim_TEXT","tt_TEXT",60);
        javaScriptUtil.DoscrolltoViewClickWhenReady("saveminiOrder_XPATH","SaveMiniOrder_TEXT",60);

        Thread.sleep(2000);
        driver.navigate().to("https://www.cicod.com/login");

        login.LoginDefault();

        utility.DoclickWhenReady("com_XPATH", "comm_TEXT",60);
        utility.DoclickWhenReady("ValuechainBTN_XPATH", "VChainbtn_TEXT",60);
        utility.DoclickWhenReady("Suppliers_XPATH", "VChainbtn_TEXT",60);
        javaScriptUtil.DoscrolltoViewClickWhenReady("BuyerActionBTN_XPATH","But_TEXT",60);
        javaScriptUtil.DoscrolltoViewClickWhenReady("SuppliersProduct_XPATH","Supplbu_TEXT",60);
        javaScriptUtil.DoscrolltoViewClickWhenReady("CreateOrderfromSuppler_XPATH","CretOrer_TEXT",60);
        javaScriptUtil.DoscrolltoViewClickWhenReady("ProductCategoryPlus_XPATH","ProductCa_TEXT",60);
        javaScriptUtil.DoscrolltoViewClickWhenReady("SelectBeverages_XPATH","SelectBeve_TEXT",60);
        javaScriptUtil.DoscrolltoViewClickWhenReady("AddProduct_XPATH","Addpro_TEXT",60);
        javaScriptUtil.DoscrolltoViewClickWhenReady("MakePayment_XPATH","Makepa_TEXT",60);
        javaScriptUtil.DoscrolltoViewClickWhenReady("PayOnline_XPATH","Payoo_TEXT",60);
        utility.DoswitchtoframeWhenReady(0,13000);
        assertion.DoAssertEqualWhenReady("ASSenable_XPATH","NGN304.50","AmimPass_TEXT","AminiFail_TEXT",90);

        Thread.sleep(2000);
        driver.navigate().to("https://www.cicod.com/login");

        login.Login();

        utility.DoclickWhenReady("com_XPATH", "comm_TEXT",60);
        utility.DoclickWhenReady("ValuechainBTN_XPATH", "VChainbtn_TEXT",60);
        utility.DoclickWhenReady("ValuechainByers_XPATH", "Buyersbtn_TEXT",60);
        utility.DoclickWhenReady("BuyerActionBTN_XPATH", "BuyerActbtn_TEXT",60);
        javaScriptUtil.DoscrolltoViewClickWhenReady("setminimumOrderBTN_XPATH","mii_TEXT",60);
        javaScriptUtil.DoscrolltoViewClickWhenReady("updatemini_XPATH","updatemini_TEXT",60);
        driver.findElement(By.xpath(Utility.fetchLocator("enterminiOre_XPATH"))).clear();
        driver.findElement(By.xpath(Utility.fetchLocator("enterminiOre_XPATH"))).sendKeys("1");
        javaScriptUtil.DoscrolltoViewClickWhenReady("saveminiOrder_XPATH","SaveMiniOrder_TEXT",60);
    }
}
