package CROWN.CICOD.WFM.WebForm;

import CROWN.Base.TestBase;
import CROWN.utility.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.springframework.context.annotation.Description;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;

@Epic("WebForm")
@Story("Test Webform Module Module..")
public class CreateWebform extends TestBase {

    @Description("Login to Cicod")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 1)
    public void login() throws IOException, InterruptedException {
        Login login = new Login(driver);
        login.Login();
    }

    @Description("Access WFM")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 2)
    public void WorkFlowManager() throws IOException, InterruptedException {
        ExcelUtil util = new ExcelUtil(driver);
        util.DoscrolltoViewClickWhenReady("Wfm_XPATH", 30);
    }

    @Description("Assert Successful Access of WFM")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 3)
    public void AssertWorkFlowManager() throws IOException, InterruptedException {
        Assertion assertion = new Assertion(driver);
        assertion.DoAssertXpathAbsentWhenReady("wfmConfig_XPATH", "EscalationPass_TEXT", "EscalationFailed_TEXT", 30);
    }

    @Description("Access Configuration")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 4)
    public void AccessConfiguration() throws IOException, InterruptedException {
        ActionsClass actionsClass = new ActionsClass(driver);
        actionsClass.DoClickActionclassWhenReady("wfmConfig_XPATH", 30);
    }

    @Description("Assert Webform and WorkOrder Extension")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 5)
    public void AssertWebForm_WorkOrderExtension() throws IOException, InterruptedException {
        Assertion assertion = new Assertion(driver);
        assertion.DoAssertXpathAbsentWhenReady("webform_XPATH", "WebPass_Text", "WebFailed_Text", 30);
        assertion.DoAssertXpathAbsentWhenReady("ExtendedWorkOrder_XPATH", "ExtendedPass_Text", "ExtendedFailed_Text", 30);
    }

    @Description("Access WebForm")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 6)
    public void Accesswebform() throws IOException, InterruptedException {
        ActionsClass actionsClass = new ActionsClass(driver);
        actionsClass.DoClickActionclassWhenReady("webform_XPATH", 30);
    }

    @Description("Create Web Form")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 7)
    public void CreateWebform() throws IOException, InterruptedException {
        JavaScriptUtil javaScriptUtil = new JavaScriptUtil(driver);
        javaScriptUtil.DoClickWhenReadyJS("CreateWebF_XPATH", 30);
    }

    @Description("Create Web Form")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 8)
    public void Webform_Name() throws IOException, InterruptedException {
        ActionsClass actionsClass = new ActionsClass(driver);
        Thread.sleep(5000);
        actionsClass.DoActionsSendKeysRandomListword("WebFormName_XPATH", 30);
    }

    @Description("Create Web Form Banner")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 9)
    public void Webform_Banner() throws IOException, InterruptedException, AWTException {
        FileUpload fileUpload = new FileUpload();
        ActionsClass actionsClass = new ActionsClass(driver);
        actionsClass.DoActionsSendKeysRandomListword("WebformBanner_XPATH", 30);
        fileUpload.UploadFileImage3MB();
    }

    @Description("Web Form Description")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 10)
    public void Webform_Description() throws IOException, InterruptedException, AWTException {
        ActionsClass actionsClass = new ActionsClass(driver);
        actionsClass.DoSendKeysByActionClassFluentWait("WebformDecritpion_XPATH", "Decrib_TEXT", 30);
    }

    @Description("Web Form Queue")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 11)
    public void Webform_Queue() throws IOException, InterruptedException, AWTException {
        ActionsClass actionsClass = new ActionsClass(driver);
        actionsClass.DoDoubleClickActionWhenReady("Webformqueue_XPATH", 30);
    }

    @Description("Search Queue")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 12)
    public void SearchQueue() throws IOException, InterruptedException, AWTException {
        ActionsClass actionsClass = new ActionsClass(driver);
        actionsClass.DoActionsSendKeys("SearchQue_XPATH","Ooo_TEXT",30);
    }

    @Description("Assert Search Queue")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 13)
    public void AssertSearchQueue() throws IOException, InterruptedException, AWTException {
       Assertion assertion = new Assertion(driver);
       assertion.DoAssertXpathPresentWhenReady("asorder_XPATH","Searchpass_TEXT","Searchfailed_TEXT",20);
    }

    @Description("Select Queue Type")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 14)
    public void SelectQueueType() throws IOException, InterruptedException, AWTException {
        Utility utility = new Utility(driver);
        utility.DoclickWhenReady("Orderr_XPATH","Ooo_TEXT",30);
        utility.DoclickWhenReady("wfmConfig_XPATH","Ooo_TEXT",30);
    }

    @Description("Web Form Queue Type")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 15)
    public void Webform_QueueType() throws IOException, InterruptedException, AWTException {
        ActionsClass actionsClass = new ActionsClass(driver);
        actionsClass.DoDoubleClickActionWhenReady("WebQueueT_XPATH", 30);
    }

    @Description("Webform_Queue Type PickUp")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 16)
    public void Webform_QueuetypePickUp() throws IOException, InterruptedException, AWTException {
        ActionsClass actionsClass = new ActionsClass(driver);
        Utility utility = new Utility(driver);
        actionsClass.DoClickWithMoveToElement("Pickup_XPATH", 30);
        utility.DoclickWhenReady("wfmConfig_XPATH","Ooo_TEXT",30);
    }

    @Description("Initila Email Response")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 17)
    public void InitialEmailResponse() throws IOException, InterruptedException, AWTException {
        ActionsClass actionsClass = new ActionsClass(driver);
        actionsClass.DoSendKeysByActionClassFluentWait("InitialEmailRespoms_XPATH", "Decrib_TEXT", 30);
    }

    @Description("Display From for a  Particular Period")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 18)
    public void DisplayFromPeriod() throws IOException, InterruptedException, AWTException {
        Utility utility = new Utility(driver);
        utility.DoclickWhenReady("DisplayformPeriod_XPATH","Ooo_TEXT",30);
    }

    @Description("StartDate")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 19)
    public void StartDate() throws IOException, InterruptedException, AWTException {
     DatePicker datePicker = new DatePicker(driver);
     datePicker.DatePickerJE("WebDatefrom_XPATH","2020-10-22");
    }

    @Description("EndDate")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 20)
    public void EndDate() throws IOException, InterruptedException, AWTException {
        DatePicker datePicker = new DatePicker(driver);
        Utility utility = new Utility(driver);
        datePicker.DatePickerJE("WebDateTo_XPATH","2021-10-22");
        utility.DoclickWhenReady("wfmConfig_XPATH","Ooo_TEXT",30);
    }

    @Description("EndDate")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 21)
    public void AllowAttachedFile() throws IOException, InterruptedException, AWTException {
        Utility utility = new Utility(driver);
        utility.DoclickWhenReady("AllowAttachedFi_XPATH","Ooo_TEXT",30);
    }

    @Description("Save Web Form")
    @Severity(SeverityLevel.CRITICAL)
    @Test(priority = 22)
    public void SaveWebForm() throws IOException, InterruptedException, AWTException {
        Utility utility = new Utility(driver);
        utility.DoclickWhenReady("Save_XPATH","Ooo_TEXT",30);
    }
}
