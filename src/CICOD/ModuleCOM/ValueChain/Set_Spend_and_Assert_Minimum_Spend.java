package CICOD.ModuleCOM.ValueChain;

import CICOD.base.TestBase;
import CICOD.utility.Login;
import CICOD.utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Set_Spend_and_Assert_Minimum_Spend extends TestBase {
    @Test
    public void Set_Spend_and_Assert_Minimum_Spend() throws IOException, InterruptedException {
        test = extent.createTest("Set Minimum Spend and Assert Minimum Spend");
        Login login = new Login(driver);
        Utility utility = new Utility(driver);

        login.Login();

        utility.DoclickWhenReady("com_XPATH", "comm_TEXT",60);
        utility.DoclickWhenReady("ValuechainBTN_XPATH", "VChainbtn_TEXT",60);
        utility.DoclickWhenReady("ValuechainByers_XPATH", "Buyersbtn_TEXT",60);
        utility.DoclickWhenReady("BuyerActionBTN_XPATH", "BuyerActbtn_TEXT",60);
        utility.DoscrolltoViewClickWhenReady("SetminimumspendBTN_XPATH","mimiSpedn_TEXT",60);
        utility.DoSendKeysWhenReady("InputMiniSp_XPATH","SpenAMt_TEXT","SpenAMt_TEXT",60);
        utility.DoscrolltoViewClickWhenReady("SaveMiniSpend_XPATH","Savem_TEXT",60);
        utility.DoAssertContainsWhenReady("Assertminispendalert_XPATH","Conty_TEXT","minispendasspass_TEXT","minispendassertfail_TEXT",60);

        Thread.sleep(2000);
        driver.navigate().to("https://www.cicod.com/login");

        login.LoginDefault();

        utility.DoclickWhenReady("com_XPATH", "comm_TEXT",60);
        utility.DoclickWhenReady("ValuechainBTN_XPATH", "VChainbtn_TEXT",60);
        utility.DoclickWhenReady("Suppliers_XPATH", "VChainbtn_TEXT",60);
        utility.DoscrolltoViewClickWhenReady("BuyerActionBTN_XPATH","But_TEXT",60);
        utility.DoscrolltoViewClickWhenReady("SuppliersProduct_XPATH","Supplbu_TEXT",60);
        utility.DoscrolltoViewClickWhenReady("CreateOrderfromSuppler_XPATH","CretOrer_TEXT",60);
        utility.DoAssertEqualWhenReady("AssertMinimuspend_XPATH","1,000.00",60);
        utility.DoscrolltoViewClickWhenReady("ProductCategoryPlus_XPATH","ProductCa_TEXT",60);
        utility.DoscrolltoViewClickWhenReady("SelectBeverages_XPATH","SelectBeve_TEXT",60);
        utility.DoscrolltoViewClickWhenReady("AddProduct_XPATH","Addpro_TEXT",60);
        utility.DoscrolltoViewClickWhenReady("AddProduct_XPATH","Addpro_TEXT",60);
        utility.DoscrolltoViewClickWhenReady("AddProduct_XPATH","Addpro_TEXT",60);
        utility.DoscrolltoViewClickWhenReady("AddProduct_XPATH","Addpro_TEXT",60);
        utility.DoscrolltoViewClickWhenReady("AddProduct_XPATH","Addpro_TEXT",60);
        utility.DoscrolltoViewClickWhenReady("MakePayment_XPATH","Makepa_TEXT",60);
        utility.DoscrolltoViewClickWhenReady("PayOnline_XPATH","Payoo_TEXT",60);
        utility.DoswitchtoframeWhenReady(0,13000);
        utility.DoAssertEqualWhenReady("ASSenable_XPATH","NGN1,522.50",90);

        Thread.sleep(2000);
        driver.navigate().to("https://www.cicod.com/login");

        login.Login();

        utility.DoclickWhenReady("com_XPATH", "comm_TEXT",60);
        utility.DoclickWhenReady("ValuechainBTN_XPATH", "VChainbtn_TEXT",60);
        utility.DoclickWhenReady("ValuechainByers_XPATH", "Buyersbtn_TEXT",60);
        utility.DoclickWhenReady("BuyerActionBTN_XPATH", "BuyerActbtn_TEXT",60);
        utility.DoscrolltoViewClickWhenReady("SetminimumspendBTN_XPATH","mimiSpedn_TEXT",60);
        driver.findElement(By.xpath(Utility.fetchLocator("InputMiniSp_XPATH"))).clear();
        driver.findElement(By.xpath(Utility.fetchLocator("InputMiniSp_XPATH"))).sendKeys("1");
        utility.DoscrolltoViewClickWhenReady("SaveMiniSpend_XPATH","Savem_TEXT",60);
    }
}
