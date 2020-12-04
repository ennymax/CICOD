package CROWN.CICOD.COM.Filter;

import CROWN.Base.TestBase;
import CROWN.utility.Login;
import CROWN.utility.Utility;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;

public class FILTER_ORDER_HISTORY extends TestBase {
    @Test
    public void FILTER_ORDER_HISTORY() throws IOException, InterruptedException, AWTException {
        Login login = new Login(driver);
        Utility utility = new Utility(driver);

        login.Login();

        utility.DoclickWhenReady("com_XPATH", "comm_TEXT", 60);
        utility.DoclickWhenReady("OrderHist_XPATH", "OrderHsi_TEXT", 40);

        //Date
        utility.DoSendKeysWhenReadyEnter("sOrdeHistoryDate", "date_TEXT", "date_TEXT", 40);
        utility.DoAssertXpathPresentWhenReady("AssertDstOrde_XPATH", "FilterOpass_TEXT", "FilterOfail_TEXT", 15);
        driver.findElement(By.xpath(Utility.fetchLocator("sOrdeHistoryDate"))).clear();

        //Customer ID
        utility.DoSendKeysWhenReadyEnter("FilterOrderID_XPATH", "AssertOrderhist_TEXT", "AssertOrderhist_TEXT", 40);
        utility.DoAssertXpathPresentWhenReady("AssertDstOrde_XPATH", "FilterOpassID_TEXT", "FilterOfailID_TEXT", 15);
        driver.findElement(By.xpath(Utility.fetchLocator("FilterOrderID_XPATH"))).clear();

        //Name
        utility.DoSendKeysRobotClassFluentWait("fna_XPATH", "filternamT_TEXT", "filternamT_TEXT", 60);
        utility.DoAssertXpathPresentWhenReady("AssertDstOrde_XPATH", "FilterOpassAmt_TEXT", "FilterOfailAmt_TEXT", 15);
        utility.DoClearActionclassWhenReady("fna_XPATH", 40);

        //Amount
        utility.DoSendKeysWhenReadyEnter("FilterAmountOrderHist_XPATH", "filterAmount_TEXT", "filterAmount_TEXT", 60);
        utility.DoAssertXpathPresentWhenReady("AssertDstOrde_XPATH", "FilterOpassAmt_TEXT", "FilterOfailAmt_TEXT", 15);
        driver.findElement(By.xpath(Utility.fetchLocator("FilterAmountOrderHist_XPATH"))).clear();

        //Delivery
        utility.DoSendKeysWhenReadyEnter("FilterDel_XPATH", "Delifee_TEXT", "Delifee_TEXT", 60);
        utility.DoAssertXpathPresentWhenReady("AssertDstOrde_XPATH", "FilterOpassAmt_TEXT", "FilterOfailAmt_TEXT", 15);
        driver.findElement(By.xpath(Utility.fetchLocator("FilterDel_XPATH"))).clear();

        //Account Balance
        utility.DoSendKeysWhenReadyEnter("FiltetAcctbal_XPATH", "Delifee_TEXT", "Delifee_TEXT", 60);
        utility.DoAssertXpathPresentWhenReady("AssertDstOrde_XPATH", "FilterOpassAcctbal_TEXT", "FilterOfailAcctbal_TEXT", 15);
        driver.findElement(By.xpath(Utility.fetchLocator("FiltetAcctbal_XPATH"))).clear();

        //Creditlimit
        utility.DoSendKeysWhenReadyEnter("FilterCreditlimi_XPATH", "filterAmount_TEXT", "filterAmount_TEXT", 60);
        utility.DoAssertXpathPresentWhenReady("AssertDstOrde_XPATH", "FilterOpassCreditlimi_TEXT", "FilterOfailCreditLimi_TEXT", 15);
        driver.findElement(By.xpath(Utility.fetchLocator("FilterCreditlimi_XPATH"))).clear();

        //Credit Note
        utility.DoSendKeysWhenReadyEnter("AssertCreitNote_XPATH", "Delifee_TEXT", "Delifee_TEXT", 60);
        utility.DoAssertXpathPresentWhenReady("AssertDstOrde_XPATH", "FilterOpassCrNote_TEXT", "FilterOfailCrenote_TEXT", 15);
        driver.findElement(By.xpath(Utility.fetchLocator("AssertCreitNote_XPATH"))).clear();

        //Order Chennel
        utility.DoSelectValuesByVisibleText("FiltChnel_XPATH", "t1_TEXT", "t1_TEXT", 30);
        utility.DoAssertXpathPresentWhenReady("t1ASS_XPATH", "FilterOpasst1_TEXT", "FilterOfailt1_TEXT", 15);

        utility.DoSelectValuesByVisibleText("FiltChnel_XPATH", "t2_TEXT", "t2_TEXT", 30);
        utility.DoAssertXpathPresentWhenReady("AssertDstOrde_XPATH", "FilterOpasst2_TEXT", "FilterOfailt2_TEXT", 15);

        utility.DoSelectValuesByVisibleText("FiltChnel_XPATH", "t3_TEXT", "t3_TEXT", 30);
        utility.DoAssertXpathPresentWhenReady("t3Asser_XPATH", "FilterOpasst3_TEXT", "FilterOfailt3_TEXT", 15);

        utility.DoSelectValuesByVisibleText("FiltChnel_XPATH", "t4_TEXT", "t4_TEXT", 30);
        utility.DoAssertXpathPresentWhenReady("t4Assert_XPATH", "FilterOpasst4_TEXT", "FilterOfailt4_TEXT", 15);
        utility.DoSelectValuesByIndex("FiltChnel_XPATH", "t5_TEXT", 0, 30);

        //InVoice Number
        utility.DoSendKeysWhenReadyEnter("Invoicenum_XPATH", "invoiceNum_TEXT", "invoiceNum_TEXT", 60);
        utility.DoAssertXpathPresentWhenReady("AssertInvoiceFilt_XPATH", "FilterOpassinvo_TEXT", "FilterOfailinvo_TEXT", 15);
        driver.findElement(By.xpath(Utility.fetchLocator("Invoicenum_XPATH"))).clear();

        //Payment Mode
        utility.DoSelectValuesByVisibleText("PaymentMode_XPATH", "mode1_TEXT", "mode1_TEXT", 30);
        utility.DoAssertXpathPresentWhenReady("Assertmode1_XPATH", "FilterOpassinvomide_TEXT", "FilterOfailinvomod_TEXT", 15);

        utility.DoSelectValuesByVisibleText("PaymentMode_XPATH", "mode2_TEXT", "mode2_TEXT", 30);
        utility.DoAssertXpathPresentWhenReady("AssertMode2_XPATH", "FilterOpassinvomide2_TEXT", "FilterOfailinvomod2_TEXT", 15);

        utility.DoSelectValuesByVisibleText("PaymentMode_XPATH", "mode3_TEXT", "mode3_TEXT", 30);
        utility.DoAssertXpathPresentWhenReady("Assertmod3_XPATH", "FilterOpassinvomide3_TEXT", "FilterOfailinvomod3_TEXT", 15);

        utility.DoSelectValuesByVisibleText("PaymentMode_XPATH", "mode4_TEXT", "mode4_TEXT", 30);
        utility.DoAssertXpathPresentWhenReady("AssertMode4_XPATH", "FilterOpassinvomide4_TEXT", "FilterOfailinvomod4_TEXT", 15);

        utility.DoSelectValuesByVisibleText("PaymentMode_XPATH", "mode5_TEXT", "mode5_TEXT", 30);
        utility.DoAssertXpathPresentWhenReady("AssertMode5_XPATH", "FilterOpassinvomide5_TEXT", "FilterOfailinvomod5_TEXT", 15);

        utility.DoSelectValuesByVisibleText("PaymentMode_XPATH", "mode6_TEXT", "mode6_TEXT", 30);
        utility.DoAssertXpathPresentWhenReady("Assertmode6_XPATH", "FilterOpassinvomide6_TEXT", "FilterOfailinvomod6_TEXT", 15);

        utility.DoSelectValuesByVisibleText("PaymentMode_XPATH", "mode7_TEXT", "mode7_TEXT", 30);
        utility.DoAssertXpathPresentWhenReady("Assertmode7_XPATH", "FilterOpassinvomide7_TEXT", "FilterOfailinvomod7_TEXT", 15);
        utility.DoSelectValuesByIndex("PaymentMode_XPATH", "mode7_TEXT", 0, 30);

        //Filter By Delivery
        utility.DoSelectValuesByVisibleText("OrderHDeli_XPATH", "Order1_TEXT", "Order1_TEXT", 30);
        utility.DoAssertXpathPresentWhenReady("AssertOrder1_XPATH", "FilterOpassiDeli1_TEXT", "FilterOfailiDel1_TEXT", 15);

        utility.DoSelectValuesByVisibleText("OrderHDeli_XPATH", "Order2_TEXT", "Order2_TEXT", 30);
        utility.DoAssertXpathPresentWhenReady("Assertmod2_XPATH", "FilterOpassiDeli2_TEXT", "FilterOfailiDel2_TEXT", 15);

        utility.DoSelectValuesByVisibleText("OrderHDeli_XPATH", "Order3_TEXT", "Order3_TEXT", 30);
        utility.DoAssertXpathPresentWhenReady("Assertmode3_XPATH", "FilterOpassiDeli3_TEXT", "FilterOfailiDel3_TEXT", 15);
        utility.DoSelectValuesByIndex("OrderHDeli_XPATH", "Order3_TEXT", 0, 30);

        /*
        //Filter Pay_By_Bank_Transfer
        utility.DoSelectValuesByVisibleText("FilterPartpayment_XPATH","Part1_TEXT","Part1_TEXT",30);
        //utility.DoAssertXpathPresentWhenReady("AssertPart1_XPATH", "FilterOpassiParti3_TEXT", "FilterOfailiPart3_TEXT", 15);

        utility.DoSelectValuesByVisibleText("FilterPartpayment_XPATH","Part2_TEXT","Part2_TEXT",30);
       // utility.DoAssertXpathPresentWhenReady("AssertPart1_XPATH", "FilterOpassiParti3_TEXT", "FilterOfailiPart3_TEXT", 15);
       */

        //Filter By OrderStatus
        utility.DoSelectValuesByVisibleText("FilterByOrderStatus_XPATH", "OStatus1_TEXT", "OStatus1_TEXT", 30);
        utility.DoAssertXpathPresentWhenReady("Asserending_XPATH", "FilterOpasOSTA1_TEXT", "FilterOfaiOsat1_TEXT", 15);

        utility.DoSelectValuesByVisibleText("FilterByOrderStatus_XPATH", "OStatus2_TEXT", "OStatus2_TEXT", 30);
        utility.DoAssertXpathPresentWhenReady("Asserending_XPATH", "FilterOpasOSTA2_TEXT", "FilterOfaiOsat2_TEXT", 15);

        utility.DoSelectValuesByVisibleText("FilterByOrderStatus_XPATH", "OStatus3_TEXT", "OStatus3_TEXT", 30);
        utility.DoAssertXpathPresentWhenReady("AssertExpired_XPATH", "FilterOpasOSTA3_TEXT", "FilterOfaiOsat3_TEXT", 15);

        utility.DoSelectValuesByVisibleText("FilterByOrderStatus_XPATH", "OStatus4_TEXT", "OStatus4_TEXT", 30);
        utility.DoAssertXpathPresentWhenReady("Assertcancelled_XPATH", "FilterOpasOSTA4_TEXT", "FilterOfaiOsat4_TEXT", 15);
        utility.DoSelectValuesByIndex("FilterByOrderStatus_XPATH", "OStatus4_TEXT", 0, 30);

        //utility.DoSelectValuesByVisibleText("FilterByOrderStatus_XPATH","OStatus5_TEXT","OStatus5_TEXT",30);
        //utility.DoAssertXpathPresentWhenReady("Assertcancelled_XPATH", "FilterOpasOSTA5_TEXT", "FilterOfaiOsat5_TEXT", 15);

        // utility.DoSelectValuesByVisibleText("FilterByOrderStatus_XPATH","OStatus6_TEXT","OStatus6_TEXT",30);
        // utility.DoAssertXpathPresentWhenReady("Assertcancelled_XPATH", "FilterOpasOSTA6_TEXT", "FilterOfaiOsat6_TEXT", 15);


        //Filter By Payment Status
        utility.DoSelectValuesByVisibleText("FilterByOrderStatus_XPATH", "OStatus1_TEXT", "OStatus1_TEXT", 30);
        utility.DoAssertXpathPresentWhenReady("Asserending_XPATH", "FilterOpasOSTA1_TEXT", "FilterOfaiOsat1_TEXT", 15);
    }
}
